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
   git clone https://github.com/jaco1988/monitoramento-servidores.git
   cd monitoramento-servidores
