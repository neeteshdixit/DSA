import { cn } from '@/lib/format';

export default function Tag({ children, tone = 'default', className = '' }) {
  const tones = {
    default: 'badge',
    accent: 'badge badge-accent',
    success: 'badge badge-success',
    warning: 'badge badge-warning',
    danger: 'badge badge-danger',
  };

  return <span className={cn(tones[tone] || tones.default, className)}>{children}</span>;
}
