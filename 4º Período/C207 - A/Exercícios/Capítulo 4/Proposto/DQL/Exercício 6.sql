SELECT e.PNome AS "Nome empregado", p.PNome AS "Nome projeto", t.Horas AS "Horas"
FROM trabalha_em AS t
INNER JOIN empregado AS e
	ON t.SSN_Empregado = e.SSN
INNER JOIN projeto AS p
	ON p.PNumero = t.PNumero_Projeto;