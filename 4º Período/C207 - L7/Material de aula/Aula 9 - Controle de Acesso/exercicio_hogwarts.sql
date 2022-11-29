CREATE USER IF NOT EXISTS 
	hermione@localhost,
	ministro@localhost,
    hagrid@localhost,
    mcgonagall@localhost, snape@localhost,
    doloresumbridge@localhost,
    harrypotter@localhost;

# Garanta acesso de um usuário de nome hermione apenas para uso em qualquer banco de dados do servidor.
GRANT USAGE ON *.* TO hermione@localhost;
SHOW GRANTS FOR hermione@localhost;

# Retire o privilégio do usuário ministro de criar tabelas no banco de dados hogwarts.
GRANT ALL ON hogwarts.* TO ministro@localhost;
REVOKE CREATE ON hogwarts.* FROM ministro@localhost;
SHOW GRANTS FOR ministro@localhost;

# Permita ao usuário hagrid adicionar e alterar os dados da tabela de animais, além de dar privilégios a outros usuários.
GRANT INSERT, UPDATE, GRANT OPTION ON hogwarts.animal TO hagrid@localhost;
SHOW GRANTS FOR hagrid@localhost;

# Dê aos usuários mcgonagall e snape o poder de alterar o nome e sobrenome dos bruxos e buscar qualquer informação.
GRANT UPDATE (nome, sobrenome), SELECT ON hogwarts.bruxo TO mcgonagall@localhost, snape@localhost;
SHOW GRANTS FOR mcgonagall@localhost;
SHOW GRANTS FOR snape@localhost;

# Retire todos os privilégios do usuário doloresumbridge, incluso o poder de dar privilégios a outros usuários.
GRANT ALL ON *.* TO doloresumbridge@localhost;
REVOKE ALL, GRANT OPTION FROM doloresumbridge@localhost;
SHOW GRANTS FOR doloresumbridge@localhost;

# Retire o privilégio do usuário harrypotter de adicionar e de excluir participantes do time de quadribol.
# Mostre os privilégios do usuário harrypotter.
GRANT ALL on hogwarts.`time` TO harrypotter@localhost;
REVOKE INSERT, DELETE ON hogwarts.`time` FROM harrypotter@localhost;
SHOW GRANTS FOR harrypotter@localhost;