# Criando
DELIMITER $$
CREATE PROCEDURE cadProd(IN nome_produto VARCHAR(45))
BEGIN
INSERT INTO produto(nome) VALUES (nome_produto);
END $$
DELIMITER ;
# Chamando
CALL cadProd('Mouse');
# Deletando
DROP PROCEDURE cadProd;