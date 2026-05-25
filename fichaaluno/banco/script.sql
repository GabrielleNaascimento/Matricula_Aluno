CREATE DATABASE IF NOT EXISTS matriculaaluno;
USE matriculaaluno;

CREATE TABLE IF NOT EXISTS aluno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    genero VARCHAR(30),
    escolaridade_publica VARCHAR(50),
    local_nascimento VARCHAR(100),
    pais_origem VARCHAR(100),
    data_nascimento DATE,
    nacionalidade VARCHAR(50),
    filiacao1 VARCHAR(100),
    filiacao2 VARCHAR(100),
    responsavel_legal VARCHAR(100),
    grau_parentesco VARCHAR(50),
    serie_modulo VARCHAR(50),
    periodo VARCHAR(30),
    rua_av VARCHAR(150),
    complemento VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    cep VARCHAR(10),
    telefone VARCHAR(20),
    email VARCHAR(150)
);

USE matriculaaluno;

ALTER TABLE aluno
MODIFY COLUMN data_nascimento VARCHAR(20);