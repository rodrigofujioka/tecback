interface CardProps {
  title?: string
  eyebrow?: string
  children: React.ReactNode
}

export function Card({ title, eyebrow, children }: CardProps) {
  return (
    <article className="card">
      {eyebrow ? <span className="card__eyebrow">{eyebrow}</span> : null}
      {title ? <h3 className="card__title">{title}</h3> : null}
      <div className="card__content">{children}</div>
    </article>
  )
}

