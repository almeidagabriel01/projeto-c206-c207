-- Criação do Banco de Dados

CREATE DATABASE IF NOT EXISTS liga_da_justica;
USE liga_da_justica;

-- Criação das Tabelas

CREATE TABLE IF NOT EXISTS Super_Heroi (
    id INT AUTO_INCREMENT,
    nome CHAR(100) NOT NULL,
    idade INT UNSIGNED NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Super_Vilao (
    id INT AUTO_INCREMENT,
    nome CHAR(100) NOT NULL,
    tipo CHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Heroi_Tem_Super_Poder (
    id INT AUTO_INCREMENT,
    nome CHAR(50) NOT NULL,
    id_Heroi INT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk1_Heroi_Tem_Super_Poder
        FOREIGN KEY(id_Heroi)
        REFERENCES Super_Heroi(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Heroi_Inimigo_de_Vilao (
    id_Heroi INT NOT NULL,
    id_Vilao INT NOT NULL,
    PRIMARY KEY(id_Heroi, id_Vilao),
    CONSTRAINT fk1_Heroi_Inimigo_de_Vilao
        FOREIGN KEY(id_Heroi)
        REFERENCES Super_Heroi(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk2_Heroi_Inimigo_de_Vilao
        FOREIGN KEY(id_Vilao)
        REFERENCES Super_Vilao(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Criação dos Usuários
-- Obs.: "IDENTIFIED BY" é usado p/ passar as senhas dos usuários.

CREATE USER IF NOT EXISTS Batman@localhost
IDENTIFIED BY 'Bruce Wayne';

CREATE USER IF NOT EXISTS Superman@localhost
IDENTIFIED BY 'Kal-El';

CREATE USER IF NOT EXISTS WonderWoman@localhost
IDENTIFIED BY 'Diana de Temiscira';