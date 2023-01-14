DROP DATABASE IF EXISTS SalesManager;
create database SalesManager;
use SalesManager;

CREATE TABLE customer (
    cID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    cName VARCHAR(45),
    cAge INT
);

CREATE TABLE ordera (
    oID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    oDate DATE,
    oTotal INT,
    cID INT,
    FOREIGN KEY (cID)
        REFERENCES customer (cID)
);


CREATE TABLE product (
    pID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    pName VARCHAR(45),
    pPrice INT
);

CREATE TABLE orderDetail (
    oID INT,
    pID INT,
    odQTY INT,
    FOREIGN KEY (oID)
        REFERENCES ordera (oID),
    FOREIGN KEY (pID)
        REFERENCES product (pID)
);