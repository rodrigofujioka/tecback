# SETUP do Projeto — IESPFLIX

Este guia reúne **todas as configurações de banco** (PostgreSQL e H2) em **dois formatos** de arquivo (`application.yml` e `application.properties`), **todas com Flyway habilitado** e com **SpringDoc (Swagger UI)** configurado.

> **Dica:** escolha **um** formato (YAML **ou** properties) para cada ambiente do seu projeto e mantenha consistência.

---

## 🔧 1) PostgreSQL — `application-postgres.yml`

```yaml
spring:
  application:
    name: techback
  datasource:
    url: jdbc:postgresql://localhost:5432/iespflx
    username: seu_usuario
    password: sua_senha
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: validate   # Usar Flyway para criar/alterar schema; JPA apenas valida
    show-sql: true
    properties:
      hibernate:
        format_sql: true
  flyway:
    enabled: true
    baseline-on-migrate: true
    # Opcional: definir schema(s) e local dos scripts
    # schemas: public
    # locations: classpath:db/migration
server:
  port: 8080

# Swagger (SpringDoc)
springdoc:
  api-docs:
    enabled: true
  swagger-ui:
    path: /swagger-ui.html
```

Arquivo pronto para download:  
👉 [application-postgres.yml](sandbox:/mnt/data/config/examples/application-postgres.yml)

---

## 🐘 2) PostgreSQL — `application-postgres.properties`

```properties
spring.application.name=techback

# Datasource - PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/iespflx
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Flyway
spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
# spring.flyway.schemas=public
# spring.flyway.locations=classpath:db/migration

# Server
server.port=8080

# SpringDoc (Swagger UI)
springdoc.api-docs.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html
```

Arquivo pronto para download:  
👉 [application-postgres.properties](sandbox:/mnt/data/config/examples/application-postgres.properties)

---

## 🗄️ 3) H2 — `application-h2.yml`

```yaml
spring:
  application:
    name: techback
  h2:
    console:
      enabled: true
      path: /h2
  datasource:
    url: jdbc:h2:file:~/teckback;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;DEFAULT_NULL_ORDERING=HIGH
    username: sa
    password:
    driver-class-name: org.h2.Driver
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: validate   # Usar Flyway; JPA apenas valida
    show-sql: true
    properties:
      hibernate:
        format_sql: true
  flyway:
    enabled: true
    baseline-on-migrate: true
    # locations: classpath:db/migration
server:
  port: 8080

springdoc:
  api-docs:
    enabled: true
  swagger-ui:
    path: /swagger-ui.html
```

Arquivo pronto para download:  
👉 [application-h2.yml](sandbox:/mnt/data/config/examples/application-h2.yml)

---

## 💾 4) H2 — `application-h2.properties`

```properties
spring.application.name=techback

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2

# Datasource - H2 (arquivo em disco)
spring.datasource.url=jdbc:h2:file:~/teckback;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;DEFAULT_NULL_ORDERING=HIGH
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# JPA / Hibernate (validar schema; Flyway aplica as migrations)
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Flyway
spring.flyway.enabled=true
spring.flyway.baseline-on-migrate=true
# spring.flyway.locations=classpath:db/migration

# Server
server.port=8080

# SpringDoc (Swagger UI)
springdoc.api-docs.enabled=true
springdoc.swagger-ui.path=/swagger-ui.html
```

Arquivo pronto para download:  
👉 [application-h2.properties](sandbox:/mnt/data/config/examples/application-h2.properties)

---

## 🧭 Como escolher qual usar?
- **Desenvolvimento local simples** → H2 (`application-h2.yml` **ou** `.properties`) com console em `/h2`.
- **Ambientes integrados/produção** → PostgreSQL (`application-postgres.yml` **ou** `.properties`).
- **Flyway**: mantenha scripts SQL em `src/main/resources/db/migration` (`V1__create_schema.sql`, `V2__...`).  
- **Dica**: ative apenas **um** profile por vez e mantenha `ddl-auto=validate` para evitar divergências entre ambientes.

---

## 🔗 Referências internas
- Especificação do projeto: [IESPFLIX_ESPECIFICACAO.md](sandbox:/mnt/data/IESPFLIX_ESPECIFICACAO.md)
- README do repositório: [README_FINAL.md](sandbox:/mnt/data/README_FINAL.md)
