USE aula_views_triggers;

delimiter //
CREATE TRIGGER trg_country_up AFTER UPDATE ON Country
FOR EACH ROW
BEGIN
	SET @var_old = OLD.Name;
	SET @var_new = NEW.Name;
END;//
delimiter ;