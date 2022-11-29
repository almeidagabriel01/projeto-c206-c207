DROP DATABASE IF EXISTS cinema;
CREATE DATABASE IF NOT EXISTS cinema;
USE cinema;

CREATE TABLE IF NOT EXISTS Filme (
	id INT AUTO_INCREMENT,
	nomeFilme VARCHAR(100) NOT NULL,
	genero VARCHAR(50) NOT NULL,
	tempo INT NOT NULL,
	restricaoIdade INT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Ator (
	id INT AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	dataNasc DATE NOT NULL,
	sexo VARCHAR(20) NOT NULL,
	idFilme INT,
	PRIMARY KEY (id),
	CONSTRAINT fk_ator_filme
		FOREIGN KEY (idFilme)
		REFERENCES Filme(id)
		ON DELETE SET NULL
		ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS PC (
	id INT NOT NULL AUTO_INCREMENT,
	modelo VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS PC;

ALTER TABLE Filme CHANGE nomeFilme titulo VARCHAR(50) NOT NULL;
ALTER TABLE Filme ADD diretor VARCHAR(100);
ALTER TABLE Filme DROP restricaoIdade;


# Exercício 1
ALTER TABLE Ator ADD pais VARCHAR(100), ADD idioma VARCHAR(100);

# Exercício 2
ALTER TABLE ATOR CHANGE dataNasc idade INT NOT NULL;

# Exercício 3
ALTER TABLE Ator DROP sexo;

# Exercício 4
INSERT INTO Filme (titulo, genero, tempo) VALUES
    ("Jogos Vorazes", "ação", 143),
    ("O Destino de Júpiter", "ficção científica", 127);
INSERT INTO ATOR (nome, idade, idFilme, pais, idioma) VALUES
    ("Jennifer Lawrence", 30, 1, "EUA", "inglês"),
    ("Josh Hutcherson", 28, 1, "EUA", "inglês"),
    ("Bae Doona", 41, 2, "Coreia do Sul", "coreano"),
    ("Mila Kunis", 35, 2, "Ucrânia", "ucraniano"),
    ("Eddie Redmayne", 38, 2, "Reino Unido", "inglês");
    
# Exercício 5
UPDATE Ator SET idade = 37 WHERE nome = "Mila Kunis";

# Exercício 6
DELETE FROM Ator WHERE id = 5;

# Exercício 7
UPDATE Filme SET id = 43 WHERE id = 1;

# Exercício 8
DELETE FROM Filme WHERE id = 2;

# Exercício 9
ALTER TABLE Ator CHANGE pais paisDeOrigem VARCHAR(100) NOT NULL;

# Exercício 10
ALTER TABLE Ator DROP idade;
SELECT * FROM Filme;
SELECT * FROM Ator;