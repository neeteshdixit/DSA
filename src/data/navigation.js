import {
  House,
  LibraryBig,
  Bookmark,
  Sparkles,
  FileCode2,
  RefreshCcw,
  MessagesSquare,
  Drama,
  PanelTop,
  Search,
  CheckSquare,
} from 'lucide-react';

export const NAV_GROUPS = [
  {
    title: 'Discover',
    items: [
      { label: 'Home', to: '/', icon: House },
      { label: 'Library', to: '/library', icon: LibraryBig },
      { label: 'Bookmarks', to: '/bookmarks', icon: Bookmark },
      { label: 'Search', to: '/search', icon: Search },
    ],
  },
  {
    title: 'Study',
    items: [
      { label: 'Patterns', to: '/patterns', icon: Sparkles },
      { label: 'Templates', to: '/templates', icon: FileCode2 },
      { label: 'Revision', to: '/revision', icon: RefreshCcw },
      { label: 'Interview', to: '/interview', icon: MessagesSquare },
      { label: 'Flashcards', to: '/flashcards', icon: Drama },
    ],
  },
  {
    title: 'Track',
    items: [{ label: 'Tracker', to: '/tracker', icon: CheckSquare }],
  },
];

export const QUICK_LINKS = [
  { label: 'Patterns', to: '/patterns' },
  { label: 'Templates', to: '/templates' },
  { label: 'Tracker', to: '/tracker' },
  { label: 'Revision', to: '/revision' },
];

export const SHELL_BADGES = [
  { label: 'Local-first', tone: 'badge-success' },
  { label: 'Auto TXT scan', tone: 'badge-accent' },
  { label: 'No backend', tone: 'badge-warning' },
];

export const HERO_METRICS = [
  { label: 'DSA volumes', key: 'lessons' },
  { label: 'Patterns', key: 'patterns' },
  { label: 'Templates', key: 'templates' },
  { label: 'Saved items', key: 'bookmarks' },
];
