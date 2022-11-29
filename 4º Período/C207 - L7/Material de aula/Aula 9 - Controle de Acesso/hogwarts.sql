CREATE DATABASE IF NOT EXISTS hogwarts;
USE hogwarts;
-- Criando Tabela de Escola
CREATE TABLE IF NOT EXISTS Escola (
    id INT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    localizacao VARCHAR(100) NOT NULL,
    ano_fundacao INT NOT NULL,
    PRIMARY KEY (id)
);
-- Criando Tabela de Casa
CREATE TABLE IF NOT EXISTS Casa (
    id INT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    nome_fundador VARCHAR(100) NOT NULL,
    nome_fantasma VARCHAR(100) NOT NULL,
    id_Escola INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_Casa_Escola1
		FOREIGN KEY (id_Escola)
        REFERENCES Escola (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
-- Criando Tabela de Animal
CREATE TABLE IF NOT EXISTS Animal (
    id INT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);
-- Criando Tabela de Varinha
CREATE TABLE IF NOT EXISTS Varinha (
    id INT AUTO_INCREMENT,
    tipo_madeira VARCHAR(50) NOT NULL,
    tipo_nucleo VARCHAR(50) NOT NULL,
    tamanho FLOAT NOT NULL,
    PRIMARY KEY (id)
);
-- Criando Tabela de Bruxo
CREATE TABLE IF NOT EXISTS Bruxo (
    id INT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    profissao VARCHAR(25) NOT NULL,
    idade INT UNSIGNED NOT NULL,
    habilidade_especial VARCHAR(100) NOT NULL,
    id_Casa INT NOT NULL,
    id_Animal INT DEFAULT NULL,
    id_Varinha INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_Bruxo_Casa1
		FOREIGN KEY (id_Casa)
		REFERENCES Casa (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_Bruxo_Animal1
		FOREIGN KEY (id_Animal)
		REFERENCES Animal (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_Bruxo_Varinha1
		FOREIGN KEY (id_Varinha)
        REFERENCES Varinha (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
-- Criando Tabela de Relacionamento (Bruxo - Bruxo)
CREATE TABLE IF NOT EXISTS Bruxo_ensina_Bruxo (
    id_Bruxo_professor INT NOT NULL,
    id_Bruxo_aluno INT NOT NULL,
    PRIMARY KEY (id_Bruxo_aluno, id_Bruxo_professor),
    CONSTRAINT fk_Bruxo_has_Bruxo_Bruxo1
		FOREIGN KEY (id_Bruxo_professor)
        REFERENCES Bruxo (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT fk_Bruxo_has_Bruxo_Bruxo2
		FOREIGN KEY (id_Bruxo_aluno)
        REFERENCES Bruxo (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
-- Crianco Tabela de Relacionamento (Bruxo - Animal)
CREATE TABLE IF NOT EXISTS Time (
    id INT AUTO_INCREMENT,
    nome_apanhador VARCHAR(100) NOT NULL,
    nome_goleiro VARCHAR(100) NOT NULL,
    nome_treinador VARCHAR(100) NOT NULL,
    num_vassouras INT UNSIGNED NOT NULL,
    id_Escola INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_Time_Escola1
		FOREIGN KEY (id_Escola)
        REFERENCES Escola (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);