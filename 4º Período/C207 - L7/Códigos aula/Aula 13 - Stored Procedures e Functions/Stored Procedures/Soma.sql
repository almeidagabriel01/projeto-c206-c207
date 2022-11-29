CREATE DATABASE IF NOT EXISTS Aula_13;
USE aula_13;

# criando procedimento que soma dois números
DELIMITER $$
DROP PROCEDURE IF EXISTS soma $$
CREATE PROCEDURE soma(IN num1 INT, IN num2 INT)
BEGIN
#calculando a soma e exibindo o resultado
select (num1 + num2) as Soma;
END $$
DELIMITER ;
#chamando o procedimento soma, passando como parâmetros os valores 2 e 3
call soma(2,3);