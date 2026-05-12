# IESPFLIX | App Web da turma

Frontend em **React + Vite + TypeScript** criado dentro da pasta `app` para apoiar a evolução do projeto `tecback`.

## O que já vem pronto

- tema **normal** e **dark** com persistência no navegador;
- navegação em abas para visão geral, sugestões de implementação, endpoints e equipe;
- aba de sugestões construída com base em `PROJETO_20261.md`;
- integração pronta com o backend Spring Boot usando proxy do Vite em `/backend`;
- formulário local para registrar integrantes, responsabilidades e texto-base de README.

## Estrutura

```text
app/
├── src/
│   ├── app/providers/        # provider de tema
│   ├── components/           # layout, navegação e UI compartilhada
│   ├── features/             # abas da aplicação
│   ├── hooks/                # hooks reutilizáveis
│   ├── lib/                  # tipos, dados e cliente HTTP
│   └── styles/               # CSS global da aplicação
├── package.json
└── vite.config.ts
```

## Como executar

```bash
cd app
npm install
npm run dev
```

Aplicação web: `http://localhost:5173`

## Backend junto com o frontend

Para habilitar a leitura real do endpoint `GET /filmes`, suba o backend em outro terminal:

```bash
cd ..
./mvnw spring-boot:run
```

> No Windows PowerShell, se preferir:

```powershell
Set-Location ..
.\mvnw.cmd spring-boot:run
```

## Scripts úteis

```bash
npm run dev
npm run build
npm run lint
npm run preview
```

## Próximas evoluções sugeridas

- adicionar React Router caso a turma queira transformar as abas em páginas;
- criar formulários para cadastrar filmes e usuários via frontend;
- incluir autenticação quando o backend evoluir;
- consumir endpoints paginados e filtros JPQL no portal.

