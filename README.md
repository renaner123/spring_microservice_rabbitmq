[![LinkedIn][linkedin-shield]][linkedin-url]

<a name="readme-top"></a>

<details>
  <summary>Table of Content</summary>
  <ol>
    <li>
      <a href="#table-of-content">Table of Content</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#useful-commands">Useful commands</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## Table of Content

Este repositório contém um exemplo simples de uma arquitetura de microserviços e os passos necessários para realizar uma comunicação assíncrona entre dois microserviços utilizando mensageria e RabbitMQ. O cenário do projeto é o seguinte:
- O microserviço User produzirá mensagens que serão enviadas para o Broker (RabbitMQ), onde o Exchange receberá a mensagem e realizará a análise da mensagem recebida; em seguida, roteia para a respectiva Queue (default). Por fim, o microserviço de e-mail, que está conectado a essa fila, consumirá as mensagens à medida que chegam. O CloudAMQP será responsável por monitorar o RabbitMQ (Broker) na nuvem (Exchange e Queue). Além disso, adicionei algus serviços em containers Docker. 

![](figs/project_flow.PNG)
Fonte: Michelli Brito

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

- [![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.7-success?logo=spring)](https://spring.io/projects/spring-boot)
- [![Java](https://img.shields.io/badge/Java-17-blue?logo=java)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [![Maven](https://img.shields.io/badge/Maven-3.8.4-orange?logo=apache-maven)](https://maven.apache.org/)
- [![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?logo=postgresql)](https://www.postgresql.org/)
- [![RabbitMQ](https://img.shields.io/badge/RabbitMQ-3.9.10-brightgreen?logo=rabbitmq)](https://www.rabbitmq.com/)
- [![CloudAMQP](https://img.shields.io/badge/CloudAMQP-Latest-yellow?logo=cloudamqp)](https://www.cloudamqp.com/)
- [![SMTP Gmail](https://img.shields.io/badge/SMTP%20Gmail-Latest-red?logo=gmail)](https://support.google.com/a/answer/176600?hl=en)
- [![Docker](https://img.shields.io/badge/Docker-24-blue?logo=docker)](https://www.docker.com/)


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started


### Prerequisites

É necessário configurar as variavéis de ambiente, descritas abaixo, no sistema. A Queue do Cloud AMQP deve possuir o nome `default.email`. Caso queira usar uma fila com nome diferente, pode-se alterar diretamente no arquivo [application.properties](email\src\main\resources\application.properties).

- `AMQPS_CLOUD`=url da instância do RabbitMQ na CloudAMQP
- `GMAIL_USERNAME`=email que será utilizado para os envios de emails
- `GMAIL_SENHA_APP`=[senha de app google](https://support.google.com/accounts/answer/185833) para autenticação do email

### Installation

Para preparar o ambiente para execução dos microserviços é necessário inicializar um banco de dados PostgreSQL para o microserviço `User` e um para o microserviço `Email`. Para fazer isso, é necessário executar o docker compose conforme exemplo abaixo. Além dos bancos de dados, também será instanciado o microserviço `User`.

``` 
docker compose up
```

Para garantir que o microserviço de e-mail realizará o consumo das mensagens da fila do RabbitMQ, é necessário executar o microserviço fora dos containeres Docker, para isso, é necessário os seguintes passos:

```shell
cd email
mvn clean install -DSkipTests
java -jar target/email-0.0.1-SNAPSHOT.jar
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- USAGE EXAMPLES -->
## Usage

Com o ambiente preparado, para testar os microserviços, é necessário utilizar alguma plataforma de API e enviar um `POST` para a rota `address_container:8081/users` contendo o seguinte corpo:

```json
{
    "name": "Renan",
    "email": "emailteste@email.com"
}
```

Como resposta, é esperado o seguinte corpo:

```json
{
    "userId": "13ff124c-792b-491b-a231-c5aa78b103a6",
    "name": "Renan",
    "email": "emailtestesdevrenan@gmail.com"
}
```

Se tudo ocorreu bem, o e-mail já deve ter recebido uma mensagem de boas vindas. A mensagem pode alterar [aqui](user\src\main\java\com\ms\user\producers\UserProducer.java)

<!-- ROADMAP -->
## Roadmap

- [ ] Fazer validações dos e-emails
- [ ] Fazer microserviço Email funcionar no ambiente docker
- [ ] Implementar novos métodos
- [ ] Criar testes unitários
- [ ] Escalar os microserviços
- [ ] Testar outros Exchanges


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Se você tiver uma sugestão que tornaria isso melhor, por favor, faça um fork do repositório e crie uma pull request. Você também pode simplesmente abrir um problema com a tag "melhoria".
Obrigado!

1. Faça um Fork do Projeto
1. Crie seu Branch de Funcionalidade (`git checkout -b feature/AmazingFeature`)
1. Faça Commits nas suas Mudanças (`git commit -m 'Add some AmazingFeature'`)
1. Faça o Push para o Branch (`git push origin feature/AmazingFeature`)
1. Abra uma Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Renan Rodolfo - [Linkedin](https://www.linkedin.com/in/renanrodolfo/) - rrenanrds@gmail.com

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Useful commands

```shell 
# Verificar log de um container chamado ms-user-pg
docker logs ms-user-pg
```

# Acessar um container postgresql
```shell 
docker exec -it ms-user-pg psql -U postgres
```
# Iniciar um container postgresql
```shell 
docker run -p 5432:5432 --name ms-user-pg --network ms-rabbit -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=db_user postgres:12-alpine
```
# Executar um projeto maven da pasta user utilizando Dockerfile
```shell 
mvn clean install -DskipTests
cd user
docker build -t ms-user:v1 .
docker run -p 8081:8081 --network ms-rabbit ms-user:v1
```


