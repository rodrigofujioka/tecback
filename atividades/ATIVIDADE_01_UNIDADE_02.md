# Atividade 01 - Unidade 02

## Tema
Integracao com API externa usando Feign no Spring Boot.

## Objetivo
Reproduzir o mesmo modelo que foi usado na integracao com ViaCEP, mas agora escolhendo uma API publica da BrasilAPI.

Documentacao: https://brasilapi.com.br/docs

## Contexto
No projeto ja existe um exemplo pronto:
- cliente Feign: `src/main/java/br/uniesp/si/techback/client/ViaCepClient.java`
- DTO de resposta: `src/main/java/br/uniesp/si/techback/dto/ViaCepResponseDTO.java`
- uso no service: `src/main/java/br/uniesp/si/techback/service/FuncionarioService.java`
- configuracao da URL: `src/main/resources/application-dev.properties`

Use esse fluxo como referencia para montar sua integracao.

## Regras da atividade
1. Escolher **1 endpoint** da BrasilAPI.
2. Criar um **cliente Feign** para esse endpoint.
3. Criar **DTO(s)** para receber a resposta JSON.
4. Integrar no **Service** da funcionalidade que voce escolher.
5. Expor pelo menos **1 endpoint REST** no Controller para testar sua integracao.
6. Colocar a URL base da API no arquivo de properties.

## Sugestoes de endpoints da BrasilAPI
- CEP: `/api/cep/v2/{cep}`
- DDD: `/api/ddd/v1/{ddd}`
- Bancos: `/api/banks/v1`
- Feriados nacionais: `/api/feriados/v1/{ano}`

## Checklist tecnico
- [ ] Dependencia de Feign presente no `pom.xml`
- [ ] Classe anotada com `@FeignClient`
- [ ] Metodo com `@GetMapping` no client
- [ ] DTO com campos compativeis com o JSON da API
- [ ] Service chamando o client
- [ ] Controller com endpoint para acionar a integracao
- [ ] Propriedade configurada em `application-dev.properties`
- [ ] Projeto compilando

## Estrutura sugerida
Voce pode criar algo parecido com:
- `src/main/java/br/uniesp/si/techback/client/MinhaApiClient.java`
- `src/main/java/br/uniesp/si/techback/dto/MinhaRespostaDTO.java`
- `src/main/java/br/uniesp/si/techback/service/MinhaFeatureService.java`
- `src/main/java/br/uniesp/si/techback/controller/MinhaFeatureController.java`

## Criterios de avaliacao
- Integracao funcionando com retorno real da API externa
- Codigo organizado por camadas (controller, service, client, dto)
- Nomes claros de classes e metodos
- Endpoint de teste funcionando no Postman/Insomnia
- Uso correto de propriedades para URL externa

## Entrega
Entregar:
1. Codigo implementado
2. Print da chamada no cliente HTTP (Postman/Insomnia)
3. Breve explicacao (5 a 10 linhas) sobre:
   - API escolhida
   - endpoint usado
   - como foi feita a integracao

## Bonus (opcional)
- Tratar erros de chamada externa (timeout, 404, etc.)
- Criar testes unitarios do service com mock do client
- Aplicar DTO de entrada e saida no controller

## Links importantes (preencher)
- [Link 1 - BrasilAPI Docs]()
- [Link 2 - Spring OpenFeign]()
- [Link 3 - Spring Boot Externalized Configuration]()
- [Link 4 - Exemplo interno ViaCEP do projeto]()

