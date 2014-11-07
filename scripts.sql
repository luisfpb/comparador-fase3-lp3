create database Buscador;


create table Loja (idLoja INT NOT NULL AUTO_INCREMENT, nome VARCHAR(100), endPoint VARCHAR(100), PRIMARY KEY (idLoja));

create table Produto (idProduto INT NOT NULL AUTO_INCREMENT, nome VARCHAR(100), idLoja Int, idSku Int descricao VARCHAR(300), valor Double, PRIMARY KEY (idProduto), FOREIGN KEY (idLoja) REFERENCES Loja(idLoja));

create table Loja (idUsuario INT NOT NULL AUTO_INCREMENT, nome VARCHAR(100), login VARCHAR(100), senha VARCHAR(100), PRIMARY KEY (idUsuario));
