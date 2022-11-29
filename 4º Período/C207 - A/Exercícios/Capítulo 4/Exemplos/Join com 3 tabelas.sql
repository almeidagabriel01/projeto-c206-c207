-- SELECT com 3 tabelas
SELECT e.Pnome AS 'Empregado', p.Pnome AS 'Projeto'
FROM empregado AS e, projeto AS p, trabalha_em AS te
WHERE te.SSN_Empregado = e.SSN AND te.PNumero_Projeto = p.PNumero;  # note que te sempre vai intermediar o relacionamento entre as outras tabelas