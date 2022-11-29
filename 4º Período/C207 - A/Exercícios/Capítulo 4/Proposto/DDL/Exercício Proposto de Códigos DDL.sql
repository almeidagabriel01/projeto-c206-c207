CREATE DATABASE IF NOT EXISTS exercicio_proposto;

CREATE TABLE Empregado
(
  PNome VARCHAR(15) NOT NULL,
  MInicial CHAR,
  UNome VARCHAR(15) NOT NULL,
  SSN BIGINT NOT NULL,
  DataNasc DATE,
  Endereco VARCHAR(80),
  Sexo BIT,
  Salario DECIMAL(10,2),
  SSN_Supervisor BIGINT,
  DNumero_Departamento INT NOT NULL,
  PRIMARY KEY (SSN),
  
  CONSTRAINT fk1
	FOREIGN KEY (SSN_Supervisor) REFERENCES Empregado (SSN) 
    ON DELETE SET NULL ON UPDATE CASCADE,
  
  CONSTRAINT fk2
	FOREIGN KEY (DNumero_Departamento) REFERENCES Departamento (DNumero)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Departamento
(
    DNome VARCHAR(15),
    DNumero INT NOT NULL,
    DataInicio DATE,
    SSN_Empregado BIGINT NOT NULL,
    PRIMARY KEY(DNumero),
    
    CONSTRAINT fk
		FOREIGN KEY (SSN_Empregado) REFERENCES Empregado (SSN)
		ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Projeto
(
	PNome VARCHAR(15) NOT NULL,
    PNumero INT AUTO_INCREMENT,
    PLocalizacao VARCHAR(80) NOT NULL,
    DNumero_Departamento INT NOT NULL,
    PRIMARY KEY(PNumero),
    
    CONSTRAINT fk
		FOREIGN KEY (DNumero_Departamento) REFERENCES DEPTO_LOCALIZACOES (LNumero)
		ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE Dependente
(
	Nome_Dependente VARCHAR(50),
    Sexo BIT,
    DataNasc DATE,
    SSN_Empregado BIGINT NOT NULL,
    Parentesco VARCHAR(50),
    
    CONSTRAINT fk
		FOREIGN KEY (SSN_Empregado) REFERENCES Empregado (SSN)
		ON DELETE SET NULL ON UPDATE CASCADE,
        
	PRIMARY KEY(Nome_Dependente, SSN_Empregado)
);

CREATE TABLE DEPTO_LOCALIZACOES
(
	LNumero INT AUTO_INCREMENT,
    DLocalizacao VARCHAR(80) NOT NULL,
    DNumero_Departamento INT NOT NULL,
    PRIMARY KEY(LNumero),
    
    CONSTRAINT fk
		FOREIGN KEY (DNumero_Departamento) REFERENCES Departamento (DNumero)
        ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE TRABALHA_EM
(
	Horas TIME NOT NULL,
    SSN_Empregado BIGINT NOT NULL,
    PNumero_Projeto INT,
    
    CONSTRAINT fk1
		FOREIGN KEY (SSN_Empregado) REFERENCES Empregado (SSN)
        ON DELETE SET NULL ON UPDATE CASCADE,
        
	CONSTRAINT fk2
		FOREIGN KEY (PNumero_Projeto) REFERENCES Projeto (PNumero)
        ON DELETE SET NULL ON UPDATE CASCADE,
        
	PRIMARY KEY(SSN_Empregado, PNumero_Projeto)
);