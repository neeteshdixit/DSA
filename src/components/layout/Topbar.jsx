import { Menu, Search, Sparkles } from 'lucide-react';
import { useNavigate } from 'react-router-dom';
import ActionButton from '@/components/ui/ActionButton';
import { useState } from 'react';

export default function Topbar({ onMenuClick = () => {}, title = 'DSA Vault', subtitle = '' }) {
  const navigate = useNavigate();
  const [query, setQuery] = useState('');

  function submitSearch(event) {
    event.preventDefault();
    navigate(query.trim() ? `/search?q=${encodeURIComponent(query.trim())}` : '/search');
  }

  return (
    <header className="glass-panel-strong sticky top-4 z-30 rounded-[1.5rem] px-4 py-3">
      <div className="flex flex-col gap-3 xl:flex-row xl:items-center xl:justify-between">
        <div className="flex items-start gap-3">
          <ActionButton variant="ghost" className="h-11 w-11 rounded-2xl p-0 xl:hidden" onClick={onMenuClick} aria-label="Open navigation">
            <Menu className="h-4 w-4" />
          </ActionButton>
          <div>
            <div className="flex items-center gap-2">
              <Sparkles className="h-4 w-4 text-sky-300" />
              <p className="text-[0.72rem] font-extrabold uppercase tracking-[0.24em] text-sky-300/90">
                Personal DSA vault
              </p>
            </div>
            <h1 className="mt-1 text-lg font-extrabold tracking-tight text-white md:text-xl">
              {title}
            </h1>
            {subtitle ? <p className="mt-1 text-sm text-slate-400">{subtitle}</p> : null}
          </div>
        </div>

        <form onSubmit={submitSearch} className="flex flex-1 items-center gap-2 xl:max-w-xl">
          <div className="relative flex-1">
            <Search className="pointer-events-none absolute left-3 top-1/2 h-4 w-4 -translate-y-1/2 text-slate-500" />
            <input
              value={query}
              onChange={(event) => setQuery(event.target.value)}
              placeholder="Search lessons, patterns, templates..."
              className="input-field pl-10"
            />
          </div>
          <ActionButton type="submit" variant="primary" className="shrink-0">
            Search
          </ActionButton>
        </form>
      </div>
    </header>
  );
}
