DROP DATABASE IF EXISTS empresa;

CREATE DATABASE IF NOT EXISTS empresa;
USE empresa;

CREATE TABLE Funcionarios (
	id INT,
	nome VARCHAR(100) NOT NULL,
	idade TINYINT UNSIGNED NOT NULL,
	cpf NUMERIC(11) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO Funcionarios VALUES (1, "Fulano", 18, 11122233300);
INSERT INTO Funcionarios (id, nome, idade, cpf) VALUES (2, "Ciclana", 20, 44455566601);
INSERT INTO Funcionarios (id, nome, idade, cpf) VALUES (3, "Beltrano", 22, 77788899903);
    
SELECT * FROM Funcionarios;