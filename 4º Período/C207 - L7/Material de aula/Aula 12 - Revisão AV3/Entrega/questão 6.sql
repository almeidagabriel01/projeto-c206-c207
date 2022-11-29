# letra A
REVOKE DELETE
ON crianca
FROM PapaiNoel@localhost;

# letra B
GRANT INSERT, UPDATE
ON crianca
TO Pai@localhost;

# letra C
GRANT SELECT(nome, sobrenome, pais, acredita)
ON crianca
TO Krampus@localhost;