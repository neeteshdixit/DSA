import { excerpt, stripMarkdown, toSlug } from '@/lib/format';

function tokenize(query = '') {
  return query
    .toLowerCase()
    .trim()
    .split(/\s+/)
    .filter(Boolean);
}

function scoreText(text = '', tokens = []) {
  const normalized = String(text).toLowerCase();
  let score = 0;
  for (const token of tokens) {
    if (!token) continue;
    if (normalized === token) {
      score += 40;
      continue;
    }
    if (normalized.includes(token)) score += 8;
  }
  return score;
}

function scoreItem(item, query, fields) {
  const tokens = tokenize(query);
  if (!tokens.length) return 0;
  let score = 0;
  for (const field of fields) {
    score += scoreText(field, tokens);
  }
  if (toSlug(item.label || item.title || item.name).includes(query.toLowerCase().replace(/\s+/g, '-'))) {
    score += 10;
  }
  return score;
}

export function buildSearchResults(query, catalog = {}) {
  const q = String(query || '').trim();
  if (!q) return [];

  const results = [];
  const lessons = catalog.lessons || [];
  const patterns = catalog.patterns || [];
  const templates = catalog.templates || [];
  const questions = catalog.questions || [];

  for (const lesson of lessons) {
    const score = scoreItem(lesson, q, [
      lesson.title,
      lesson.topic,
      lesson.subtitle,
      lesson.tags?.join(' '),
      lesson.searchBlob,
    ]);
    if (score > 0) {
      results.push({
        type: 'lesson',
        id: lesson.slug,
        title: lesson.title,
        subtitle: lesson.subtitle || lesson.topic,
        meta: `${lesson.topic} • ${lesson.readTime} min`,
        excerpt: lesson.excerpt,
        score,
        href: `/lesson/${lesson.slug}`,
      });
    }
  }

  for (const pattern of patterns) {
    const score = scoreItem(pattern, q, [
      pattern.title,
      pattern.category,
      pattern.recognition,
      pattern.triggerWords?.join(' '),
      pattern.relatedProblems?.join(' '),
    ]);
    if (score > 0) {
      results.push({
        type: 'pattern',
        id: pattern.id,
        title: pattern.title,
        subtitle: pattern.category,
        meta: `${pattern.category} pattern`,
        excerpt: excerpt(pattern.recognition, 120),
        score,
        href: `/patterns/${pattern.id}`,
      });
    }
  }

  for (const template of templates) {
    const score = scoreItem(template, q, [
      template.title,
      template.summary,
      template.tags?.join(' '),
      stripMarkdown(template.code),
    ]);
    if (score > 0) {
      results.push({
        type: 'template',
        id: template.id,
        title: template.title,
        subtitle: template.category,
        meta: `${template.category} template`,
        excerpt: excerpt(template.summary, 120),
        score,
        href: `/templates/${template.id}`,
      });
    }
  }

  for (const question of questions) {
    const score = scoreItem(question, q, [
      question.title,
      question.company,
      question.topic,
      question.notes,
      question.tags?.join(' '),
    ]);
    if (score > 0) {
      results.push({
        type: 'question',
        id: question.id,
        title: question.title,
        subtitle: question.company || question.topic,
        meta: `${question.status} • ${question.difficulty}`,
        excerpt: excerpt(question.notes || '', 120),
        score,
        href: `/tracker`,
      });
    }
  }

  return results.sort((a, b) => b.score - a.score || a.title.localeCompare(b.title));
}

export function buildHighlights(query, catalog = {}) {
  const results = buildSearchResults(query, catalog);
  return {
    lessons: results.filter((item) => item.type === 'lesson'),
    patterns: results.filter((item) => item.type === 'pattern'),
    templates: results.filter((item) => item.type === 'template'),
    questions: results.filter((item) => item.type === 'question'),
  };
}
