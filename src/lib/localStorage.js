import { useEffect, useState } from 'react';

function safeParse(value, fallback) {
  if (value == null) return fallback;
  try {
    return JSON.parse(value);
  } catch {
    return fallback;
  }
}

export function readStorage(key, fallback) {
  if (typeof window === 'undefined') return fallback;
  const raw = window.localStorage.getItem(key);
  return safeParse(raw, fallback);
}

export function writeStorage(key, value) {
  if (typeof window === 'undefined') return;
  window.localStorage.setItem(key, JSON.stringify(value));
}

export function usePersistentState(key, initialValue) {
  const [state, setState] = useState(() => {
    const initial = typeof initialValue === 'function' ? initialValue() : initialValue;
    return readStorage(key, initial);
  });

  useEffect(() => {
    writeStorage(key, state);
  }, [key, state]);

  return [state, setState];
}

export function ensureObject(value, fallback = {}) {
  return value && typeof value === 'object' && !Array.isArray(value) ? value : fallback;
}

export function ensureArray(value, fallback = []) {
  return Array.isArray(value) ? value : fallback;
}
