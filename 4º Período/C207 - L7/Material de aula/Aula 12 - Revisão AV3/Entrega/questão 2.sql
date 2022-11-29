# letra A
ALTER TABLE crianca ADD sobrenome VARCHAR(50);

# letra B
ALTER TABLE presente CHANGE peso peso_kg FLOAT NOT NULL;

# letra C
ALTER TABLE presente DROP material;

# letra D
ALTER TABLE crianca CHANGE acredita_em_Papai_Noel acredita BOOLEAN NOT NULL;

# letra E
ALTER TABLE crianca CHANGE `é bonzinho` bonzinho BOOLEAN NOT NULL;