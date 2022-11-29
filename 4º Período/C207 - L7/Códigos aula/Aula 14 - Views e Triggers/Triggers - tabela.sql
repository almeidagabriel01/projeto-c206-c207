DROP DATABASE IF EXISTS aula_views_triggers;
CREATE DATABASE IF NOT EXISTS aula_views_triggers;
USE aula_views_triggers;

CREATE TABLE IF NOT EXISTS Conta (
	numero INT,
	total FLOAT,
    PRIMARY KEY(numero)
);

CREATE TABLE IF NOT EXISTS Country(
	id INT PRIMARY KEY,
    Name VARCHAR(100)
);