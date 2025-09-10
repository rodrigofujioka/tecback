# IESPFLIX - Especificação do Projeto (BackEnd)

# Atualizações: 
- 10-09-2025 - Criação da versão 1 do projeto com especificação do projeto e tabelas do banco que podem ser pedidas.


## 1) Stack e objetivo
- **Stack**: Spring Boot 3.x, **Spring Web** (somente APIs REST), **Spring Data JPA**, Bean Validation (incl. **Custom Validators**), **Lombok**, Flyway (migrations), banco relacional (PostgreSQL recomendado). Porém vamos utilizar o H2 durante as aulas. 
- **Objetivo**: API para catálogo de conteúdos, usuários, favoritos, planos e assinaturas, com regras de validação, persistência e consultas com JPQL.  
- **Autenticação**: **não obrigatória** (pode ser Plus).
- Criei um CORE , porém podem ter atualizações durante o andamento das aulas e progresso da turma. 

---

## 2) Modelo relacional (tabelas) que precisará ser mapeado com ORM 

### 2.1 `usuarios`
- `id` UUID **PK**
- `nome_completo` VARCHAR(150) **NOT NULL**
- `data_nascimento` DATE **NOT NULL**
- `email` VARCHAR(254) **NOT NULL**, **UNIQUE**
- `senha_hash` VARCHAR(60) **NOT NULL**
- `cpf_cnpj` VARCHAR(14) **UNIQUE**
- `perfil` VARCHAR(20) **NOT NULL** (`ADMIN` | `USER`)
- `criado_em` TIMESTAMP(3) **NOT NULL**
- `atualizado_em` TIMESTAMP(3) **NOT NULL**

### 2.2 `conteudo`
- `id` UUID **PK**
- `titulo` VARCHAR(200) **NOT NULL**
- `tipo` VARCHAR(10) **NOT NULL** (`FILME` | `SERIE`)
- `ano` SMALLINT **NOT NULL** (1888–2100)
- `duracao_minutos` SMALLINT **NOT NULL** (1–999)
- `relevancia` DECIMAL(4,2) **NOT NULL**
- `sinopse` TEXT
- `trailer_url` VARCHAR(500)
- `genero` VARCHAR(50)
- `criado_em` / `atualizado_em` TIMESTAMP(3) **NOT NULL**

### 2.3 `favorito`
- PK composta (`usuario_id`, `conteudo_id`)
- `usuario_id` UUID **FK** → `usuarios(id)` (**ON DELETE CASCADE**)
- `conteudo_id` UUID **FK** → `conteudo(id)` (**ON DELETE CASCADE**)
- `criado_em` TIMESTAMP(3) **NOT NULL**

### 2.4 `plano`
- `id` UUID **PK**
- `codigo` VARCHAR(20) **UNIQUE NOT NULL**
- `limite_diario` SMALLINT **NOT NULL**
- `streams_simultaneos` SMALLINT **NOT NULL**

### 2.5 `assinatura`
- `id` UUID **PK**
- `usuario_id` UUID **FK** → `usuarios(id)`
- `plano_id` UUID **FK** → `plano(id)`
- `status` VARCHAR(20) **NOT NULL** (`ATIVA` | `EM_ATRASO` | `CANCELADA`)
- `iniciada_em` TIMESTAMP(3) **NOT NULL**
- `cancelada_em` TIMESTAMP(3) NULL

### 2.6 `metodo_pagamento`
- `id` UUID **PK**
- `usuario_id` UUID **FK** → `usuarios(id)` (**ON DELETE CASCADE**)
- `bandeira` VARCHAR(20) **NOT NULL**
- `ultimos4` CHAR(4) **NOT NULL**
- `mes_exp` SMALLINT **NOT NULL** (1–12)
- `ano_exp` SMALLINT **NOT NULL**
- `nome_portador` VARCHAR(150) **NOT NULL**
- `token_gateway` VARCHAR(120) **NOT NULL**
- `criado_em` TIMESTAMP(3) **NOT NULL**

### 2.7 (Opcional) `evento_assistido`
- `id` UUID **PK**
- `usuario_id` UUID **FK** → `usuarios(id)`
- `conteudo_id` UUID **FK** → `conteudo(id)`
- `assistido_em` TIMESTAMP(3) **NOT NULL**

---

## 3) Validações
- **Nome Completo**: obrigatório, máx. 150.
- **E-mail**: obrigatório, único, máx. 254, formato válido.
- **Senha**: min. 8 caracteres, armazenada como hash BCrypt.
- **CPF/CNPJ**: somente dígitos, 11 ou 14, com dígito verificador.
- **Ano/Duração/Relevância**: faixas definidas na tabela `conteudo`.
- **Plano**: `codigo` em {BASICO, PADRAO, PREMIUM}.
- **Custom Validators**: obrigatório ao menos 1 (ex.: CPFouCNPJValidator, SenhaForteValidator, EnumSubsetValidator).

---

## 4) APIs REST (Spring Web)
- **Usuários**: criar, atualizar, consultar por id, listar paginado (ordenar por nome).
- **Conteúdos**: listar com filtros (`tipo`, `genero`, `q`), ordenação alfabética por `titulo`, detalhar, criar, atualizar, excluir.
- **Favoritos**: adicionar/remover, listar favoritos por usuário (ordenados por data desc).
- **Planos**: listar todos, detalhar por código.
- **Assinaturas**: criar, cancelar, consultar por status.
- **Método de pagamento**: cadastrar/consultar/remover (somente tokenizado).

---

## 5) Consultas JPQL (atividades sugeridas)
1. Ordenar `conteudo` por `titulo` (asc).
2. Filtrar `conteudo` por `genero` (case-insensitive), ordenar por título.
3. Buscar top N conteúdos por relevância.
4. Listar conteúdos lançados após ano X.
5. Listar favoritos recentes de um usuário.
6. Contar assinaturas ativas por plano.
7. Listar conteúdos com `trailer_url` não nulo.
8. Buscar por palavra-chave no título/sinopse, ordenado por relevância.

---

## 6) Lombok
- Usar em todas as entidades: `@Getter`, `@Setter`, `@Builder`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@EqualsAndHashCode(of="id")`.

---

## 7) Observabilidade e logs
- Log início/fim de cada operação com correlation-id.
- Tratamento global de exceções, respostas em `application/problem+json`.

---

## 8) Critérios de aceite
- Modelo relacional fiel às tabelas.
- Validações + 1 Custom Validator obrigatório.
- APIs REST (Spring Web) implementadas.
- Consultas JPQL implementadas.
- Lombok aplicado em todas as entidades.
- Erros padronizados + logs implementados.

---

## 9) Atividades guiadas ( Algumas dessas atividades podem não ser realizadas em sala de auala)
- A1: Criar banco (DDL via Flyway).
- A2: Implementar entidades com Lombok + validações.
- A3: Criar APIs REST de `conteudo` com filtros + ordenação.
- A4: Implementar endpoints de favoritos e assinaturas.
- A5: Implementar 4 consultas JPQL sugeridas.
- A6 (Plus): Integrar com API pública de filmes/séries.


## E VAMOS PARA MAIS UM NATAL FELIZ 
