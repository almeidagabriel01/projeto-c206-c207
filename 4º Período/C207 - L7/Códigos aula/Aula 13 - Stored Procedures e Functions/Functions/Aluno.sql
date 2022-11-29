DROP DATABASE IF EXISTS escolinha;
CREATE DATABASE IF NOT EXISTS escolinha;
USE escolinha;

SET GLOBAL log_bin_trust_function_creators = 1;
CREATE TABLE IF NOT EXISTS Aluno(
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(60),
    nota1 INT,
    nota2 INT,
    faltas INT,
    PRIMARY KEY(id)
);

INSERT INTO Aluno(nome, nota1, nota2, faltas) VALUES 
	("Ana", 70, 70, 2),
	("Pedro", 50, 40, 15),
    ("Carlos", 60, 75, 10),
    ("Joana", 25, 20, 0),
    ("Maria", 100, 98, 2),
    ("Luis", 30, 30, 4),
    ("Patricia", 50, 20, 0),
    ("Joao", 58, 59, 8),
    ("Marcio", 100, 20, 2),
    ("Reinaldo", 40, 40, 10);
    
DELIMITER $$
	DROP FUNCTION IF EXISTS avalia_aluno $$
    CREATE FUNCTION avalia_aluno(pnota1 INT, pnota2 INT, pfaltas INT) RETURNS VARCHAR(20) NOT DETERMINISTIC # retorna string e nao int
    BEGIN
		DECLARE media INT;
        DECLARE resultado VARCHAR(20);
        SET media = (pnota1 + pnota2) / 2;
        IF media >= 60 AND pfaltas <= 10 THEN
			SET resultado  = "Aprovado";
		ELSEIF (media < 30 OR pfaltas > 10) THEN
			SET resultado = "Reprovado";
		ELSEIF ((media >= 30 AND media < 60) AND pfaltas <= 10) THEN
			SET resultado = "NP3";
		END IF;
        RETURN resultado;
        
    END $$
DELIMITER ;

SELECT nome AS "Nome aluno", avalia_aluno(nota1, nota2, faltas) AS "Resultado final" FROM Aluno ORDER BY nome;