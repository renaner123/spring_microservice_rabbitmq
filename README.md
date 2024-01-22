[![LinkedIn][linkedin-shield]][linkedin-url]

<a name="readme-top"></a>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
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
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

Este repositório contém um exemplo simples de uma arquitetura de microserviços e os passos necessários para realizar uma comunicação assíncrona entre dois microserviços utilizando mensageria e RabbitMQ. O cenário do projeto é o seguinte:
- O microserviço User produzirá mensagens que serão enviadas para o Broker, onde o Exchange receberá a mensagem e realizará a análise da mensagem recebida; em seguida, roteia para a respectiva Queue (default). Por fim, o microserviço de e-mail, que está conectado a essa fila, consumirá as mensagens à medida que chegam. O CloudAMQP será responsável por monitorar o RabbitMQ (Broker) na nuvem (Exchange e Queue). Além disso, adicionei os microserviços em containers Docker. 

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

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* npm
  ```sh
  npm install npm@latest -g
  ```

### Installation

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
   ```sh
   git clone https://github.com/github_username/repo_name.git
   ```
3. Install NPM packages
   ```sh
   npm install
   ```
4. Enter your API in `config.js`
   ```js
   const API_KEY = 'ENTER YOUR API';
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [ ] Feature 1
- [ ] Feature 2
- [ ] Feature 3
    - [ ] Nested Feature

See the [open issues](https://github.com/github_username/repo_name/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Your Name - [@twitter_handle](https://twitter.com/twitter_handle) - email@email_client.com

Project Link: [https://github.com/github_username/repo_name](https://github.com/github_username/repo_name)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* []()
* []()
* []()

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png

