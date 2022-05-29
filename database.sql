create database farmacia;

use farmacia;

create table clientes(
	id int(11) primary key AUTO_INCREMENT,
	nome varchar(20) NOT NULL,
	datanasc date,
	endereco varchar(30) NOT NULL,
	telefone varchar(20) NOT NULL,
	cpf varchar(25) NOT NULL
);

create table cupons(
	id int(11) primary key AUTO_INCREMENT,
	nome varchar(30) NOT NULL,
	validade date,
	codigo varchar(30) NOT NULL,
	valor varchar(30) NOT NULL
);