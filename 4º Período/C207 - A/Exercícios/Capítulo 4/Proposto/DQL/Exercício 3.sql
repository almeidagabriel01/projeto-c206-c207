SELECT d.Nome_Dependente AS "Nome dependente", e.PNome AS "Nome empregado"
FROM dependente AS d
INNER JOIN empregado AS e
ON d.SSN_Empregado = e.SSN;