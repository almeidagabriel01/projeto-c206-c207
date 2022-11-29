DROP DATABASE IF EXISTS exemplo;
CREATE DATABASE exemplo;
USE exemplo;

CREATE TABLE Aluno (
	id INT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    curso VARCHAR(40) NOT NULL,
    matricula INT NOT NULL,
    periodo TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Disciplina(
	id INT AUTO_INCREMENT,
    sigla VARCHAR(5),
    cargaHoraria TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Aluno_Cursa_Disciplina(
	id_Aluno INT,
    id_Disciplina INT,
    PRIMARY KEY(id_Aluno, id_Disciplina),
    CONSTRAINT fk1
		FOREIGN KEY (id_Aluno)
        REFERENCES Aluno (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	CONSTRAINT fk2
		FOREIGN KEY(id_Disciplina)
        REFERENCES Disciplina (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE 
);

INSERT INTO Aluno (nome, curso, matricula, periodo) VALUES ("Gabriel", "Software", 145, 4);
INSERT INTO Disciplina (sigla, cargaHoraria) VALUES ("C207", 50);

SELECT * FROM Aluno;
SELECT * FROM Disciplina;

INSERT INTO Aluno_cursa_Disciplina VALUES (1, 1);
SELECT * FROM Aluno_cursa_Disciplina;