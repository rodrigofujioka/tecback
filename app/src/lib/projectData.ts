import type { EndpointItem, SuggestionSection, TeamFormData } from './types'

export const heroHighlights = [
  'React + Vite organizado para crescer junto com o backend da disciplina.',
  'Tema claro e dark com seleção manual e preferência salva no navegador.',
  'Aba de sugestões construída a partir dos requisitos de `PROJETO_20261.md`.',
]

export const mandatoryRequirements = [
  'Equipe com no máximo 5 integrantes.',
  'Pelo menos 1 endpoint por integrante da equipe.',
  'Uso de Lombok no backend.',
  'ORM com Spring Data JPA e consultas JPQL personalizadas.',
  'Integração com serviços externos, como ViaCEP ou BrasilAPI.',
  'Validações de requisição e ao menos 1 custom bean validator.',
  'Logs, paginação e tratamento global de exceções centralizado.',
  'Projeto aceito com nota somente para quem apresentar.',
  'Entrega via GIT por apenas 1 integrante, contendo os dados de toda a equipe.',
]

export const backendCapabilities = [
  {
    title: 'Camadas já existentes no projeto',
    description:
      'O backend atual já possui controllers, services, repositories, DTOs, mapper, tratamento de exceções e uso de Lombok.',
  },
  {
    title: 'Integração com APIs externas',
    description:
      'O histórico do projeto já contempla ViaCEP e atividade com BrasilAPI, o que ajuda a demonstrar integração externa.',
  },
  {
    title: 'Ponto de evolução natural',
    description:
      'A especificação IESPFLIX amplia o escopo para usuários, conteúdos, favoritos, planos, assinaturas e método de pagamento.',
  },
]

export const verifiedEndpoints: EndpointItem[] = [
  {
    method: 'GET',
    path: '/filmes',
    description: 'Lista todos os filmes cadastrados no backend atual.',
    status: 'implementado',
  },
  {
    method: 'GET',
    path: '/filmes/{id}',
    description: 'Busca um filme específico por identificador.',
    status: 'implementado',
  },
  {
    method: 'POST',
    path: '/filmes',
    description: 'Cria um novo filme com validação de título.',
    status: 'implementado',
  },
  {
    method: 'PUT',
    path: '/filmes/{id}',
    description: 'Atualiza um filme existente.',
    status: 'implementado',
  },
  {
    method: 'DELETE',
    path: '/filmes/{id}',
    description: 'Remove um filme existente.',
    status: 'implementado',
  },
  {
    method: 'POST',
    path: '/funcionarios',
    description: 'Cria um funcionário simples usando a estrutura didática trabalhada em sala.',
    status: 'implementado',
  },
]

export const suggestionSections: SuggestionSection[] = [
  {
    title: 'Divisão sugerida por integrante',
    description: 'Como distribuir responsabilidades considerando equipes de até 5 pessoas.',
    items: [
      'Integrante 1: módulo de usuários com cadastro, listagem paginada e validações.',
      'Integrante 2: módulo de conteúdos com filtros por tipo, gênero e busca textual.',
      'Integrante 3: favoritos e histórico assistido, com ordenação por data.',
      'Integrante 4: planos, assinaturas e método de pagamento tokenizado.',
      'Integrante 5: integração externa, custom validators, logs, paginação e documentação.',
    ],
  },
  {
    title: 'Entidades sugeridas pelo documento',
    description: 'Tabela-base do IESPFLIX descrita em `PROJETO_20261.md`.',
    items: [
      'usuarios: nome, data de nascimento, email, senha hash, cpf/cnpj e perfil.',
      'conteudo: título, tipo, ano, duração, relevância, sinopse, trailer e gênero.',
      'favorito: relacionamento entre usuário e conteúdo.',
      'plano e assinatura: controle de consumo e status da conta.',
      'metodo_pagamento: dados tokenizados para cenários de cobrança.',
    ],
  },
  {
    title: 'Validações obrigatórias',
    description: 'Pontos mínimos de Bean Validation e customização exigidos no projeto.',
    items: [
      'Email obrigatório, único e com formato válido.',
      'Senha forte com hash BCrypt no backend.',
      'CPF/CNPJ com verificação de tamanho e dígito validador.',
      'Ano, duração e relevância com faixas válidas.',
      'Criar ao menos 1 custom validator: CPF/CNPJ, senha forte ou enum subset.',
    ],
  },
  {
    title: 'Consultas JPQL que rendem uma boa apresentação',
    description: 'Consultas sugeridas no documento para demonstrar ORM de forma clara.',
    items: [
      'Filtrar conteúdo por gênero de forma case-insensitive.',
      'Buscar top N conteúdos por relevância.',
      'Listar conteúdos lançados após um ano informado.',
      'Buscar favoritos recentes de um usuário.',
      'Pesquisar palavra-chave em título e sinopse ordenando por relevância.',
    ],
  },
  {
    title: 'Integrações externas que combinam com a proposta',
    description: 'Ideias simples de APIs públicas para enriquecer a entrega.',
    items: [
      'ViaCEP para completar endereço de usuário ou funcionário.',
      'BrasilAPI para consultar feriados, bancos, CEPs ou dados públicos.',
      'OMDb/TMDB como plus para enriquecer conteúdos e trailers.',
    ],
  },
  {
    title: 'Extras para ganhar maturidade de projeto',
    description: 'Itens valorizados na apresentação e fáceis de demonstrar no frontend.',
    items: [
      'Paginação visual com indicadores de página e tamanho.',
      'Logs com correlation-id no backend.',
      'Global exception handler padronizando erros.',
      'Página web com dashboard, checklist e dados da equipe.',
    ],
  },
]

export const implementationRoadmap = [
  'Modelar as entidades principais no backend com Lombok e relacionamento JPA.',
  'Criar DTOs, mappers e validações antes de abrir os endpoints públicos.',
  'Implementar primeiro os módulos centrais: usuários e conteúdos.',
  'Adicionar paginação, filtros e consultas JPQL personalizadas.',
  'Integrar pelo menos uma API externa e demonstrar o fluxo ponta a ponta.',
  'Usar o frontend React para apresentar requisitos, progresso, equipe e dados consumidos do backend.',
]

export const deliveryChecklist = [
  'Todos os integrantes cadastrados no projeto/repositório.',
  'Apresentação planejada com divisão clara de fala por integrante.',
  'Endpoints distribuídos entre os membros da equipe.',
  'Swagger ou coleção de testes preparada para demonstrar a API.',
  'README atualizado com instruções de execução do backend e do frontend.',
]

export const defaultTeamForm: TeamFormData = {
  projectName: 'IESPFLIX Web + API',
  repositoryUrl: 'https://github.com/seu-usuario/tecback',
  presenter: '',
  members: [
    { name: '', role: 'Usuários e autenticação' },
    { name: '', role: 'Conteúdos e filtros' },
    { name: '', role: 'Favoritos e assinaturas' },
    { name: '', role: 'Integrações externas e validações' },
    { name: '', role: 'Frontend, documentação e apresentação' },
  ],
}

