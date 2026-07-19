import { createContext, useContext, useEffect, useState } from 'react';
import { LESSONS, TOPICS, getDiscoveryStats, getLessonBySlug } from '@/lib/content';
import { PATTERNS } from '@/data/patterns';
import { TEMPLATES } from '@/data/templates';
import { readStorage, usePersistentState } from '@/lib/localStorage';

const VaultContext = createContext(null);

const STORAGE_KEYS = {
  bookmarks: 'dsa-vault:v1:bookmarks',
  progress: 'dsa-vault:v1:progress',
  tracker: 'dsa-vault:v1:tracker',
  notes: 'dsa-vault:v1:notes',
  lastLesson: 'dsa-vault:v1:last-lesson',
};

const DEFAULT_BOOKMARKS = {
  lessons: {},
  patterns: {},
  templates: {},
};

const DEFAULT_PROGRESS = {};
const DEFAULT_TRACKER = [];
const DEFAULT_NOTES = {};

function createId(prefix = 'item') {
  const random = typeof crypto !== 'undefined' && crypto.randomUUID ? crypto.randomUUID() : `${Date.now()}-${Math.random().toString(16).slice(2)}`;
  return `${prefix}-${random}`;
}

function toggleFlag(map, key) {
  const next = { ...map };
  if (next[key]) {
    delete next[key];
  } else {
    next[key] = true;
  }
  return next;
}

function latestLessonSlug(progress) {
  let latest = null;
  let timestamp = 0;
  for (const [slug, entry] of Object.entries(progress || {})) {
    const stamp = new Date(entry?.lastOpened || entry?.updatedAt || 0).getTime();
    if (stamp > timestamp) {
      timestamp = stamp;
      latest = slug;
    }
  }
  return latest;
}

export function VaultProvider({ children }) {
  const [bookmarks, setBookmarks] = usePersistentState(STORAGE_KEYS.bookmarks, DEFAULT_BOOKMARKS);
  const [progress, setProgress] = usePersistentState(STORAGE_KEYS.progress, DEFAULT_PROGRESS);
  const [tracker, setTracker] = usePersistentState(STORAGE_KEYS.tracker, DEFAULT_TRACKER);
  const [notes, setNotes] = usePersistentState(STORAGE_KEYS.notes, DEFAULT_NOTES);
  const [lastLessonSlug, setLastLessonSlug] = usePersistentState(STORAGE_KEYS.lastLesson, null);
  const [ready, setReady] = useState(false);

  useEffect(() => {
    setReady(true);
  }, []);

  useEffect(() => {
    if (!lastLessonSlug && Object.keys(progress || {}).length) {
      const inferred = latestLessonSlug(progress);
      if (inferred) setLastLessonSlug(inferred);
    }
  }, [lastLessonSlug, progress, setLastLessonSlug]);

  function openLesson(slug) {
    const now = new Date().toISOString();
    setProgress((current) => {
      const existing = current?.[slug] || {};
      return {
        ...current,
        [slug]: {
          ...existing,
          visits: (existing.visits || 0) + 1,
          lastOpened: now,
          updatedAt: now,
        },
      };
    });
    setLastLessonSlug(slug);
  }

  function markLessonComplete(slug, completed = true) {
    const now = new Date().toISOString();
    setProgress((current) => {
      const existing = current?.[slug] || {};
      return {
        ...current,
        [slug]: {
          ...existing,
          completed,
          completedAt: completed ? now : null,
          updatedAt: now,
        },
      };
    });
  }

  function saveLessonNote(slug, note) {
    setNotes((current) => ({
      ...current,
      [slug]: String(note || ''),
    }));
  }

  function toggleBookmark(type, id) {
    setBookmarks((current) => ({
      ...DEFAULT_BOOKMARKS,
      ...current,
      [type]: toggleFlag(current?.[type] || {}, id),
    }));
  }

  function isBookmarked(type, id) {
    return Boolean(bookmarks?.[type]?.[id]);
  }

  function addTrackerQuestion(question) {
    const now = new Date().toISOString();
    const item = {
      id: createId('q'),
      title: question.title || 'Untitled question',
      company: question.company || '',
      topic: question.topic || '',
      difficulty: question.difficulty || 'Medium',
      status: question.status || 'To Solve',
      notes: question.notes || '',
      sourceLesson: question.sourceLesson || '',
      tags: question.tags || [],
      createdAt: now,
      updatedAt: now,
    };
    setTracker((current) => [item, ...(current || [])]);
    return item;
  }

  function updateTrackerQuestion(id, patch) {
    const now = new Date().toISOString();
    setTracker((current) =>
      (current || []).map((item) =>
        item.id === id ? { ...item, ...patch, updatedAt: now } : item,
      ),
    );
  }

  function removeTrackerQuestion(id) {
    setTracker((current) => (current || []).filter((item) => item.id !== id));
  }

  const stats = {
    ...getDiscoveryStats(),
    patterns: PATTERNS.length,
    templates: TEMPLATES.length,
    bookmarks:
      Object.values(bookmarks?.lessons || {}).filter(Boolean).length +
      Object.values(bookmarks?.patterns || {}).filter(Boolean).length +
      Object.values(bookmarks?.templates || {}).filter(Boolean).length,
    completedLessons: Object.values(progress || {}).filter((item) => item?.completed).length,
    tracker: tracker.length,
  };

  const catalog = {
    lessons: LESSONS,
    topics: TOPICS,
    patterns: PATTERNS,
    templates: TEMPLATES,
    tracker,
  };

  const selectedLastLesson = lastLessonSlug ? getLessonBySlug(lastLessonSlug) : null;

  const value = {
    ready,
    stats,
    catalog,
    bookmarks,
    progress,
    tracker,
    notes,
    lastLessonSlug,
    lastLesson: selectedLastLesson,
    openLesson,
    markLessonComplete,
    saveLessonNote,
    toggleBookmark,
    isBookmarked,
    addTrackerQuestion,
    updateTrackerQuestion,
    removeTrackerQuestion,
    setLastLessonSlug,
    setBookmarks,
    setProgress,
    setTracker,
    setNotes,
    getLessonNote: (slug) => notes?.[slug] || '',
    getLessonProgress: (slug) => progress?.[slug] || {},
    getLesson: getLessonBySlug,
  };

  return <VaultContext.Provider value={value}>{children}</VaultContext.Provider>;
}

export function useVault() {
  const context = useContext(VaultContext);
  if (!context) {
    throw new Error('useVault must be used inside VaultProvider');
  }
  return context;
}
