DROP DATABASE IF EXISTS inatel;

CREATE DATABASE IF NOT EXISTS inatel;
USE inatel;

CREATE TABLE Alunos (
	id INT AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	curso VARCHAR(50) NOT NULL,
	periodo SMALLINT UNSIGNED NOT NULL,
	matricula INT UNSIGNED NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO Alunos (nome, curso, periodo, matricula) VALUES
	("Neymar", "Engenharia de Software", 4, 10),
	("Elizabeth II", "Engenharia de Telecomunicações", 10, 96),
	("Bob Esponja", "Engenharia de Software", 7, 13),
	("Son Goku", "Engenharia de Computação", 1, 7);

# busca 1
SELECT avg(periodo) AS "Período Média" FROM Alunos WHERE curso != "Engenharia de Telecomunicações";

# busca 2
SELECT COUNT(*) AS "Alunos de Software" FROM Alunos WHERE curso = "Engenharia de Software";

# busca 3
SELECT DISTINCT curso AS "Cursos" FROM Alunos;

# busca 4
SELECT nome AS "Nome", curso AS "Curso", matricula AS "Matrícula" FROM Alunos WHERE periodo < 6;

# busca 5
SELECT * FROM Alunos WHERE nome LIKE "%n%";

# Alterando o curso de Son Goku
UPDATE Alunos SET curso = "Engenharia de Produção" WHERE nome = "Son Goku";

# Removendo Elizabeth II
DELETE FROM Alunos WHERE nome = "Elizabeth II";

SELECT * FROM Alunos;