import { Badge } from '../../components/ui/Badge'
import { Card } from '../../components/ui/Card'
import { suggestionSections } from '../../lib/projectData'

export function SuggestionsTab() {
  return (
    <section className="page-section">
      <div className="section-heading">
        <Badge tone="success">Baseado em PROJETO_20261.md</Badge>
        <h2>Sugestões de implementação para a equipe</h2>
        <p>
          Aqui estão os pontos mais importantes da especificação do IESPFLIX organizados em formato de
          cards para facilitar a divisão do trabalho e a apresentação.
        </p>
      </div>

      <div className="card-grid card-grid--two">
        {suggestionSections.map((section) => (
          <Card key={section.title} title={section.title} eyebrow={section.description}>
            <ul className="feature-list">
              {section.items.map((item) => (
                <li key={item}>{item}</li>
              ))}
            </ul>
          </Card>
        ))}
      </div>
    </section>
  )
}

