USE aula_13;

# Criando
DELIMITER $$
DROP PROCEDURE IF EXISTS teste_sinal;
CREATE PROCEDURE teste_sinal(IN num1 INT, IN num2 INT)
BEGIN
	#criando uma variável do tipo int para armazenar uma soma de inteiros
	DECLARE soma INT;
    
	#criando uma variável que armazenará o valor da resposta do resultado
	DECLARE resposta varchar(15);
    
	# atribuindo um valor para a variável criada
	SET soma = num1 + num2;
    
	#verificando se o valor é positivo
	IF soma > 0
		# atribuindo a string 'positivo' para a variável de "resposta"
		THEN SET resposta = 'positivo';
        
	ELSE
		# atribuindo a string 'negativo' para a variável de "resposta"
		SET resposta = 'negativo';
	END IF;
    
#exibindo o resultado
select concat('O resultado da soma resulta em um numero: ', resposta) as Resposta;
END $$
DELIMITER ;

CALL teste_sinal(-2, -1);
CALL teste_sinal(1, 1);
CALL teste_sinal(1, -2);