# Use a imagem oficial do MySQL
FROM mysql:latest

# Define as variáveis de ambiente para a configuração do MySQL
ENV MYSQL_DATABASE=mydatabase
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=abc123
ENV MYSQL_ROOT_PASSWORD=abc123

# Expõe a porta 3306
EXPOSE 3306