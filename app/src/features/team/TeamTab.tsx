import { useMemo } from 'react'
import { Badge } from '../../components/ui/Badge'
import { Card } from '../../components/ui/Card'
import { useLocalStorage } from '../../hooks/useLocalStorage'
import { defaultTeamForm, deliveryChecklist } from '../../lib/projectData'
import type { TeamFormData } from '../../lib/types'

const STORAGE_KEY = 'tecback:team-form'

export function TeamTab() {
  const [form, setForm] = useLocalStorage<TeamFormData>(STORAGE_KEY, defaultTeamForm)

  const markdownPreview = useMemo(() => {
    const members = form.members
      .map((member, index) => `- Integrante ${index + 1}: ${member.name || 'Nome pendente'} — ${member.role}`)
      .join('\n')

    return [
      `# ${form.projectName || 'Projeto da Equipe'}`,
      '',
      `- Repositório: ${form.repositoryUrl || 'Preencher URL do repositório'}`,
      `- Apresentador principal: ${form.presenter || 'Definir apresentador'}`,
      '',
      '## Integrantes',
      members,
      '',
      '## Observações de entrega',
      '- Um integrante fará a entrega via GIT.',
      '- A apresentação é obrigatória para obtenção da nota.',
      '- Cada integrante deve conseguir demonstrar pelo menos um endpoint.',
    ].join('\n')
  }, [form])

  function updateField<K extends keyof TeamFormData>(field: K, value: TeamFormData[K]) {
    setForm((current) => ({ ...current, [field]: value }))
  }

  function updateMember(index: number, field: 'name' | 'role', value: string) {
    setForm((current) => ({
      ...current,
      members: current.members.map((member, currentIndex) =>
        currentIndex === index ? { ...member, [field]: value } : member,
      ),
    }))
  }

  function resetForm() {
    setForm(defaultTeamForm)
  }

  return (
    <section className="page-section">
      <div className="section-heading">
        <Badge>Equipe e entrega</Badge>
        <h2>Preencha os dados do grupo e leve isso para o repositório</h2>
        <p>
          Esta aba ajuda a centralizar os nomes do grupo, a divisão de responsabilidades e um texto base
          que pode ser copiado para o README final do projeto.
        </p>
      </div>

      <div className="two-column-layout">
        <Card title="Dados do projeto" eyebrow="Informações básicas">
          <div className="form-grid">
            <label>
              <span>Nome do projeto</span>
              <input
                value={form.projectName}
                onChange={(event) => updateField('projectName', event.target.value)}
                placeholder="Ex.: IESPFLIX Web + API"
              />
            </label>
            <label>
              <span>URL do repositório</span>
              <input
                value={form.repositoryUrl}
                onChange={(event) => updateField('repositoryUrl', event.target.value)}
                placeholder="https://github.com/..."
              />
            </label>
            <label>
              <span>Apresentador principal</span>
              <input
                value={form.presenter}
                onChange={(event) => updateField('presenter', event.target.value)}
                placeholder="Nome de quem vai iniciar a apresentação"
              />
            </label>
          </div>

          <div className="team-grid">
            {form.members.map((member, index) => (
              <div key={`member-${index}`} className="team-grid__row">
                <label>
                  <span>Integrante {index + 1}</span>
                  <input
                    value={member.name}
                    onChange={(event) => updateMember(index, 'name', event.target.value)}
                    placeholder="Nome completo"
                  />
                </label>
                <label>
                  <span>Responsabilidade</span>
                  <input
                    value={member.role}
                    onChange={(event) => updateMember(index, 'role', event.target.value)}
                    placeholder="Ex.: Conteúdos e filtros"
                  />
                </label>
              </div>
            ))}
          </div>

          <button type="button" className="secondary-button" onClick={resetForm}>
            Restaurar modelo
          </button>
        </Card>

        <Card title="Checklist final" eyebrow="Antes de apresentar">
          <ul className="feature-list">
            {deliveryChecklist.map((item) => (
              <li key={item}>{item}</li>
            ))}
          </ul>
        </Card>
      </div>

      <Card title="Texto base para README" eyebrow="Copie e ajuste no projeto">
        <textarea value={markdownPreview} readOnly rows={14} className="markdown-preview" />
      </Card>
    </section>
  )
}

