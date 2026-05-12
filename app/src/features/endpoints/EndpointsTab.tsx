import { useEffect, useState } from 'react'
import { Badge } from '../../components/ui/Badge'
import { Card } from '../../components/ui/Card'
import { getFilmes } from '../../lib/api'
import { verifiedEndpoints } from '../../lib/projectData'
import type { Filme } from '../../lib/types'

interface ApiState {
  filmes: Filme[]
  isLoading: boolean
  error: string | null
}

const initialState: ApiState = {
  filmes: [],
  isLoading: true,
  error: null,
}

export function EndpointsTab() {
  const [state, setState] = useState<ApiState>(initialState)

  useEffect(() => {
    let cancelled = false

    async function loadFilmes() {
      setState((current) => ({ ...current, isLoading: true, error: null }))

      try {
        const filmes = await getFilmes()

        if (!cancelled) {
          setState({ filmes, isLoading: false, error: null })
        }
      } catch (error) {
        if (!cancelled) {
          setState({
            filmes: [],
            isLoading: false,
            error:
              error instanceof Error
                ? error.message
                : 'Não foi possível conectar com o backend em http://localhost:8080.',
          })
        }
      }
    }

    void loadFilmes()

    return () => {
      cancelled = true
    }
  }, [])

  return (
    <section className="page-section">
      <div className="section-heading">
        <Badge tone="warning">Integração pronta para evoluir</Badge>
        <h2>Endpoints atuais do backend e consumo pelo frontend</h2>
        <p>
          O Vite foi configurado com proxy para encaminhar chamadas de <code>/backend</code> para o
          Spring Boot em <code>http://localhost:8080</code>, evitando problemas de CORS durante o
          desenvolvimento.
        </p>
      </div>

      <div className="card-grid card-grid--two">
        {verifiedEndpoints.map((endpoint) => (
          <Card key={`${endpoint.method}-${endpoint.path}`} title={endpoint.path} eyebrow={endpoint.description}>
            <div className="endpoint-row">
              <Badge tone={endpoint.status === 'implementado' ? 'success' : 'warning'}>
                {endpoint.status}
              </Badge>
              <span className="endpoint-method">{endpoint.method}</span>
            </div>
          </Card>
        ))}
      </div>

      <Card title="Catálogo retornado pelo backend" eyebrow="Leitura real de GET /filmes">
        {state.isLoading ? <p>Carregando filmes cadastrados...</p> : null}
        {state.error ? <p className="status-text status-text--error">{state.error}</p> : null}
        {!state.isLoading && !state.error && state.filmes.length === 0 ? (
          <p className="status-text">O backend respondeu, mas ainda não existem filmes cadastrados.</p>
        ) : null}
        {!state.isLoading && !state.error && state.filmes.length > 0 ? (
          <div className="card-grid card-grid--two">
            {state.filmes.map((filme) => (
              <article key={filme.id} className="movie-item">
                <div className="movie-item__header">
                  <h3>{filme.titulo}</h3>
                  {filme.genero ? <Badge>{filme.genero}</Badge> : null}
                </div>
                <p>{filme.sinopse || 'Sem sinopse cadastrada.'}</p>
                <div className="movie-item__meta">
                  <span>{filme.dataLancamento || 'Data não informada'}</span>
                  <span>{filme.duracaoMinutos ? `${filme.duracaoMinutos} min` : 'Duração não informada'}</span>
                </div>
              </article>
            ))}
          </div>
        ) : null}
      </Card>
    </section>
  )
}

