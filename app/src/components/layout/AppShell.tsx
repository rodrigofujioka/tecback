import { ThemeToggle } from '../theme/ThemeToggle'

interface AppShellProps {
  children: React.ReactNode
}

export function AppShell({ children }: AppShellProps) {
  return (
    <div className="app-shell">
      <header className="hero-panel">
        <div>
          <p className="hero-panel__eyebrow">Backend + Frontend para a turma</p>
          <h1>IESPFLIX | Portal do Projeto Web</h1>
          <p className="hero-panel__summary">
            Página para auxiliar quem nunca olhou o repositório da disciplina, o projeto esta rganizado para apresentar requisitos, planejar entregas e evoluir o
            backend Spring Boot da disciplina.
          </p>
        </div>
        <ThemeToggle />
      </header>
      <main className="content-grid">{children}</main>
    </div>
  )
}

