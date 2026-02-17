# Exercício: Integração com BrasilAPI - Dados Bancários

## Objetivo
Criar uma integração com a API do BrasilAPI para buscar informações de bancos brasileiros, seguindo o mesmo padrão de implementação utilizado na integração com a API ViaCEP.

## Visão Geral da API
A BrasilAPI fornece endpoints para consulta de informações bancárias, incluindo:
- Lista de todos os bancos cadastrados
- Busca de banco por código

### Endpoints da API
- `GET /banks/v1` - Retorna a lista completa de bancos
- `GET /banks/v1/{code}` - Retorna informações de um banco específico

## Requisitos

1. Criar um novo endpoint REST que permita:
   - Listar todos os bancos cadastrados
   - Buscar banco por código

2. Utilizar a API pública do BrasilAPI:
   - Base URL: `https://brasilapi.com.br/api`
   - Documentação: https://brasilapi.com.br/docs#tag/BANKS

3. Implementar seguindo o mesmo padrão do ViaCEP:
   - Criar DTOs para as respostas da API
   - Criar um serviço para encapsular a lógica de integração
   - Criar um controller para expor os endpoints
   - Implementar tratamento de erros adequado

## Tarefas

1. Crie as classes de DTO necessárias para representar:
   - `BancoResponse`: com campos como `ispb`, `nome`, `codigo` e `nomeCompleto`
   - `BancoDetalheResponse`: pode ser a mesma classe acima, já que a estrutura é idêntica

2. Crie uma classe de serviço `BancoService` que irá:
   - Fazer as requisições para a API do BrasilAPI
   - Tratar os dados recebidos
   - Lançar exceções apropriadas

3. Crie um `BancoController` com os seguintes endpoints:
   - `GET /api/bancos` - Retorna a lista de todos os bancos
   - `GET /api/bancos/{codigo}` - Retorna os detalhes de um banco específico

4. Implemente tratamento de erros para:
   - Banco não encontrado
   - Erros de validação (ex: código inválido)
   - Erros de comunicação com a API

## Exemplo de Resposta da API

```json
// GET /api/bancos
[
  {
    "ispb": "00000000",
    "nome": "BCO DO BRASIL S.A.",
    "codigo": 1,
    "nomeCompleto": "Banco do Brasil S.A."
  },
  {
    "ispb": "00000208",
    "nome": "BRB - BCO DE BRASILIA S.A.",
    "codigo": 70,
    "nomeCompleto": "BRB - BANCO DE BRASILIA S.A."
  }
  // ... outros bancos
]

// GET /api/bancos/1
{
  "ispb": "00000000",
  "nome": "BCO DO BRASIL S.A.",
  "codigo": 1,
  "nomeCompleto": "Banco do Brasil S.A."
}
```

## Dicas

1. Utilize o `RestTemplate` para fazer as requisições HTTP
2. Considere criar constantes para as URLs da API
3. Use as anotações do Jackson (`@JsonProperty`) para mapear os campos da resposta
4. Implemente testes unitários para o serviço
5. Considere implementar cache para melhorar o desempenho

## Bônus

1. Adicione um endpoint para buscar bancos por nome (filtro)
2. Implemente paginação para a lista de bancos
3. Adicione documentação da API usando Swagger/OpenAPI
4. Implemente um serviço de cache para evitar chamadas desnecessárias à API externa

## Exceções Personalizadas

Crie exceções personalizadas para:
- `BancoNaoEncontradoException`: quando um banco não for encontrado pelo código
- `CodigoBancoInvalidoException`: quando o código do banco for inválido
- `BrasilApiException`: para outros erros na comunicação com a API do BrasilAPI

## Testes

Implemente testes unitários para:
- O serviço de banco
- O controller
- O tratamento de erros

## Entrega

1. Crie um repositório Git (se ainda não existir)
2. Faça commits pequenos e atômicos
3. Escreva mensagens de commit claras e objetivas
4. Crie um Pull Request (se aplicável) com uma descrição detalhada das alterações

## Recursos Adicionais

- Documentação da BrasilAPI: https://brasilapi.com.br/docs
- Documentação do Spring Boot: https://spring.io/projects/spring-boot
- Documentação do RestTemplate: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
