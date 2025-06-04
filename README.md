# CRM - Customer Relationship Management

## Descrição

Este é um sistema básico de CRM (Customer Relationship Management) desenvolvido em Java com Spring Boot. O objetivo do projeto é gerenciar informações de clientes, produtos, vendas e notificações, facilitando o acompanhamento e relacionamento com os clientes.

O projeto segue o padrão MVC (Model-View-Controller) e utiliza Spring Data JPA para persistência de dados em banco H2 (banco em memória para desenvolvimento).

## Funcionalidades

- Cadastro e gerenciamento de clientes.
- Cadastro e gerenciamento de produtos.
- Registro e acompanhamento de vendas.
- Sistema de notificações para clientes.
- Relatórios simples integrados ao sistema.
- Uso do padrão MVC para organização do código.
- Integração com banco de dados H2 para facilitar testes e desenvolvimento.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Banco de dados H2 (em memória)
- Maven (gerenciador de dependências)
- Swagger (OpenAPI) para documentação da API

## Como Rodar o Projeto

### Pré-requisitos

- Java 17 ou superior instalado.
- Maven instalado (para compilação e gerenciamento de dependências).

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/ruantor4/crm.git
   cd crm

2. Compile e rode a aplicação usando Maven:

   ```bash
    mvn clean spring-boot:run
3. Acesse a API no navegador ou via ferramentas como Postman:

URL base: http://localhost:8080/

Documentação Swagger: http://localhost:8080/swagger-ui.html

## Estrutura do Projeto

- model — Classes que representam as entidades do domínio (Cliente, Produto, Venda, Notificação, etc).
- repository — Interfaces para acesso e manipulação dos dados no banco.
- service — Lógica de negócio do sistema, onde ficam as regras e operações principais.
- controller — Endpoints REST para comunicação com clientes via HTTP.
- config — Configurações da aplicação (ex: Swagger, banco, etc).

## Próximos Passos e Melhorias

- Implementar autenticação e autorização de usuários.
- Melhorar a interface do usuário (adicionar frontend).
- Adicionar testes unitários e de integração.
- Criar relatórios mais completos e exportáveis.
- Integrar com banco de dados real (MySQL, PostgreSQL).

## Contato

Para Dúvidas ou sugestões, entre em contato: ruan.tor4@hotmail.com
