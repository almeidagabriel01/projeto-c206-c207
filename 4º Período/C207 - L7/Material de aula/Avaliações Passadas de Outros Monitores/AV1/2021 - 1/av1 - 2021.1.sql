drop database if exists av1;
create database av1;
use av1;

create table if not exists funcionario(
  cpf varchar(15) not null primary key,
  nome varchar(45),
  cargo varchar(100),
  idade int,
  salario int
  );
  

