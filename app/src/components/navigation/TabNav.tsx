import type { TabKey } from '../../lib/types'

interface TabNavProps {
  activeTab: TabKey
  onChange: (tab: TabKey) => void
}

const tabs: Array<{ key: TabKey; label: string; description: string }> = [
  { key: 'overview', label: 'Visão geral', description: 'Resumo da proposta e requisitos' },
  { key: 'suggestions', label: 'Sugestões', description: 'Guia baseado no PROJETO_20261' },
  { key: 'endpoints', label: 'Endpoints', description: 'Integração com o backend atual' },
  { key: 'team', label: 'Equipe', description: 'Dados do grupo e checklist de entrega' },
]

export function TabNav({ activeTab, onChange }: TabNavProps) {
  return (
    <nav className="tab-nav" aria-label="Navegação principal do projeto web">
      {tabs.map((tab) => (
        <button
          key={tab.key}
          type="button"
          className={`tab-nav__button ${activeTab === tab.key ? 'is-active' : ''}`}
          onClick={() => onChange(tab.key)}
          aria-pressed={activeTab === tab.key}
        >
          <span className="tab-nav__label">{tab.label}</span>
          <span className="tab-nav__description">{tab.description}</span>
        </button>
      ))}
    </nav>
  )
}

