# Guia de Desenvolvimento — IESPFLIX (Techback)

Este guia é voltado para alunos iniciantes que irão desenvolver e executar o backend do projeto IESPFLIX.

Objetivo: preparar o ambiente com Java 21, Maven e instruções para desenvolvimento local, execução, testes e troubleshooting.

---

## 1. Pré-requisitos

- Java 21 JDK instalado e configurado no PATH
- Maven 3.9+
- IDE: IntelliJ IDEA / VS Code (recomendado: IntelliJ)
- Docker (opcional, para PostgreSQL)

## 2. Configuração do projeto

Este projeto já foi atualizado para usar Java 21 no `pom.xml` (propriedade `java.version` e `maven-compiler-plugin`).

Verifique localmente com:

```powershell
java -version
mvn -v
```

Ambas as saídas devem mostrar Java 21 e Maven 3.9+.

## 3. Principais arquivos e onde editar

- `pom.xml` — dependências e compilador (já configurado para Java 21)
- `src/main/resources/application.properties` — configurações locais (H2) ou `application.yml` para PostgreSQL
- `src/main/java/.../TechbackApplication.java` — classe principal
- `src/main/java/.../controller`, `model`, `dto`, `service`, `repository` — camadas da aplicação

## 4. Executando a aplicação (H2 em memória)

Na raiz do projeto:

```powershell
mvn clean spring-boot:run
```

Ou execute a classe `TechbackApplication` na IDE.

A API estará disponível em `http://localhost:8080`.

## 5. Usando H2 (console)

Se estiver usando H2 (configuração de exemplo no `README_FINAL.md`), acesse o console:

`http://localhost:8080/h2`

Use as credenciais configuradas em `application.properties` (padrão: username=sa, sem senha).

## 6. Swagger / OpenAPI

O projeto usa SpringDoc OpenAPI. Após iniciar a aplicação, acesse:

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI: `http://localhost:8080/v3/api-docs`

Obs: Se o Swagger não abrir, cheque a versão do `springdoc-openapi-starter-webmvc-ui` no `pom.xml`.

## 7. Testes

Executar testes unitários e de integração:

```powershell
mvn test
```

## 8. Boas práticas e convenções

- Use `@RestController` para controllers de API.
- Valide entradas com `@Valid` e `@Validated`.
- Use DTOs para input/output e mapeie com construtores ou MapStruct (opcional).
- Não exponha senhas/segredos em arquivos de configuração.

## 9. Troubleshooting comum

- Erro `conventionErrorViewResolver ... overriding is disabled`: geralmente causado por dependências incompatíveis que registram autoconfigurações duplicadas (ex.: `springdoc` com versão desalinhada).
  - Solução rápida para desenvolvimento: adicione em `src/main/resources/application.properties`:

```properties
spring.main.allow-bean-definition-overriding=true
```

  - Melhor solução: executar `mvn dependency:tree` e alinhar/excluir a dependência transitiva que traz outra versão de `spring-boot-autoconfigure`.

```powershell
mvn dependency:tree -Dverbose -Dincludes=org.springframework.boot
```

- Caso de problemas com Lombok: instale o plugin Lombok na IDE e habilite Annotation Processing (IntelliJ: Settings > Build, Execution, Deployment > Compiler > Annotation Processors > Enable).

## 10. Atualizando dependências

- Para atualizar Spring Boot, troque a versão do `spring-boot-starter-parent` no `pom.xml`.
- Verifique compatibilidade do `springdoc` e outras bibliotecas.

## 11. Checklist de entrega (aluno)

- [ ] API rodando localmente
- [ ] Endpoints documentados no Swagger
- [ ] 4 consultas JPQL implementadas
- [ ] Custom Validator (ex.: CPF) criado e testado
- [ ] Testes básicos (unit & integration)

---

## Links úteis (adicione links importantes abaixo)

- 
- 
- 

---

Professor: Rodrigo Fujioka

Fique à vontade para pedir que eu adicione trechos de configuração específicos (Postgres, Docker Compose, exemplos de endpoints, templates de DTOs/repositories etc.).

