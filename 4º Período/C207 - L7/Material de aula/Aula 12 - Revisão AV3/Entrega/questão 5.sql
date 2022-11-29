# letra A
SELECT DISTINCT(departamento) FROM elfo;

# letra B
select p.nome
FROM presente AS p INNER JOIN crianca AS c
ON c.id = p.id_Crianca AND c.acredita = true;

# letra C
SELECT AVG(p.peso_kg) AS "peso dos presentes"
FROM presente AS p INNER JOIN crianca AS c
ON c.id = p.id_Crianca AND c.pais = "Espanha";

# letra D
SELECT c.nome
FROM crianca AS c INNER JOIN presente AS p
ON p.id_Crianca = c.id AND p.nome = "Bicicleta";