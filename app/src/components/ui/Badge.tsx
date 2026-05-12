interface BadgeProps {
  children: React.ReactNode
  tone?: 'default' | 'success' | 'warning'
}

export function Badge({ children, tone = 'default' }: BadgeProps) {
  return <span className={`badge badge--${tone}`}>{children}</span>
}

