-- JOIN com autorelacionamento entre a tabela
SELECT e.Pnome AS 'Empregado', s.Pnome AS 'Supervisor'
FROM empregado AS e, empregado AS s    # separou a tabela em dois pois o JOIN só é feito com duas tabelas
WHERE e.SSN_Supervisor = s.SSN;