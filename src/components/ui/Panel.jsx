import { cn } from '@/lib/format';

export default function Panel({ className = '', as: Component = 'section', children, ...props }) {
  return (
    <Component className={cn('card-surface p-4 md:p-5', className)} {...props}>
      {children}
    </Component>
  );
}
