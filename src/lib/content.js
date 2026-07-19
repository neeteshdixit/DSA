import { countWords, estimateReadTime, excerpt, toSlug, unique } from '@/lib/format';
import { getTopicProfile, getTopicKey, topicColorClass } from '@/data/topicProfiles';

const rawLessonFiles = import.meta.glob(
  [
    '/**/*.txt',
    '!/**/node_modules/**',
    '!/**/.git/**',
    '!/**/.dist/**',
    '!/**/.agents/**',
    '!/**/.codex/**',
    '!/**/dist/**',
    '!/**/build/**',
  ],
  {
    eager: true,
    query: '?raw',
    import: 'default',
  },
);

function normalizePath(path = '') {
  return String(path).replaceAll('\\', '/');
}

function basename(path = '') {
  const parts = normalizePath(path).split('/').filter(Boolean);
  return parts[parts.length - 1] || path;
}

function stripBoilerplate(text = '') {
  return String(text)
    .replace(/\r\n/g, '\n')
    .replace(/^Java DSA Interview Bible.*\n?/i, '')
    .replace(/^Compiled Manuscript Draft.*\n?/i, '');
}

function extractHeaderMeta(content = '', fileName = '') {
  const lines = String(content)
    .replace(/\r\n/g, '\n')
    .split('\n')
    .map((line) => line.trim());
  const focus = lines.slice(0, 10).filter(Boolean);
  const volumeMatch = focus.find((line) => /^Volume\s+\d+/i.test(line));
  const labelLine = focus.find(
    (line) => !line.startsWith('#') && /.+:\s+.+/.test(line) && !/^Compiled Manuscript Draft/i.test(line),
  );
  const headingLine = focus.find((line) => /^#\s*Chapter\s+\d+:/i.test(line));
  const fileStem = fileName.replace(/\.txt$/i, '').replace(/^Java DSA Interview Bible\s*/i, '').trim();
  const volume = volumeMatch ? Number((volumeMatch.match(/(\d+)/) || [])[1] || 0) : null;
  const topicFromFile = fileStem.replace(/^Volume\s+\d+\s*/i, '').trim() || fileStem;

  if (labelLine) {
    const [topicPart, ...rest] = labelLine.split(':');
    const topic = topicPart.trim() || topicFromFile;
    const subtitle = rest.join(':').trim();
    return {
      title: subtitle ? `${topic}: ${subtitle}` : topic,
      topic,
      subtitle,
      volume,
      heading: headingLine ? headingLine.replace(/^#\s*/i, '') : '',
    };
  }

  return {
    title: topicFromFile,
    topic: topicFromFile,
    subtitle: headingLine ? headingLine.replace(/^#\s*/i, '') : '',
    volume,
    heading: headingLine ? headingLine.replace(/^#\s*/i, '') : '',
  };
}

function extractHeadings(content = '') {
  return String(content)
    .replace(/\r\n/g, '\n')
    .split('\n')
    .map((line) => line.trim())
    .filter((line) => /^#{1,4}\s+/.test(line))
    .map((line) => {
      const level = line.match(/^#{1,4}/)?.[0].length || 1;
      const text = line.replace(/^#{1,4}\s+/, '').trim();
      return {
        level,
        text,
        id: toSlug(text),
      };
    });
}

function createLessonRecord(path, raw) {
  const filePath = normalizePath(path);
  const fileName = basename(filePath);
  const content = stripBoilerplate(String(raw || ''));
  const meta = extractHeaderMeta(content, fileName);
  const topicKey = getTopicKey(meta.topic);
  const profile = getTopicProfile(meta.topic);
  const body = content.trim();
  const headings = extractHeadings(body);
  const words = countWords(body);
  const readTime = estimateReadTime(words);
  const excerptText = excerpt(body, 220);
  const searchBlob = [meta.title, meta.topic, meta.subtitle, body, headings.map((item) => item.text).join(' ')]
    .join(' ')
    .toLowerCase();
  const lessonSlug = toSlug(meta.title || fileName);
  const accent = profile.accent;

  return {
    type: 'lesson',
    slug: lessonSlug,
    filePath,
    fileName,
    title: meta.title,
    topic: meta.topic,
    topicKey,
    subtitle: meta.subtitle,
    heading: meta.heading,
    volume: meta.volume,
    profile,
    accent,
    cardClass: topicColorClass(accent),
    body,
    headings,
    excerpt: excerptText,
    words,
    readTime,
    sectionCount: headings.length,
    codeBlocks: (body.match(/```/g) || []).length / 2,
    tags: unique([
      topicKey,
      meta.topic?.toLowerCase(),
      ...(profile.tags || []),
    ]),
    searchBlob,
    collectionLabel: meta.volume ? `Volume ${meta.volume}` : meta.topic,
  };
}

export const LESSONS = Object.entries(rawLessonFiles)
  .map(([path, raw]) => createLessonRecord(path, raw))
  .sort((a, b) => {
    const volumeA = a.volume ?? Number.MAX_SAFE_INTEGER;
    const volumeB = b.volume ?? Number.MAX_SAFE_INTEGER;
    if (volumeA !== volumeB) return volumeA - volumeB;
    return a.title.localeCompare(b.title);
  });

export const LESSON_MAP = new Map(LESSONS.map((lesson) => [lesson.slug, lesson]));

const topicGroups = new Map();
for (const lesson of LESSONS) {
  const group = topicGroups.get(lesson.topicKey) || {
    key: lesson.topicKey,
    label: lesson.topic,
    profile: lesson.profile,
    lessons: [],
  };
  group.lessons.push(lesson);
  topicGroups.set(lesson.topicKey, group);
}

export const TOPICS = Array.from(topicGroups.values())
  .map((topic) => ({
    ...topic,
    count: topic.lessons.length,
    latest: topic.lessons[topic.lessons.length - 1] || null,
  }))
  .sort((a, b) => a.label.localeCompare(b.label));

export function getLessonBySlug(slug) {
  return LESSON_MAP.get(slug) || null;
}

export function getRelatedLessons(lesson, limit = 4) {
  if (!lesson) return [];
  return LESSONS.filter((item) => item.slug !== lesson.slug && item.topicKey === lesson.topicKey).slice(0, limit);
}

export function getLessonSummary(lesson) {
  if (!lesson) return null;
  return {
    title: lesson.title,
    topic: lesson.topic,
    readTime: lesson.readTime,
    sections: lesson.sectionCount,
    excerpt: lesson.excerpt,
    filePath: lesson.filePath,
    volume: lesson.volume,
  };
}

export function getDiscoveryStats() {
  return {
    lessons: LESSONS.length,
    topics: TOPICS.length,
    words: LESSONS.reduce((total, lesson) => total + lesson.words, 0),
    sections: LESSONS.reduce((total, lesson) => total + lesson.sectionCount, 0),
  };
}
