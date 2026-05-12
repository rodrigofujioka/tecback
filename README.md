# Techback - Backend 1 Uniesp

Projeto Spring Boot desenvolvido como parte da disciplina de Backend 1 da Uniesp, demonstrando boas práticas de desenvolvimento Java com arquitetura em camadas e testes abrangentes.

## 🚀 Tecnologias Utilizadas

- **Java 21** - Última versão LTS do Java
- **Spring Boot 3.5.10** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **H2 Database** - Banco de dados em memória para desenvolvimento
- **SpringDoc OpenAPI 2.8.6** - Documentação de API
- **Lombok 1.18.32** - Redução de código boilerplate
- **JUnit 5** - Framework de testes
- **Mockito** - Framework para mocks em testes
- **JaCoCo** - Análise de cobertura de testes

## 🌐 Frontend Web (React + Vite)

O projeto agora também possui uma aplicação web em `app/`, usada para a turma apresentar o andamento da implementação:

- tema normal/dark com seleção manual;
- aba de sugestões baseada em `PROJETO_20261.md`;
- consumo do backend via proxy (`/backend` -> `http://localhost:8080`);
- formulário para registrar dados da equipe e checklist de entrega.

Detalhes do frontend: `app/README.md`

## 📁 Estrutura do Projeto

```
src/main/java/br/uniesp/si/techback/
├── controller/          # Camada de controle REST
│   └── FilmeController.java
├── service/            # Camada de lógica de negócio
│   └── FilmeService.java
├── repository/         # Camada de acesso a dados
│   └── FilmeRepository.java
├── model/             # Entidades JPA
│   └── Filme.java
├── dto/               # Data Transfer Objects
│   └── FilmeDTO.java
├── mapper/            # Conversores entre Entity e DTO
│   └── FilmeMapper.java
└── TechbackApplication.java

src/test/java/br/uniesp/si/techback/
├── controller/        # Testes do controller
├── service/          # Testes do service
├── repository/       # Testes do repository
└── mapper/           # Testes do mapper
```

## 🎯 Funcionalidades

API REST para gerenciamento de filmes com as seguintes operações:

- **GET /filmes** - Listar todos os filmes
- **GET /filmes/{id}** - Buscar filme por ID
- **POST /filmes** - Criar novo filme
- **PUT /filmes/{id}** - Atualizar filme existente
- **DELETE /filmes/{id}** - Excluir filme

### Modelo de Dados

**FilmeDTO:**
```json
{
  "id": 1,
  "titulo": "Título do Filme",
  "sinopse": "Sinopse do filme",
  "dataLancamento": "2023-01-01",
  "genero": "Ação",
  "duracaoMinutos": 120,
  "classificacaoIndicativa": "12 anos"
}
```

## 🧪 Testes

O projeto possui cobertura de testes abrangente:

- **FilmeRepository**: 100% de cobertura
- **FilmeService**: 80.9% de cobertura  
- **FilmeController**: 83.2% de cobertura
- **FilmeMapper**: 100% de cobertura

### Executando os Testes

```bash
# Executar todos os testes
mvn test

# Executar testes com relatório de cobertura
mvn test jacoco:report

# Visualizar relatório de cobertura
# Abra: target/site/jacoco/index.html
```

## 🏗️ Arquitetura e Boas Práticas

### Separação de Responsabilidades
- **Controller**: Responsável por tratar requisições HTTP e validações
- **Service**: Contém a lógica de negócio e regras do domínio
- **Repository**: Interface para acesso e persistência de dados
- **DTO**: Objeto de transferência de dados para API
- **Mapper**: Conversão entre entidades e DTOs

### Validação
- Validação de dados na camada de controller usando Bean Validation
- Título do filme é obrigatório (`@NotBlank`)

### Tratamento de Exceções
- Logs informativos para todas as operações
- Tratamento adequado de recursos não encontrados
- Retorno de status HTTP apropriados

### Logging
- Logs em diferentes níveis (INFO, DEBUG, WARN, ERROR)
- Informações contextuais para facilitar debugging

## 🚀 Como Executar

### Pré-requisitos
- Java 21 ou superior
- Maven 3.6 ou superior

### Execução

```bash
# Clonar o projeto
git clone <repositório>

# Entrar no diretório
cd tecback

# Compilar e executar
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

### Rodando backend + frontend juntos

```bash
# terminal 1 (backend)
mvn spring-boot:run

# terminal 2 (frontend)
cd app
npm install
npm run dev
```

Frontend disponível em: `http://localhost:5173`

### Documentação da API

A documentação OpenAPI/Swagger está disponível em:
`http://localhost:8080/swagger-ui.html`

### Console H2

O console do banco H2 está disponível em:
`http://localhost:8080/h2`

**Configurações de conexão:**
- URL: `jdbc:h2:file:~/teckback20262`
- User Name: `sa`
- Password: `password`

## 📊 Métricas de Qualidade

- **Cobertura de Testes**: >80% nas camadas principais
- **Code Quality**: Segue padrões e convenções Java
- **Arquitetura**: Limpa, com separação clara de responsabilidades
- **Documentação**: API auto-documentada com OpenAPI

## 🔧 Desenvolvimento

### Comandos Úteis

```bash
# Compilar projeto
mvn compile

# Executar testes
mvn test

# Gerar relatório de cobertura
mvn jacoco:report

# Limpar projeto
mvn clean

# Empacar aplicação
mvn package

# Verificar dependências
mvn dependency:tree
```

### Configuração de Desenvolvimento

O projeto utiliza perfil de teste (`application-test.properties`) com:
- Banco H2 em memória
- Logs em nível DEBUG
- Criação automática de schema

## 📝 Próximos Passos

Sugestões para evolução do projeto:

1. **Autenticação e Autorização**: Implementar Spring Security
2. **Validações Avançadas**: Adicionar validações de negócio mais complexas
3. **Paginação**: Implementar paginação nas listagens
4. **Filtros**: Adicionar filtros por gênero, data, etc.
5. **Cache**: Implementar cache para consultas frequentes
6. **Integração**: Conectar com banco de dados production-ready
7. **Monitoramento**: Adicionar métricas e health checks

## 👨‍💻 Autor

Desenvolvido como parte da disciplina de Backend 1 da Uniesp, demonstrando conceitos de desenvolvimento Java Enterprise com Spring Boot.
