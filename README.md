# Hipatec Backend

Backend da Hipatec, uma plataforma acadêmica voltada ao acolhimento, permanência, mentoria, troca de conhecimento e representatividade de mulheres do IFSP na área de tecnologia.

Este repositório contém a API responsável por fornecer os dados e fluxos básicos utilizados pelo frontend `hipatec-app` durante o MVP.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database para ambiente local
- Gradle Wrapper
- Lombok

## Instalação

Acesse a pasta do projeto Spring Boot:

```bash
cd hipatec
```

Execute o build para baixar dependências e compilar o projeto:

```bash
./gradlew build
```

## Execução local

Para iniciar a API com o perfil local:

```bash
./gradlew bootRun --args='--spring.profiles.active=local'
```

A API ficará disponível em:

```text
http://localhost:8080
```

## Configuração de ambiente

O perfil local usa o arquivo:

```text
hipatec/src/main/resources/application-local.properties
```

Nesse perfil, o projeto utiliza banco H2 local em arquivo. O console H2, quando habilitado, fica disponível em:

```text
http://localhost:8080/h2-console
```

Dados iniciais de desenvolvimento podem ser carregados por:

```text
hipatec/src/main/resources/data-local.sql
```

## Estrutura de pastas

```text
hipatec/
├── README.md
└── hipatec/
    ├── build.gradle
    ├── settings.gradle
    ├── src/main/java/com/solucao/hipatec/
    │   ├── config/        # Configurações da aplicação
    │   ├── controller/    # Controllers REST
    │   ├── model/         # Entidades JPA
    │   ├── repository/    # Repositórios de acesso a dados
    │   └── service/       # Serviços de regra de negócio
    └── src/main/resources/
        ├── application.properties
        ├── application-local.properties
        └── data-local.sql
```

## Arquitetura resumida

O backend segue uma estrutura simples em camadas:

- `controller`: expõe os endpoints REST.
- `service`: centraliza regras de aplicação e chamadas aos repositórios.
- `repository`: integra com o banco via Spring Data JPA.
- `model`: define as entidades principais do domínio.
- `config`: mantém configurações gerais da aplicação.

## Endpoints principais

### Estudantes

```http
GET /estudantes
POST /estudantes
POST /estudantes/login?email={email}&senha={senha}
```

### Mentoras

```http
GET /mentoras
POST /mentoras
POST /mentoras/login?email={email}&senha={senha}
```

### Mentorias

```http
GET /mentorias
POST /mentorias
```

### Verificação básica

```http
GET /
```

## Observações do MVP

- A autenticação atual é simples e voltada ao protótipo acadêmico.
- O backend ainda não representa uma solução pronta para produção.
- O banco H2 local é usado para facilitar testes e demonstrações.
- O foco do MVP é sustentar os fluxos principais da Hipatec: cadastro, login, perfis, mentorias e apoio à comunidade.

## Status do projeto

MVP acadêmico em desenvolvimento.

A Hipatec tem como propósito apoiar a permanência e o crescimento de mulheres na tecnologia por meio de uma rede de acolhimento, mentoria, oportunidades e representatividade.
