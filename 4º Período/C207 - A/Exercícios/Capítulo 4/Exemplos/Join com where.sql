# EXEMPLO DE JUNÇÃO
# BUSCAR O NOME DE CADA EMPREGADO JUNTAMENTE COM O NOME DE SEU RESPECTIVO DEPARTAMENTO
SELECT e.pnome, d.dnome
FROM empregado AS e, departamento AS d
WHERE e.DNumero_Departamento = d.DNumero;  # Where com chave estrangeira de uma tabela igual a chave primária da outra tabela