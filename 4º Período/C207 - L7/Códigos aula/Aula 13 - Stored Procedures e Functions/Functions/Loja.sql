DROP DATABASE IF EXISTS loja;
CREATE DATABASE loja;
USE loja;

SET GLOBAL log_bin_trust_function_creators = 1;
CREATE TABLE compra(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	preco FLOAT,
	pagamento FLOAT
);
INSERT INTO compra VALUES (id,9.5,10.25);
INSERT INTO compra VALUES (id,18.99,25);
INSERT INTO compra VALUES (id,3.99,5);
INSERT INTO compra VALUES (id,8.85,8.89);
INSERT INTO compra VALUES (id,19.49,20);

DELIMITER $$
	DROP FUNCTION IF EXISTS calcula_troco $$
    CREATE FUNCTION calcula_troco(preco FLOAT, pagamento FLOAT) RETURNS VARCHAR(20) NOT DETERMINISTIC # retorna string e nao int
    BEGIN
		DECLARE troco FLOAT;
        DECLARE resultado VARCHAR(20);
        SET troco = pagamento - preco;
        IF troco < 0 THEN
			SET resultado = "Nem compra";
        ELSEIF troco < 0.05 THEN
			SET resultado  = "Sem troco";
		ELSEIF troco <= 1 THEN
			SET resultado = "Balinhas de café";
		ELSE
			SET resultado = "Em dinheiro";
		END IF;
        RETURN resultado;
        
    END $$
DELIMITER ;

SELECT calcula_troco(preco, pagamento) FROM compra;