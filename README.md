# POC: Utilizando DynamoDB com Spring

## Contexto:
O Amazon DynamoDB é um banco de dados chave-valor que oferece desempenho de menos de 10 milisegundos independente da escala do banco de dados. Essa poc tem como objetivo cadastrarmos um produto no banco de dados e depois listarmos os produtos que foram cadastrados.

## Tecnologias:
- Java 11
- Spring boot
- Spring Data
- Spring Validator
- AWS CLI
- Docker
- Maven
- dynamo dependency(Maven)
- Localstack
## Como executar:

#### Requisitos:
- Java 11
- AWS CLI
- Maven
- Docker

#### Passo a passo:

1. Primeiro precisaremos subir um container docker do localstack:  
`docker-compose up'-d --build`.
2. Utilizando o AWS CLI criaremos a tebela que armazenará as informações do produto:  
`aws dynamodb create-table --table-name Product --attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 --endpoint-url http://localhost:4566`.
3. Agora podemos rodar o projeto:  
`mvn spring-boot:run`.
4. Através do Postman na url `http://localhost:8080/api/product` podemos fazer uma requisição POST com o body como o do exemplo:
``` JSON
{
    "name":"Product",
    "description":"the product is beautiful",
    "stock": 1,
    "price": 10.64
}
```
o retorno para os casos de sucesso deve ser um 201 com o produto criado no body.  

5. Para verificar se a informação foi salva com sucesso, podemos fazer uma requisiçao GET para `http://localhost:8080/api/product`, e será retornado todos os produtos salvos.
