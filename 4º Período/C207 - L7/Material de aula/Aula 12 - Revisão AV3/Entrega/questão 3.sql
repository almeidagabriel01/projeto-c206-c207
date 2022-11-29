USE polo_norte;

INSERT INTO
    Crianca (nome, idade, pais, continente, acredita, bonzinho, sobrenome)
VALUES
    ('Roberto', 5, 'Colômbia', 'América', TRUE, TRUE, 'Carlos'),
    ('Elvis', 4, 'Itália', 'Europa', TRUE, TRUE, 'Presley'),
    ('Michael', 8, 'Brasil', 'América', TRUE, TRUE, 'Jackson'),
    ('Pablo', 10, 'Espanha', 'Europa', TRUE, FALSE, 'Escobar'),
    ('Felipe', 7, 'Itália', 'Europa', FALSE, TRUE, 'Neto');

INSERT INTO
    Elfo (nome, departamento, funcao)
VALUES
    ('Fulano', 'Empacotamento', 'Embrulhar'),
    ('Beltrano', 'Empacotamento', 'Fazer laços'),
    ('Sicrano', 'Administração', 'Organizar entregas'),
    ('Deltrano', 'Produção', 'Montar');

INSERT INTO
    Presente (nome, peso_kg, id_Crianca)
VALUES
    ('PlayStation 5', 3.9, 1),
    ('Bicicleta', 15.5, 2),
    ('Bicicleta', 20.66667, 3),
    ('AK-47', 3.8, 4),
    ('Pônei', 100.0, 5);