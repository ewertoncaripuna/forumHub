# forumHub
# Projeto ForumHub

Desafio Fórum Hub da Alura e Oracle: uma API REST para gerenciar tópicos e respostas similar a fóruns, com autenticação de usuários e regras de negócios específicas para interação.

## Funcionalidades

- Buscar livro da API e inserir no banco de dados Postgres
- Cadastrar usuários
- Listar usuários registrados
- Inserir, atualizar e excluir tópicos
- Responder e excluir respostas
- Autenticar
- Excluir usuários

## Regras de negócio

- Apenas usuários logados podem inserir tópicos e ver cursos
- Respostas podem ser deletadas apenas pelos criadores das respostas ou dos tópicos
- Tópicos podem ser deletados apenas pelos seus criadores
- Usuários podem ser deletados apenas por si próprios e devem estar logados

## Diagrama ER

```mermaid
erDiagram
    USUARIOS {
        bigint id PK
        varchar nome
        varchar email
        varchar senha
        tinyint ativo
    }
    
    CURSOS {
        bigint id PK
        varchar nome
        varchar categoria
    }
    
    TOPICOS {
        bigint id PK
        varchar titulo
        varchar mensagem
        datetime data
        varchar status
        bigint curso_id FK
        bigint usuario_id FK
    }
    
    RESPOSTAS {
        bigint id PK
        varchar mensagem
        bigint usuario_id FK
        bigint topico_id FK
        datetime data
    }

    USUARIOS ||--o{ TOPICOS : "fk_topicos_usuario_id"
    CURSOS ||--o{ TOPICOS : "fk_topicos_cursos_id"
    USUARIOS ||--o{ RESPOSTAS : "fk_respostas_usuario_id"
    TOPICOS ||--o{ RESPOSTAS : "fk_respostas_topico_id"
```

## Como usar

Para fazer autenticação, basta rodar o projeto localmente e usar os endpoints abaixo ou usando a interface swagger-ui:

http://localhost:8080/swagger-ui/index.html#/

Login

Para fim de teste, a aplicação possui migration com esses dados já inseridos. Basta acessar com os dados abaixo.

- POST /login
```
Request Body:
{
    "email": "teste@mail.com",
    "senha": "123456"
}

```
Cadastrar usuário

- POST /cadastro_usuario

```
Request Body:
{
    "nome": "Nome do Usuário",
    "email": "usuario@example.com",
    "senha": "senha123"
}
```
Listar usuários
- GET /usuarios

Deletar usuário

- DELETE /usuarios/{id}

Listar Cursos

- GET /cursos
```
Authorization: Bearer token_jwt_aqui
```
Detalhar Curso
- GET /cursos/{id}
```
Authorization: Bearer token_jwt_aqui
```

Criar Tópico
- POST /topicos
```
Authorization: Bearer token_jwt_aqui

Request Body:
{
    "titulo": "Título do Tópico",
    "mensagem": "Mensagem do Tópico",
    "curso_id": 1,
    "usuario_id": 1
}
```
Listar Tópicos

- GET /topicos
```
Authorization: Bearer token_jwt_aqui
```
Detalhar Tópico

- GET /topicos/{id}
```
Authorization: Bearer token_jwt_aqui
```

Atualizar Tópico

- PUT /topicos/{id}
```
Authorization: Bearer token_jwt_aqui

Request Body:
{
    "titulo": "Novo Título",
    "mensagem": "Nova Mensagem"
}
```
Excluir Tópico

- DELETE /topicos/{id}
```
Authorization: Bearer token_jwt_aqui

Request Body:
{
    "usuario_id": 1
}
```
Criar Resposta
- POST /respostas
```Request Body:
{
    "mensagem": "Mensagem da Resposta",
    "usuario_id": 1,
    "topico_id": 1
}
```
Excluir Resposta
- DELETE /respostas/{id}
