create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer(
cID int primary key auto_increment not null,
cName varchar(45),
cAge int
);

create table ordera(
oID int primary key auto_increment not null,
oDate  date,
oTotal int,
cID int,
 FOREIGN KEY (cID)
        REFERENCES customer (cID)
);


create table product(
pID int primary key auto_increment not null,
pName varchar(45),
pPrice int
);

create table orderDetail(
oID int ,
pID int ,
odQTY int,
 FOREIGN KEY (oID)
        REFERENCES ordera (oID),
 FOREIGN KEY (pID)
        REFERENCES product (pID)
);