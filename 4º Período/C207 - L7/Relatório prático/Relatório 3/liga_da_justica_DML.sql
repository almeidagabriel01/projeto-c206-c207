USE liga_da_justica;

INSERT INTO
    Super_Heroi(nome, acessorio)
VALUES
    ('Super-Homem', 'Óculos'),
    ('Batman', 'Equipamento Wayne Tech'),
    ('Mulher Maravilha', 'Armadura'),
    ('The Flash', 'Relógio');

INSERT INTO
    Super_Vilao(nome, especie)
VALUES
    ('Lex Luthor', 'Humano'),
    ('Coringa', 'Humano'),
    ('Ares', 'Deus'),
    ('Gorila Grodd', 'Gorila'),
    ('Darkseid', 'Novo Deus');

INSERT INTO
    Heroi_Inimigo_de_Vilao(id_Heroi, id_Vilao)
VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (2, 4),
    (3, 3),
    (4, 4),
    (1, 5),
    (2, 5),
    (3, 5),
    (4, 5);

INSERT INTO
    Heroi_Tem_Super_Poder(nome, id_Heroi)
VALUES
    ('Sopro Congelante', 1),
    ('Super Audição', 1),
    ('Super Força', 1),
    ('Super Resistência', 3),
    ('Super Velocidade', 3),
    ('Visão de Calor', 1),
    ('Visão de Raio-X', 1),
    ('Voo', 1),
    ('Dinheiro', 2),
    ('Super Inteligência', 2),
    ('Treinamento Marcial', 2),
    ('Super Força', 3),
    ('Super Resistência', 3),
    ('Treinamento Amazona', 3),
    ('Super Velocidade', 4);