SELECT e.pnome, d.dnome
FROM empregado AS e INNER JOIN departamento AS d
ON e.DNumero_Departamento = d.DNumero; # Chave estrangeira de uma tabela igual a chave primária da outra tabela