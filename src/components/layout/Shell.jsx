import { useEffect, useState } from 'react';
import { Outlet, useLocation, useNavigate } from 'react-router-dom';
import { useVault } from '@/context/VaultContext';
import Sidebar from './Sidebar';
import Topbar from './Topbar';
import { cn } from '@/lib/format';

export default function Shell() {
  const [mobileOpen, setMobileOpen] = useState(false);
  const [collapsed, setCollapsed] = useState(false);
  const { stats } = useVault();
  const location = useLocation();
  const navigate = useNavigate();

  useEffect(() => {
    const onKeyDown = (event) => {
      if ((event.metaKey || event.ctrlKey) && event.key.toLowerCase() === 'k') {
        event.preventDefault();
        navigate('/search');
      }
      if (event.key === 'Escape') {
        setMobileOpen(false);
      }
    };

    window.addEventListener('keydown', onKeyDown);
    return () => window.removeEventListener('keydown', onKeyDown);
  }, [navigate]);

  useEffect(() => {
    setMobileOpen(false);
  }, [location.pathname]);

  const overlayVisible = mobileOpen;

  return (
    <div className="app-shell page-frame scrollbar-thin">
      <div className="grid-shell">
        <div className="hidden lg:block">
          <Sidebar
            collapsed={collapsed}
            onCollapseToggle={() => setCollapsed((value) => !value)}
            stats={stats}
          />
        </div>

        <main className="flex min-w-0 flex-col gap-4">
          <Topbar
            onMenuClick={() => setMobileOpen(true)}
            title="DSA Vault"
            subtitle="Premium local-first learning for Java DSA interviews"
          />
          <div className="min-w-0 flex-1">
            <Outlet />
          </div>
        </main>
      </div>

      <div
        className={cn(
          'fixed inset-0 z-40 bg-slate-950/70 backdrop-blur-sm transition-opacity lg:hidden',
          overlayVisible ? 'pointer-events-auto opacity-100' : 'pointer-events-none opacity-0',
        )}
        aria-hidden={!overlayVisible}
        onClick={() => setMobileOpen(false)}
      />

      <div
        className={cn(
          'fixed left-0 top-0 z-50 h-full w-[88vw] max-w-[320px] p-3 transition-transform duration-300 lg:hidden',
          overlayVisible ? 'translate-x-0' : '-translate-x-full',
        )}
      >
        <Sidebar
          stats={stats}
          onClose={() => setMobileOpen(false)}
          onCollapseToggle={() => {}}
        />
      </div>
    </div>
  );
}
