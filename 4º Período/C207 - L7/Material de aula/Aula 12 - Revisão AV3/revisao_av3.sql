-- Criação do Banco de Dados

CREATE DATABASE IF NOT EXISTS polo_norte;
USE polo_norte;

-- Criação das Tabelas

CREATE TABLE IF NOT EXISTS Elfo (
    id INT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    departamento VARCHAR(50) NOT NULL,
    funcao VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Crianca (
    id INT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    idade INT NOT NULL,
    pais VARCHAR(50) NOT NULL,
    continente VARCHAR(50) NOT NULL,
    acredita_em_Papai_Noel BOOLEAN NOT NULL,
    `é bonzinho` BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Presente (
    id INT AUTO_INCREMENT,
    id_Crianca INT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    material VARCHAR(50) NOT NULL,
    peso INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk1
        FOREIGN KEY (id_Crianca)
        REFERENCES Crianca (id)
        ON UPDATE CASCADE
);

-- Criação dos Usuários

CREATE USER IF NOT EXISTS PapaiNoel@localhost;
GRANT SELECT, DELETE ON polo_norte.Crianca TO PapaiNoel@localhost;

CREATE USER IF NOT EXISTS Pai@localhost;
GRANT SELECT (nome) ON polo_norte.Crianca TO Pai@localhost;

CREATE USER IF NOT EXISTS Krampus@localhost;

-- Verificando Privilégios

SHOW GRANTS FOR PapaiNoel @localhost;
SHOW GRANTS FOR Pai @localhost;
SHOW GRANTS FOR Krampus @localhost;