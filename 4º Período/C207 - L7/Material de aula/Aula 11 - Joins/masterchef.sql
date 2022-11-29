-- Criação do Banco de Dados

DROP DATABASE IF EXISTS masterchef;
CREATE DATABASE masterchef;
USE masterchef;

CREATE TABLE IF NOT EXISTS Competidor (
    id INT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL,
    profissao VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Jurado (
    id INT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    paisOrigem VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Julgar (
    idCompetidor INT,
    idJurado INT,
    PRIMARY KEY (idCompetidor, idJurado),
    CONSTRAINT `fk1_Competidor`
        FOREIGN KEY (idCompetidor)
        REFERENCES Competidor (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT `fk2_Jurado`
        FOREIGN KEY (idJurado)
        REFERENCES Jurado (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS Prato (
    id INT AUTO_INCREMENT,
    tipoCulinaria VARCHAR(50) NOT NULL,
    idCompetidor INT NOT NULL,
    nota FLOAT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk3_Competidor`
        FOREIGN KEY (idCompetidor)
        REFERENCES Competidor (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Inserção de Dados

INSERT INTO Competidor (nome, idade, profissao, cidade, estado)
VALUES
    ("Janaina Caetano", 38, "Taróloga", "Diadema", "SP"),
    ("Rodrigo Massoni", 33, "Engenheiro Ambiental", "Osasco", "SP"),
    ("Lorena Dayse", 35, "Enfermeira", "Teresina", "PI"),
    ("Helton Oliveira", 19, "Estudante", "Jacutinga", "MG"),
    ("Haila Santuá", 25, "Publicitária", "Chapadão do Céu", "GO"),
    ("Fabio", "21", "Estudante", "Guaratinguetá", "SP");

INSERT INTO Jurado (nome, paisOrigem)
VALUES
    ("Paola Carosella", "Argentina"),
    ("Érick Jacquin", "França"),
    ("Henrique Fogaça", "Brasil");

INSERT INTO Julgar (idJurado, idCompetidor)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (2, 3),
    (2, 5),
    (3, 1),
    (3, 2),
    (3, 4);

INSERT INTO Prato (tipoCulinaria, nota, idCompetidor)
VALUES
    ("Japonesa", 9.5, 1),
    ("Italiana", 8.7, 1),
    ("Francesa", 9.2, 2),
    ("Brasileira", 4.6, 3),
    ("Francesa", 2.7, 4),
    ("Francesa", 8.0, 4),
    ("Chinesa", 7.5, 4),
    ("Japonesa", 3.0, 5);

-- Respostas

SELECT pr.nota, comp.nome, comp.idade, comp.cidade FROM Prato AS pr
INNER JOIN Competidor AS comp
    ON comp.id = pr.idCompetidor AND comp.estado = "SP";

SELECT comp.nome, comp.idade, comp.profissao FROM Julgar AS jul
INNER JOIN Competidor AS comp
    ON jul.idCompetidor = comp.id
INNER JOIN Jurado AS jur
    ON jul.idJurado = jur.id AND jur.nome = "Paola Carosella";

SELECT AVG(pr.nota) AS `Nota Média` FROM Prato AS pr
INNER JOIN Competidor AS comp
    ON pr.idCompetidor AND comp.profissao LIKE "E%";

SELECT MAX(pr.nota) AS `Maior Nota` FROM Prato AS pr
INNER JOIN Competidor AS comp
    ON pr.idCompetidor = comp.id AND comp.idade < 28;

SELECT jur.nome, jur.paisOrigem, comp.nome, comp.idade, comp.cidade FROM Julgar AS jul
INNER JOIN Competidor AS comp
    ON jul.idCompetidor = comp.id
INNER JOIN Jurado AS jur
    ON jul.idJurado = jur.id;

SELECT DISTINCT(pr.tipoCulinaria) FROM Prato AS pr
INNER JOIN Competidor AS comp
    ON pr.idCompetidor = comp.id AND comp.estado = "SP";

SELECT DISTINCT(jur.paisOrigem) AS `Origem do Jurado` FROM Julgar AS jul
INNER JOIN Jurado AS jur
    ON jul.idJurado = jur.id
INNER JOIN Competidor AS comp
    ON jul.idCompetidor = comp.id AND comp.idade > 30;

SELECT pr.tipoCulinaria, comp.nome FROM Competidor AS comp
INNER JOIN Prato AS pr
    ON comp.id = pr.idCompetidor
INNER JOIN Julgar AS jul
    ON pr.idCompetidor = jul.idCompetidor
INNER JOIN Jurado AS jur
    ON jul.idJurado = jur.id AND jur.nome = "Érick Jacquin";