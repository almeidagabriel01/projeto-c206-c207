create database if not exists prova1;
use prova1;

create table estudante(
   matricula int primary key,
   nome varchar(60),
   idade int,
   cidade varchar(70),
   curso varchar(5)
);

