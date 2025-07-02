# Monitoramento de Servidores

Projeto desenvolvido em Java com Spring Boot para monitorar a disponibilidade e velocidade de resposta de servidores e serviços, com interface REST para consulta dos status.

## Funcionalidades

- Monitoramento automático periódico (a cada 60 segundos) de URLs configuradas.
- Retorno via API REST JSON com status (OK ou ERRO) e tempo de resposta.
- Código organizado em camada de serviço e controlador REST.
- Dockerfile para containerização do projeto.

## Tecnologias utilizadas

- Java 11
- Spring Boot
- Maven
- Docker

## Como rodar localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/monitoramento-servidores.git
   cd monitoramento-servidores
   ```

2. Compile o projeto:
   ```bash
   mvn clean package
   ```

3. Execute o jar:
   ```bash
   java -jar target/monitoramento-servidores-1.0.0.jar
   ```

4. Acesse no navegador ou via curl:
   ```
   http://localhost:8080/status
   ```

## Rodando com Docker

1. Construa a imagem Docker:
   ```bash
   docker build -t monitoramento-servidores .
   ```

2. Rode o container:
   ```bash
   docker run -p 8080:8080 monitoramento-servidores
   ```

## Configuração

Você pode alterar as URLs monitoradas diretamente no código no serviço `MonitoramentoService`.

## Autor

Thalisson Furtado Jacó  
Email: thalissongt500@hotmail.com
