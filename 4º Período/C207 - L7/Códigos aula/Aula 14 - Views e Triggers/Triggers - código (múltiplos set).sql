USE aula_views_triggers;

DELIMITER //
CREATE TRIGGER upd_check BEFORE UPDATE ON conta
FOR EACH ROW
BEGIN
	IF NEW.total < 0 THEN
		SET NEW.total = 0;
	ELSEIF NEW.total > 100 THEN
		SET NEW.total = 100;
	END IF;
END;
// DELIMITER ;

UPDATE conta SET total = 200 WHERE numero = 137;