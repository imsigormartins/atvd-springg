-- gerar migrations V1

-- V1__Initial_migration.sql

CREATE TABLE ponto_coleta (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    endereco VARCHAR(255) NOT NULL,
    quantidade INT NOT NULL,
    tipo_residuo VARCHAR(255) NOT NULL,
    observacao VARCHAR(255),
    rota_id BIGINT
);

CREATE TABLE agendamento (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    tipo_residuo VARCHAR(255) NOT NULL,
    quantidade INT NOT NULL,
    observacao VARCHAR(255),
    ponto_coleta_id BIGINT,
    FOREIGN KEY (ponto_coleta_id) REFERENCES ponto_coleta(id)
);