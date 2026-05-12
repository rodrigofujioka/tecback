import type { Filme } from './types'

async function fetchJson<T>(input: string): Promise<T> {
  const response = await fetch(input)

  if (!response.ok) {
    throw new Error(`Falha ao carregar recurso (${response.status})`)
  }

  return (await response.json()) as T
}

export function getFilmes() {
  return fetchJson<Filme[]>('/backend/filmes')
}

