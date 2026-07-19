import { cn } from '@/lib/format';

export default function ActionButton({
  children,
  variant = 'secondary',
  className = '',
  as: Component = 'button',
  ...props
}) {
  const variants = {
    primary: 'btn btn-primary',
    secondary: 'btn btn-secondary',
    ghost: 'btn btn-ghost',
  };

  return (
    <Component className={cn(variants[variant] || variants.secondary, className)} {...props}>
      {children}
    </Component>
  );
}
