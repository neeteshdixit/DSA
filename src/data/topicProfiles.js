import { toSlug } from '@/lib/format';

const TOPIC_PROFILES = {
  arrays: {
    label: 'Arrays',
    accent: 'cyan',
    summary: 'Array problems are usually about scanning, windows, subarrays, and in-place transformations.',
    patterns: ['two-pointers', 'sliding-window', 'prefix-sum-map', 'frequency-count', 'index-mapping'],
    templateIds: ['two-pointers', 'sliding-window', 'prefix-sum'],
    tags: ['subarray', 'window', 'prefix', 'in-place'],
  },
  strings: {
    label: 'Strings',
    accent: 'violet',
    summary: 'String questions often combine frequency counting, palindrome logic, windows, and anagram grouping.',
    patterns: ['frequency-count', 'sliding-window-hashmap', 'group-anagrams', 'first-unique-character'],
    templateIds: ['frequency-map', 'sliding-window', 'two-pointers'],
    tags: ['anagram', 'palindrome', 'window', 'character-count'],
  },
  hashing: {
    label: 'Hashing',
    accent: 'sky',
    summary: 'Hashing is the lookup accelerator behind counting, deduplication, prefix sums, and pairing.',
    patterns: ['frequency-count', 'pair-sum-two-sum', 'prefix-sum-map', 'group-anagrams', 'longest-consecutive'],
    templateIds: ['frequency-map', 'prefix-sum', 'two-sum'],
    tags: ['map', 'set', 'lookup', 'counting'],
  },
  'linked-list': {
    label: 'Linked List',
    accent: 'emerald',
    summary: 'Linked lists are pointer-driven structures where dummy nodes, fast-slow pointers, and reverse patterns matter.',
    patterns: ['fast-slow-pointer', 'dummy-node', 'reverse-linked-list', 'cycle-detection', 'merge-two-sorted-lists'],
    templateIds: ['dummy-node', 'fast-slow-pointer', 'reverse-linked-list'],
    tags: ['pointer', 'node', 'cycle', 'dummy'],
  },
  stack: {
    label: 'Stack',
    accent: 'amber',
    summary: 'Stacks are ideal for nested structure, expression evaluation, next greater queries, and monotonic processing.',
    patterns: ['balanced-parentheses', 'monotonic-stack', 'expression-evaluation', 'next-greater-element', 'largest-rectangle'],
    templateIds: ['monotonic-stack', 'balanced-parentheses', 'min-stack'],
    tags: ['lifo', 'monotonic', 'expression', 'parentheses'],
  },
  queue: {
    label: 'Queue',
    accent: 'rose',
    summary: 'Queues power BFS, scheduling, circular buffers, and monotonic window optimizations.',
    patterns: ['bfs-queue', 'level-order-traversal', 'monotonic-queue', 'topological-queue', 'priority-queue-scheduling'],
    templateIds: ['bfs-queue', 'monotonic-queue', 'circular-queue'],
    tags: ['fifo', 'bfs', 'window', 'scheduling'],
  },
  default: {
    label: 'General',
    accent: 'slate',
    summary: 'A curated DSA notebook with structured notes, patterns, and templates.',
    patterns: [],
    templateIds: [],
    tags: ['dsa', 'interview'],
  },
};

const ALIASES = new Map([
  ['linkedlist', 'linked-list'],
  ['linked list', 'linked-list'],
  ['ll', 'linked-list'],
  ['hash map', 'hashing'],
  ['hashmap', 'hashing'],
  ['hash set', 'hashing'],
  ['stack', 'stack'],
  ['queue', 'queue'],
  ['array', 'arrays'],
  ['arrays', 'arrays'],
  ['string', 'strings'],
  ['strings', 'strings'],
]);

export function getTopicKey(value = '') {
  const slug = toSlug(value).replace(/-+/g, '-');
  return ALIASES.get(slug.replace(/-/g, ' ')) || ALIASES.get(slug) || slug;
}

export function getTopicProfile(value = '') {
  const key = getTopicKey(value);
  return TOPIC_PROFILES[key] ?? { ...TOPIC_PROFILES.default, key, label: value || TOPIC_PROFILES.default.label };
}

export function topicColorClass(accent = 'slate') {
  const map = {
    cyan: 'from-cyan-500/25 to-sky-500/10 border-cyan-300/15',
    violet: 'from-violet-500/25 to-fuchsia-500/10 border-violet-300/15',
    sky: 'from-sky-500/25 to-cyan-500/10 border-sky-300/15',
    emerald: 'from-emerald-500/25 to-teal-500/10 border-emerald-300/15',
    amber: 'from-amber-500/25 to-orange-500/10 border-amber-300/15',
    rose: 'from-rose-500/25 to-pink-500/10 border-rose-300/15',
    slate: 'from-slate-500/20 to-slate-400/10 border-white/10',
  };
  return map[accent] ?? map.slate;
}

export { TOPIC_PROFILES };
