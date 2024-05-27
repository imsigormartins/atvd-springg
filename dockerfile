# Use a imagem oficial do Java para executar um aplicativo Spring Boot
FROM openjdk:8-jdk-alpine

ARG APP_DIR=/app

RUN mkdir -p $APP_DIR

WORKDIR $APP_DIR

COPY ./target/smartCity-0.0.1-SNAPSHOT.jar $APP_DIR

EXPOSE 8080

# Comando para iniciar o aplicativo
CMD ["java", "-jar", "smartCity-0.0.1-SNAPSHOT.jar"]