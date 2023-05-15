<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    <h1>ToolsJava Challenge</h1>
    <p>Este projeto consiste em uma API de Pagamentos que foi desenvolvida para atender às operações de pagamento, estorno e consulta de transações. A API foi construída com Java, utilizando Orientação a Objetos, tratamento de exceções, validação de dados, testes unitários e versionamento com Git. Além disso, foi utilizado o padrão de Projeto REST, JSON e protocolo padrão HTTP de retorno.</p>
    <h2>Funcionalidades</h2>
    <ul>
      <li>Pagamento: Solicitação e resposta conforme JSON abaixo.</li>
      <li>Estorno: Consulta por ID. Retorno conforme JSON de retorno de estorno.</li>
      <li>Consulta: Consulta por todos e por ID. Retorno conforme JSON de retorno do pagamento.</li>
    </ul>
    <h2>Tecnologias Utilizadas</h2>
    <ul>
      <li>Java 17</li>
      <li>Spring Boot</li>
      <li>Spring Data JPA</li>
      <li>H2 Database</li>
      <li>Maven</li>
    </ul>
    <h2>Como executar o projeto</h2>
    <ol>
      <li>Certifique-se de ter o JDK 17 instalado em sua máquina.</li>
      <li>Clone o repositório do projeto em seu ambiente local.</li>
      <li>Abra o projeto em sua IDE de preferência.</li>
      <li>Atualize as dependências do Maven para baixar as bibliotecas necessárias.</li>
      <li>Execute o arquivo ToolsChallengeApplication.java. A API estará disponível em http://localhost:8080.</li>
    </ol>
    <h2>Como testar a API</h2>
    <ul>
      <li>Para testar a operação de pagamento, envie uma requisição POST para http://localhost:8080/transactions/make/payment, passando o JSON abaixo como payload da requisição:</li>
      <pre>
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
      </pre>
      <li>Para testar a operação de consulta de transação por ID, envie uma requisição GET para http://localhost:8080/transactions/consult/payment/{id}, passando o ID da transação que deseja consultar.</li>
      <li>Para testar a operação de consulta de todas as transações, envie uma requisição GET para http://localhost:8080/transactions/consult/payment/all.</li>
      <li>Para testar a operação de consulta de estorno de transação por ID, envie uma requisição GET para http://localhost:8080/transactions/consult/payment/chargeback/{id}, passando o ID da transação que deseja estornar.</li>

<h2>Autor</h2> 
<h4>BrunoNpontes</h4>
