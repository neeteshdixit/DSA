import { Route, Routes, Navigate } from 'react-router-dom';
import { VaultProvider } from '@/context/VaultContext';
import Shell from '@/components/layout/Shell';
import HomePage from '@/pages/HomePage';
import LibraryPage from '@/pages/LibraryPage';
import LessonPage from '@/pages/LessonPage';
import PatternPage from '@/pages/PatternPage';
import TemplatePage from '@/pages/TemplatePage';
import RevisionPage from '@/pages/RevisionPage';
import InterviewPage from '@/pages/InterviewPage';
import FlashcardsPage from '@/pages/FlashcardsPage';
import TrackerPage from '@/pages/TrackerPage';
import SearchPage from '@/pages/SearchPage';
import BookmarksPage from '@/pages/BookmarksPage';
import NotFoundPage from '@/pages/NotFoundPage';

export default function App() {
  return (
    <VaultProvider>
      <Routes>
        <Route element={<Shell />}>
          <Route index element={<HomePage />} />
          <Route path="library" element={<LibraryPage />} />
          <Route path="bookmarks" element={<BookmarksPage />} />
          <Route path="lesson/:slug" element={<LessonPage />} />
          <Route path="patterns" element={<PatternPage />} />
          <Route path="patterns/:slug" element={<PatternPage />} />
          <Route path="templates" element={<TemplatePage />} />
          <Route path="templates/:slug" element={<TemplatePage />} />
          <Route path="revision" element={<RevisionPage />} />
          <Route path="interview" element={<InterviewPage />} />
          <Route path="flashcards" element={<FlashcardsPage />} />
          <Route path="tracker" element={<TrackerPage />} />
          <Route path="search" element={<SearchPage />} />
          <Route path="*" element={<NotFoundPage />} />
        </Route>
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </VaultProvider>
  );
}
