# GameDatabase API - Gerenciador de Jogos
#### Este projeto é uma API RESTful para gerenciamento de jogos. A API fornece endpoints para CRUD (Create, Read, Update, Delete) operações em jogos, usando Java "puro".

### Sumário

- [Descrição](#descricao)
- [Configuração](#configuracao)
- [Instalação](#instalacao)
- [Uso Localmente](#usolocalmente)
- [Endpoints](#endpoints)

## Descrição

#### O GameDatabase API permite a criação, leitura, atualização e exclusão de informações sobre jogos. Ele utiliza um banco de dados PostgreSQL para armazenamento de dados e é acessado através de endpoints RESTful.

## Tecnologia

- Java 21
- PostgreSQL
- Postman
- Gson
- HttpServer

## Configuração
1. Configurando o Banco de Dados
  - A classe Database configura a conexão com o banco de dados PostgreSQL usando o USER e PASSWORD.
2. Inicialização do Banco de Dados
 -  A classe DatabaseInitializer lê o arquivo schema.sql localizado em src/main/resources/db/schema.sql para criar as tabelas necessárias de forma automárica.

## Uso Localmente
1. Clone o Repositório
```
git clone https://github.com/LucasStorck/GameDatabaseApi.git
```

2. Cofigure a classe Database com o seu usuário e senha
```
private static final String USER = "";
private static final String PASSWORD = "";
```
4. Compile e execute a aplicação

## Endpoints
- GET /games: Retorna todos os jogos.
- GET /games/{id}: Retorna detalhes de um jogo específico.
- POST /games: Cria um novo jogo.
- PUT /games: Atualiza informações de um jogo existente.
- DELETE /games/{id}: Exclui um jogo específico.
