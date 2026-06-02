# Hipatec API

Backend da aplicacao Hipatec, desenvolvido com Java, Spring Boot e Spring Data JPA. A API fornece endpoints para cadastro, listagem e login de estudantes e mentoras, alem de cadastro/listagem de mentorias.

## Stack

- Java 17
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- Spring Security
- H2 Database para desenvolvimento local
- SQL Server JDBC para ambiente remoto
- Gradle Wrapper
- Lombok
- SpringDoc OpenAPI

## Estrutura principal

```text
src/main/java/com/solucao/hipatec/
├── config/          # Configuracoes de seguranca
├── controller/      # Endpoints REST
├── model/           # Entidades JPA
├── repository/      # Repositories Spring Data
├── service/         # Regras de negocio
└── HipatecApplication.java

src/main/resources/
├── application.properties          # Configuracao remota original
├── application-local.properties    # Configuracao local com H2
└── data-local.sql                  # Dados iniciais para desenvolvimento
```

## Como rodar localmente

```bash
./gradlew bootRun --args='--spring.profiles.active=local'
```

A API sobe em:

```text
http://localhost:8080
```

## Banco local H2

O perfil `local` usa H2 em arquivo:

```text
jdbc:h2:file:./data/hipatec-local
```

Console H2:

```text
http://localhost:8080/h2-console
```

Credenciais:

- JDBC URL: `jdbc:h2:file:./data/hipatec-local`
- User: `sa`
- Password: vazio

Os dados iniciais ficam em `src/main/resources/data-local.sql`.

## Dados de teste

- Estudante: `estudante@local.com` / `123456`
- Mentora: `mentora@local.com` / `123456`

## Endpoints

### Estudantes

```http
GET /estudantes
POST /estudantes
POST /estudantes/login?email={email}&senha={senha}
```

Exemplo de login:

```bash
curl -X POST 'http://localhost:8080/estudantes/login?email=estudante@local.com&senha=123456'
```

Resposta esperada:

```json
{
  "authenticated": true,
  "userId": 1,
  "message": "Login realizado com sucesso."
}
```

### Mentoras

```http
GET /mentoras
POST /mentoras
POST /mentoras/login?email={email}&senha={senha}
```

Exemplo:

```bash
curl -X POST 'http://localhost:8080/mentoras/login?email=mentora@local.com&senha=123456'
```

### Mentorias

```http
GET /mentorias
POST /mentorias
```

## Modelos

### Estudante

Campos principais:

- `id`
- `nome`
- `email`
- `senha`
- `dataNascimento`

### Mentora

Campos principais:

- `id`
- `nome`
- `email`
- `senha`
- `dataNascimento`

### Mentoria

Campos principais:

- `id`
- `titulo`
- `descricao`
- `progresso`
- `idMentora`

## CORS e seguranca

A configuracao atual permite requisicoes locais vindas de:

- `http://localhost:*`
- `http://127.0.0.1:*`
- `http://192.168.*:*`

O CSRF esta desabilitado e as rotas estao liberadas para facilitar o desenvolvimento. Antes de usar em producao, revise autenticacao, autorizacao, armazenamento de senha e politica de CORS.

## Testes

```bash
./gradlew test -Dspring.profiles.active=local
```

## Troubleshooting

Se `./gradlew` falhar com permissao negada:

```bash
chmod +x gradlew
```

Se a porta 8080 estiver ocupada, finalize o processo antigo ou rode em outra porta:

```bash
./gradlew bootRun --args='--spring.profiles.active=local --server.port=8081'
```

Se quiser resetar o banco local, pare a aplicacao e remova a pasta `data/`.
