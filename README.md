
# CRUD no Java

Este é um projeto simples de cadastro de carros desenvolvido utilizando Java com Spring Boot JPA e HTML. O objetivo é permitir o registro, a listagem, a atualização e a exclusão de carros (CRUD padrão).

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **HTML**
- **Eclipse IDE**

## Configuração do Ambiente

### Pré-requisitos

- **JDK 17**: Certifique-se de ter o JDK 17 instalado.
- **Eclipse IDE**: Utilize a IDE Eclipse para desenvolvimento.

### Passos para Configuração

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. **Importe o projeto no Eclipse**
   - Abra o Eclipse IDE.
   - Vá para `File` -> `Import`.
   - Selecione `Existing Maven Projects` e clique em `Next`.
   - Navegue até o diretório onde o repositório foi clonado e selecione-o.
   - Clique em `Finish`.

3. **Configure o banco de dados**
   - Configure o arquivo `application.properties` para se conectar ao seu banco de dados. Aqui está um exemplo de configuração usando H2 Database:
     ```properties
     spring.datasource.url=jdbc:h2:mem:testdb
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=sa
     spring.datasource.password=password
     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
     spring.h2.console.enabled=true
     ```

4. **Execute a aplicação**
   - Na Eclipse IDE, clique com o botão direito no projeto.
   - Selecione `Run As` -> `Spring Boot App`.

## Estrutura do Projeto

- **src/main/java**: Contém os arquivos de código fonte.
  - **com.example.cadastrocarros**: Pacote principal da aplicação.
    - **controller**: Contém os controladores REST.
    - **model**: Contém as entidades JPA.
    - **repository**: Contém os repositórios JPA.
    - **service**: Contém a lógica de negócios.

- **src/main/resources**: Contém arquivos de configuração.
  - **application.properties**: Configurações da aplicação.

## Endpoints da API

- **GET /cars**: Lista todos os carros.
- **POST /cars**: Cadastra um novo carro.
- **PUT /cars/{id}**: Atualiza um carro existente.
- **DELETE /cars/{id}**: Exclui um carro existente.

