create database dbstore;
use dbstore;

create table product(
idproduct int auto_increment primary key,
nameproduct varchar(100),
priceproduct decimal(5,2),
stock int
);

create table cliente(
idclient int auto_increment not null primary key,
firstname varchar(100),
lastname varchar(100),
twolastname varchar(100)
);

create table detail(
iddetail int auto_increment not null primary key,
fkbill int,
foreign key(fkbill) references bill(idbill),
fkproduct int,
foreign key(fkproduct) references product(idproduct),
cantidad int,
salesprice decimal(5,2)
);


create table bill(
idbill int auto_increment not null primary key,
datebill date,
fkclient int,
foreign key(fkclient) references cliente(idclient)
);