USE aula_13;

# função que multiplica dois números
DELIMITER $$
	DROP FUNCTION IF EXISTS mult $$
	CREATE FUNCTION mult(a FLOAT, b FLOAT) RETURNS FLOAT DETERMINISTIC  # deterministic pois as entradas sao float e o retorno também é float
	BEGIN
		return a*b;
	END $$
DELIMITER ;

select mult (2.5,4);