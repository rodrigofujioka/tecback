import { Badge } from '../../components/ui/Badge'
import { Card } from '../../components/ui/Card'
import { backendCapabilities, heroHighlights, implementationRoadmap, mandatoryRequirements } from '../../lib/projectData'

export function OverviewTab() {
  return (
    <section className="page-section">
      <div className="section-heading">
        <Badge>Projeto web da turma</Badge>
        <h2>Resumo rápido do que precisa aparecer na entrega</h2>
        <p>
          Esta página organiza os requisitos passados em sala e cria um ponto de partida para conectar o
          frontend React com o backend Spring Boot já existente no repositório.
        </p>
      </div>

      <div className="card-grid card-grid--three">
        {heroHighlights.map((highlight) => (
          <Card key={highlight} eyebrow="Destaque">
            <p>{highlight}</p>
          </Card>
        ))}
      </div>

      <div className="two-column-layout">
        <Card title="Checklist obrigatório" eyebrow="Entrega mínima">
          <ul className="feature-list">
            {mandatoryRequirements.map((item) => (
              <li key={item}>{item}</li>
            ))}
          </ul>
        </Card>

        <Card title="Roteiro de implementação" eyebrow="Próximos passos">
          <ol className="feature-list feature-list--ordered">
            {implementationRoadmap.map((item) => (
              <li key={item}>{item}</li>
            ))}
          </ol>
        </Card>
      </div>

      <div className="card-grid card-grid--three">
        {backendCapabilities.map((capability) => (
          <Card key={capability.title} title={capability.title} eyebrow="Contexto atual">
            <p>{capability.description}</p>
          </Card>
        ))}
      </div>
    </section>
  )
}

