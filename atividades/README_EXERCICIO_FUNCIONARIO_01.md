# Exercício - Evolução do CRUD de Funcionario

Este exercício parte de uma implementação inicial bem simples da entidade `Funcionario`.

Arquivos criados como ponto de partida:
- `src/main/java/br/uniesp/si/techback/model/Funcionario.java`
- `src/main/java/br/uniesp/si/techback/repository/FuncionarioRepository.java`
- `src/main/java/br/uniesp/si/techback/service/FuncionarioService.java`
- `src/main/java/br/uniesp/si/techback/controller/FuncionarioController.java`

## Objetivo da atividade
Completar o CRUD de `Funcionario` e melhorar a qualidade do código, aplicando boas práticas de Spring Boot.

## O que ja existe
- Endpoint `POST /funcionarios` para incluir.
- Sem tratamento de erro.
- Sem validacoes.
- Sem DTO e sem Mapper.

## Tarefas para os alunos
1. Criar endpoints faltantes:
   - `GET /funcionarios`
   - `GET /funcionarios/{id}`
   - `PUT /funcionarios/{id}`
   - `DELETE /funcionarios/{id}`
2. Adicionar validacoes nos campos de `Funcionario`.
3. Implementar tratamento de erros com respostas HTTP adequadas.
4. Criar testes de controller, service e repository.
5. Melhorar nomes, organizacao e padrao de respostas da API.

## Referencia no projeto
Use como referencia a estrutura ja existente de Filme:
- `src/main/java/br/uniesp/si/techback/controller/FilmeController.java`
- `src/main/java/br/uniesp/si/techback/service/FilmeService.java`
- `src/main/java/br/uniesp/si/techback/repository/FilmeRepository.java`

## Referencia para DTO e Mapper
Para evoluir o codigo de `Funcionario`, observe como DTO e Mapper sao usados em Filme:
- `src/main/java/br/uniesp/si/techback/dto/FilmeDTO.java`
- `src/main/java/br/uniesp/si/techback/mapper/FilmeMapper.java`

Sugestao de evolucao:
- Criar `FuncionarioDTO`
- Criar `FuncionarioMapper`
- Ajustar `FuncionarioService` e `FuncionarioController` para trabalhar com DTO

## Extras sugeridos
- Documentar endpoints no Swagger/OpenAPI.
- Padronizar mensagens de erro.
- Aplicar paginacao na listagem.

## Links importantes (preencher)
- [Link 1 - Spring Boot Docs](https://docs.spring.io/spring-boot/index.html)
- [Link 2 - Spring Data JPA](https://docs.spring.io/spring-data/jpa/reference/)
- [Link 3 - Bean Validation (Jakarta Validation)](https://beanvalidation.org/3.0/)
- [Link 4 - MapStruct (Mapper)](https://mapstruct.org/documentation/stable/reference/html/)
- [Link extra - Mapper manual (DTO pattern)](https://martinfowler.com/eaaCatalog/dataTransferObject.html)
