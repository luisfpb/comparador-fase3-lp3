create database Buscador;


create table Loja (idLoja INT NOT NULL AUTO_INCREMENT, nome VARCHAR(100), endPoint VARCHAR(100), PRIMARY KEY (idLoja));

create table Sku (idSku INT NOT NULL AUTO_INCREMENT, nome VARCHAR(100), idLoja Int, idProduto Int, descricao VARCHAR(300), valor FLOAT(6,2), PRIMARY KEY (idProduto), FOREIGN KEY (idLoja) REFERENCES Loja(idLoja));

create table Loja (idUsuario INT NOT NULL AUTO_INCREMENT, nome VARCHAR(100), login VARCHAR(100), senha VARCHAR(100), PRIMARY KEY (idUsuario));



insert into Loja(nome, endPoint) values('Walmar Store', 'http://localhost:8081/rest/services/');
insert into Loja(nome, endPoint) values('Amaricanas Store', 'http://localhost:8082/rest/services/');


insert into Usuario(nome, login, senha) values('Luis','luis','1234');


	ALTER TABLE `produto` SET COLUMN `valor` FLOAT(10,2) NOT NULL DEFAULT '0.00'
