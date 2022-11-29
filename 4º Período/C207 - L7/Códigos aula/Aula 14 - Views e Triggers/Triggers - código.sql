USE aula_views_triggers;

CREATE TRIGGER ins_soma BEFORE INSERT
ON conta
FOR EACH ROW SET @soma = @soma + NEW.total;

-- Disparando trigger

SET @soma = 0;
INSERT INTO Conta VALUES (137,14.98),(141,1937.50),(97,-100.00);
SELECT @soma;

DELETE FROM Conta WHERE numero >= 0;

INSERT INTO Conta VALUES (137, 14.98), (141, 1937.50), (97, -100.00);

-- Temos que o valor de @soma é diferente, pois ele acumula o valor (não foi resetado).