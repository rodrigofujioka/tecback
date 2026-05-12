export type ThemeMode = 'light' | 'dark'

export type TabKey = 'overview' | 'suggestions' | 'endpoints' | 'team'

export interface EndpointItem {
  method: 'GET' | 'POST' | 'PUT' | 'DELETE'
  path: string
  description: string
  status: 'implementado' | 'planejado'
}

export interface SuggestionSection {
  title: string
  description: string
  items: string[]
}

export interface TeamMember {
  name: string
  role: string
}

export interface TeamFormData {
  projectName: string
  repositoryUrl: string
  presenter: string
  members: TeamMember[]
}

export interface Filme {
  id: number
  titulo: string
  sinopse?: string
  dataLancamento?: string
  genero?: string
  duracaoMinutos?: number
  classificacaoIndicativa?: string
}

