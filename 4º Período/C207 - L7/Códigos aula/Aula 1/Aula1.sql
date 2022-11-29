# --------------------------- CRIANDO O BANCO DE DADOS ---------------------------

CREATE DATABASE IF NOT EXISTS inatel_exemplo;
USE inatel_exemplo;

# ------------------------------ CRIANDO UMA TABELA ------------------------------

CREATE TABLE IF NOT EXISTS Aluno (
	id INT,
	nome VARCHAR(100),
	idade INT,
	curso VARCHAR(5),
	periodo INT,
	PRIMARY KEY(id)
);

# ------------------------------ INSERÇÃO DE DADOS ------------------------------

INSERT INTO Aluno VALUES (1, "Fabio", 21, "GES", 8), (2, "Davi", NULL, "GES", 8);
INSERT INTO Aluno VALUES (3, "Alexandre", 22, "GEB", NULL);
INSERT INTO Aluno (id, nome, curso) VALUES (4, "Luciano", "GEC");
INSERT INTO Aluno (id, curso, periodo, nome) VALUES (5, "GES", 8, "Leonardo");

# -------------------------------- BUSCA DE DADOS --------------------------------

# Buscando TODOS os registros na tabela
SELECT * FROM Aluno;

# Buscando um determinado número de registros
SELECT * FROM Aluno LIMIT 2;

# Buscando apenas algumas colunas dos registros
SELECT nome, curso, idade FROM Aluno;

# Buscando dados a partir de operações lógicas
SELECT * FROM Aluno WHERE nome != "Fabio";
SELECT * FROM Aluno WHERE idade > 18 and not curso = "GES";

# Buscando colunas de dados com valores distintos
SELECT DISTINCT idade from Aluno;

# Buscando dados utilizando funções + apelido de coluna
SELECT MAX(idade) AS "idade máxima" FROM Aluno;

# ------------------------------ EXEMPLOS DE UPDATE ------------------------------

UPDATE Aluno SET nome = "Bio" WHERE id = 1;
UPDATE Aluno SET nome = "Dwight Schrute", idade = 20 WHERE id = 2;

# ------------------------------ EXEMPLOS DE DELETE ------------------------------

DELETE FROM Aluno WHERE nome = "Alexandre";

# -------------------------------- BUSCA DE DADOS --------------------------------

# Buscando TODOS os registros na tabela (de novo)
SELECT * FROM Aluno;

# -------------------------- DELETANDO O BANCO DE DADOS --------------------------

DROP DATABASE IF EXISTS inatel_exemplo;