# Exercício: Integração com API IBGE

## Objetivo
Criar uma integração com a API do IBGE para buscar informações de estados e municípios do Brasil, seguindo o mesmo padrão de implementação utilizado na integração com a API ViaCEP.

## Requisitos

1. Criar um novo endpoint REST que permita:
   - Listar todos os estados do Brasil
   - Buscar municípios de um estado específico

2. Utilizar a API pública do IBGE:
   - Lista de estados: `https://servicodados.ibge.gov.br/api/v1/localidades/estados`
   - Municípios por UF: `https://servicodados.ibge.gov.br/api/v1/localidades/estados/{UF}/municipios`

3. Implementar seguindo o mesmo padrão do ViaCEP:
   - Criar DTOs para as respostas da API
   - Criar um serviço para encapsular a lógica de integração
   - Criar um controller para expor os endpoints
   - Implementar tratamento de erros adequado

## Tarefas

1. Crie as classes de DTO necessárias para representar:
   - `EstadoResponse`: com campos como id, sigla, nome e região
   - `MunicipioResponse`: com campos como id e nome

2. Crie uma classe de serviço `IbgeService` que irá:
   - Fazer as requisições para a API do IBGE
   - Tratar os dados recebidos
   - Lançar exceções apropriadas

3. Crie um `IbgeController` com os seguintes endpoints:
   - `GET /api/ibge/estados` - Retorna a lista de todos os estados
   - `GET /api/ibge/estados/{uf}/municipios` - Retorna os municípios de um estado

4. Implemente tratamento de erros para:
   - Estado não encontrado
   - Erros de validação (ex: UF inválida)
   - Erros de comunicação com a API

## Dicas

1. Utilize o `RestTemplate` para fazer as requisições HTTP
2. Considere criar constantes para as URLs da API
3. Use as anotações do Jackson (`@JsonProperty`) para mapear os campos da resposta
4. Implemente testes unitários para o serviço

## Exemplo de Resposta Esperada

```json
// GET /api/ibge/estados
[
  {
    "id": 35,
    "sigla": "SP",
    "nome": "São Paulo",
    "regiao": {
      "id": 3,
      "sigla": "SE",
      "nome": "Sudeste"
    }
  },
  // ... outros estados
]

// GET /api/ibbe/estados/SP/municipios
[
  {
    "id": 3500105,
    "nome": "Adamantina"
  },
  {
    "id": 3500204,
    "nome": "Adolfo"
  },
  // ... outros municípios
]
```

## Bônus

1. Adicione cache para as requisições de estados e municípios
2. Implemente paginação para a lista de municípios
3. Adicione um endpoint para buscar um município por CEP (usando a API ViaCEP para obter o código IBGE do município)
