SELECT AVG(e.Salario) AS "Média salarial"
FROM empregado AS e
INNER JOIN departamento AS d
ON e.Endereco LIKE "%São Paulo%" AND e.DNumero_Departamento = d.Dnumero AND d.Dnome = "Engenharia";