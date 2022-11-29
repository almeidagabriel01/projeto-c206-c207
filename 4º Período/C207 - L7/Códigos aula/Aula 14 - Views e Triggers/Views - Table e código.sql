USE aula_views_triggers;

CREATE TABLE IF NOT EXISTS itens_solicitacao(
	id_solicitacao INT(11) PRIMARY KEY AUTO_INCREMENT,
    cod_item INT(11) NOT NULL,
    nome VARCHAR(20),
    qtd INT(11)
);

CREATE TABLE IF NOT EXISTS estoque(
	cod_item INT(11) PRIMARY KEY,
    qtd_disponivel INT(11)
);

# Criando a view
CREATE VIEW qtd_estoque AS (
	SELECT
		i.nome 'Item',e.qtd_disponivel 'Quantidade no estoque'
	FROM
		estoque e, itens_solicitacao i
	WHERE
		e.cod_item = i.cod_item
);

# Testando a view
SELECT * FROM qtd_estoque;