# Usar uma imagem base oficial do Java 17
FROM openjdk:17-slim

# Definir a variável de ambiente para a porta padrão do Spring Boot
ENV SERVER_PORT 8080

# Expor a porta 8080 para conexão com o Spring Boot
EXPOSE ${SERVER_PORT}

# Adicionar um ponto de montagem para volumes externos
VOLUME /tmp

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR construído para o diretório de trabalho
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Comando para executar o aplicativo
ENTRYPOINT ["java","-jar","/app/app.jar"]