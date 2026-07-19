import { NavLink, useLocation } from 'react-router-dom';
import { ChevronLeft, Layers3, NotebookPen, PanelLeftClose } from 'lucide-react';
import { NAV_GROUPS, SHELL_BADGES } from '@/data/navigation';
import { formatNumber, cn } from '@/lib/format';
import Tag from '@/components/ui/Tag';
import ActionButton from '@/components/ui/ActionButton';

function NavItem({ item, collapsed }) {
  return (
    <NavLink
      to={item.to}
      className={({ isActive }) =>
        cn(
          'group flex items-center gap-3 rounded-2xl px-3 py-2.5 transition',
          isActive
            ? 'bg-white/10 text-white shadow-[inset_0_0_0_1px_rgba(125,211,252,0.22)]'
            : 'text-slate-300 hover:bg-white/[0.06] hover:text-white',
        )
      }
    >
      <item.icon className="h-4 w-4 shrink-0 text-sky-300" />
      {!collapsed && (
        <span className="flex min-w-0 flex-1 items-center justify-between gap-2 text-sm font-semibold">
          <span>{item.label}</span>
        </span>
      )}
    </NavLink>
  );
}

export default function Sidebar({
  collapsed = false,
  onClose = () => {},
  onCollapseToggle = () => {},
  stats = {},
}) {
  const location = useLocation();

  return (
    <aside
      className={cn(
        'glass-panel-strong scrollbar-thin flex h-[calc(100vh-2rem)] flex-col overflow-hidden rounded-[1.8rem] p-4',
        collapsed ? 'lg:w-[86px]' : 'lg:w-[320px]',
      )}
    >
      <div className="flex items-start justify-between gap-3">
        <div className="flex items-center gap-3">
          <div className="flex h-12 w-12 items-center justify-center rounded-2xl bg-gradient-to-br from-sky-400 to-violet-500 text-slate-950 shadow-[0_18px_40px_rgba(125,211,252,0.2)]">
            <Layers3 className="h-6 w-6" />
          </div>
          {!collapsed && (
            <div>
              <p className="text-[0.72rem] font-extrabold uppercase tracking-[0.25em] text-sky-300/90">
                DSA Vault
              </p>
              <p className="mt-1 text-sm text-slate-300">
                Local-first Java interview notebook
              </p>
            </div>
          )}
        </div>

        <div className="flex items-center gap-2">
          <ActionButton variant="ghost" className="h-10 w-10 rounded-2xl p-0 lg:hidden" onClick={onClose} aria-label="Close sidebar">
            <PanelLeftClose className="h-4 w-4" />
          </ActionButton>
          <ActionButton
            variant="ghost"
            className="hidden h-10 w-10 rounded-2xl p-0 lg:inline-flex"
            onClick={onCollapseToggle}
            aria-label="Collapse sidebar"
          >
            <ChevronLeft className={cn('h-4 w-4 transition', collapsed && 'rotate-180')} />
          </ActionButton>
        </div>
      </div>

      <div className={cn('mt-4 grid gap-2', collapsed && 'lg:hidden')}>
        {SHELL_BADGES.map((badge) => (
          <Tag key={badge.label} tone="accent" className="w-fit">
            {badge.label}
          </Tag>
        ))}
      </div>

      <div className={cn('mt-5 grid gap-3', collapsed && 'lg:hidden')}>
        <div className="rounded-2xl border border-white/10 bg-white/[0.04] p-3">
          <p className="text-[0.7rem] font-bold uppercase tracking-[0.22em] text-slate-400">
            Discovery
          </p>
          <div className="mt-3 grid grid-cols-2 gap-2">
            <Metric label="Lessons" value={formatNumber(stats.lessons || 0)} />
            <Metric label="Patterns" value={formatNumber(stats.patterns || 0)} />
            <Metric label="Templates" value={formatNumber(stats.templates || 0)} />
            <Metric label="Saved" value={formatNumber(stats.bookmarks || 0)} />
          </div>
        </div>

        <div className="rounded-2xl border border-white/10 bg-gradient-to-br from-sky-500/10 via-violet-500/10 to-emerald-500/10 p-3">
          <p className="text-[0.7rem] font-bold uppercase tracking-[0.22em] text-slate-300">
            Focus
          </p>
          <p className="mt-2 text-sm text-slate-200">
            {location.pathname.startsWith('/lesson')
              ? 'You are inside a lesson. Save it, revise it, and jump into related patterns.'
              : 'Open a lesson to see sections, code blocks, and revision notes.'
            }
          </p>
        </div>
      </div>

      <div className="mt-5 flex-1 overflow-y-auto pr-1 scrollbar-thin">
        <div className="space-y-5">
          {NAV_GROUPS.map((group) => (
            <div key={group.title}>
              {!collapsed && (
                <p className="mb-2 px-3 text-[0.7rem] font-extrabold uppercase tracking-[0.22em] text-slate-500">
                  {group.title}
                </p>
              )}
              <div className="space-y-1">
                {group.items.map((item) => (
                  <NavItem key={item.to} item={item} collapsed={collapsed} />
                ))}
              </div>
            </div>
          ))}
        </div>
      </div>

      {!collapsed && (
        <div className="mt-4 rounded-2xl border border-white/10 bg-white/[0.04] p-3">
          <p className="text-sm font-semibold text-slate-200">What this vault does</p>
          <p className="mt-2 text-sm leading-6 text-slate-400">
            It auto-discovers every TXT lesson in the workspace, turns it into a polished study
            page, and keeps bookmarks, progress, and tracker data in your browser only.
          </p>
        </div>
      )}
    </aside>
  );
}

function Metric({ label, value }) {
  return (
    <div className="rounded-2xl border border-white/10 bg-slate-950/30 p-2.5">
      <p className="text-[0.7rem] uppercase tracking-[0.18em] text-slate-500">{label}</p>
      <p className="mt-1 text-lg font-extrabold text-white">{value}</p>
    </div>
  );
}
