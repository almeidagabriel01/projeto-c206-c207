SELECT e.PNome AS "Nome empregado", s.PNome AS "Nome supervisor", s.Salario - e.Salario AS "Diferença de salário do supervisor pelo empregado"
FROM empregado AS e, empregado AS s
WHERE e.SSN_Supervisor = s.SSN;