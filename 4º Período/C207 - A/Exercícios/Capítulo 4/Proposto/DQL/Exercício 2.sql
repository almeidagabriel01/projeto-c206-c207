SELECT UNome AS "Último nome", DataNasc AS "Data de nascimento"
FROM empregado
WHERE Sexo = 1
ORDER BY DataNasc ASC;