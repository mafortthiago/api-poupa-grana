# API Spring com PostgreSQL e Spring Security

Este projeto é uma API RESTful desenvolvida com Spring Boot e Spring Security, que se conecta a um banco de dados PostgreSQL. A API permite operações CRUD (Create, Read, Update, Delete) em itens e também fornece rotas de autenticação.

A api está servindo o projeto [Poupa grana](https://github.com/mafortthiago/poupa-grana).

## Tecnologias Utilizadas

- **Spring Boot**: Framework utilizado para facilitar o desenvolvimento de aplicações Spring.
- **Spring Security**: Usado para adicionar segurança à nossa API.
- **JWT (JSON Web Token)**: Usado para autenticação e autorização.
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional utilizado para armazenar nossos dados.
- **DTOs (Data Transfer Objects)**: Usados para enviar e receber dados de forma eficiente e segura.
- **Security Filter**: Usado para adicionar uma camada extra de segurança, filtrando as requisições para a API.

## Funcionalidades

- **POST /auth/register**: Registra um novo usuário.
- **POST /auth/login**: Autentica um usuário existente.
- **GET /items**: Retorna todos os itens.
- **GET /items/{id}**: Retorna o item com o ID especificado.
- **POST /items**: Cria um novo item.
- **PUT /items/{id}**: Atualiza o item com o ID especificado.
- **DELETE /items/{id}**: Deleta o item com o ID especificado.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.


