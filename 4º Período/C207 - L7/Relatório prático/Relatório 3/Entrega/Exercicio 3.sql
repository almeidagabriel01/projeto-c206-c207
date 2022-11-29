# letra A
SELECT sh.nome AS `Nome super heroi`, sp.nome AS `Nome super poder`
FROM super_heroi AS sh INNER JOIN heroi_tem_super_poder AS sp
ON sh.id = sp.id_Heroi;

# letra B
SELECT sh.nome
FROM super_heroi AS sh 
INNER JOIN heroi_inimigo_de_vilao AS hi
	ON sh.id = hi.id_Heroi
INNER JOIN super_vilao as sv
	ON hi.id_Vilao = sv.id AND sv.nome = "Darkseid";

# letra C
SELECT sh.nome AS `Nome Heroi`, sp.nome AS `Nome Poder`
FROM super_heroi AS sh
INNER JOIN heroi_tem_super_poder AS sp
	ON sh.id = sp.id_Heroi
INNER JOIN heroi_inimigo_de_vilao AS hi
	ON sh.id = hi.id_Heroi
INNER JOIN super_vilao AS sv
	ON sv.id = hi.id_Vilao AND sv.nome = "Lex Luthor";
    
# letra D
SELECT sh.nome
FROM super_heroi AS sh
INNER JOIN heroi_tem_super_poder AS hi
	ON sh.id = hi.id_Heroi AND hi.nome = "Super Força";