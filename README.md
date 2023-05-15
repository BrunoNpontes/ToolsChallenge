#ToolsJava Challenge [B]

Este projeto consiste em uma API de Pagamentos que foi desenvolvida para atender às operações de pagamento,
estorno e consulta de transações. A API foi construída com Java, utilizando Orientação a Objetos, tratamento de exceções,
validação de dados, testes unitários e versionamento com Git. Além disso, foi utilizado o padrão de Projeto REST,
JSON e protocolo padrão HTTP de retorno.

##Funcionalidades

###Pagamento:
Solicitação e resposta conforme JSON abaixo
###Estorno:
Consulta por ID
Retorno conforme JSON de retorno de estorno
###Consulta:
Consulta por todos e por ID
Retorno conforme JSON de retorno do pagamento

##Tecnologias Utilizadas

Java 17
Spring Boot
Spring Data JPA
H2 Database
Maven

###Como executar o projeto

Certifique-se de ter o JDK 17 instalado em sua máquina.
Clone o repositório do projeto em seu ambiente local.
Abra o projeto em sua IDE de preferência.
Atualize as dependências do Maven para baixar as bibliotecas necessárias.
Execute o arquivo ToolsChallengeApplication.java.
A API estará disponível em http://localhost:8080.
Como testar a API
Para testar a operação de pagamento, envie uma requisição POST para http://localhost:8080/transactions/make/payment, passando o JSON abaixo como payload da requisição:

json
Copy code
{
    "id":"025894367",
    "cartao":"4578545581945618",
    "descricao":{
        "valor":"45.23",
        "dataHora":"21/02/2023 16:23:52",
        "estabelecimento":"Mercadinho vila jardin "
        },
        "formaPagamento": {
            "tipo": "AVISTA",
            "parcelas":"1"

        }
        }


Para testar a operação de consulta de transação por ID, envie uma requisição GET para http://localhost:8080/transactions/consult/payment/{id}, passando o ID da transação que deseja consultar.

Para testar a operação de consulta de todas as transações, envie uma requisição GET para http://localhost:8080/transactions/consult/payment/all.

Para testar a operação de consulta de estorno de transação por ID, envie uma requisição GET para http://localhost:8080/transactions/consult/payment/chargeback/{id}, passando o ID da transação que deseja estornar.

Para testar a operação de consulta de estorno de todas as transações, envie uma requisição GET para http://localhost:8080/transactions/consult/payment/chargeback/all.

##Autor
BrunoNpontes
