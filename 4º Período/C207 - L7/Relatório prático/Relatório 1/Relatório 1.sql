DROP DATABASE IF EXISTS pokedex;
CREATE DATABASE pokedex;
USE pokedex;

CREATE TABLE IF NOT EXISTS Pokemon (
	id INT UNSIGNED,
	nome VARCHAR(15) NOT NULL,
	tipo_1 VARCHAR(10) NOT NULL,
	tipo_2 VARCHAR(10) DEFAULT NULL,
	poder_total INT UNSIGNED NOT NULL,
	cor VARCHAR(10) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO Pokemon (id, nome, tipo_1, tipo_2, poder_total, cor) VALUES
	(0, "MissingNo.", "Pássaro", "Normal", 204, "branco"),
	(1, "Bulbasaur", "Grama", "Veneno", 318, "verde"),
	(2, "Ivysaur", "Grama", "Veneno", 405, "verde"),
	(3, "Venusaur", "Grama", "Veneno", 525, "verde"),
	(4, "Charmander", "Fogo", NULL, 309, "vermelho"),
	(5, "Charmeleon", "Fogo", NULL, 405, "vermelho"),
	(6, "Lizardon", "Fogo", "Voador", 534, "vermelho"),
	(7, "Squirtle", "Água", NULL, 314, "azul"),
	(8, "Wartortle", "Água", NULL, 405, "azul"),
	(9, "Blastoise", "Água", NULL, 530, "azul"),
	(144, "Articuno", "Gelo", "Voador", 580, "azul"),
	(145, "Zapdos", "Elétrico", "Voador", 580, "amarelo"),
	(146, "Moltres", "Fogo", "Voador", 580, "amarelo"),
	(147, "Dratini", "Dragão", NULL, 300, "azul"),
	(148, "Dragonair", "Dragão", NULL, 420, "azul"),
	(149, "Dragonite", "Dragão", "Voador", 600, "amarelo"),
	(150, "Mewtwo", "Psíquico", NULL, 680, "roxo"),
	(151, "Mew", "Psíquico", NULL, 600, "rosa");
    
    # 1
    INSERT INTO Pokemon (id, nome, tipo_1, tipo_2, poder_total, cor) VALUES 
    (25,"Pikachu", "ELétrico", NULL, 320, "amarelo"),
    (448, "Lucario", "Lutador", "Aço", 525, "azul"),
    (658, "Greninja", "Água", "Sombrio", 530, "azul");
    
    # 2
    SELECT nome, cor FROM Pokemon WHERE tipo_1 = "Voador" OR tipo_2 = "Voador";
    
    # 3
    SELECT MAX(poder_total) AS "Maior poder total" FROM Pokemon; 
    
    # 4
    SELECT DISTINCT cor AS "Cores" FROM Pokemon;
    
    # 5
    SELECT * From Pokemon WHERE cor = "Azul" and tipo_1 != "Água";
    
    # 6
    UPDATE Pokemon SET cor = "marrom" WHERE nome = "Dragonite";
    
    # 7
    Update Pokemon SET nome = "Charizard" WHERE nome = "Lizardon";
    
    # 8
    DELETE FROM Pokemon WHERE nome = "MissingNo.";
    
    SELECT * FROM Pokemon;