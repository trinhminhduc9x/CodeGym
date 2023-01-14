DROP DATABASE IF EXISTS Household;
CREATE DATABASE Household;
USE Household;
CREATE TABLE member (
	id_member INT AUTO_INCREMENT,
    CMND INT ,
    name_member VARCHAR(45) NOT NULL,
	DateOfBirth DATE NOT NULL,
    PRIMARY KEY (id_member)
);



CREATE TABLE House_Hold (
    id_House_Hold INT AUTO_INCREMENT,
    id_member INT ,
    name_House_Hold VARCHAR(45) NOT NULL,
    number_House_Hold INt,
    founding DATE NOT NULL,
    Address VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_House_Hold),
     FOREIGN KEY (id_member)
      REFERENCES member (id_member)
);
INSERT INTO `household`.`member` (`id_member`, `CMND`, `name_member`, `DateOfBirth`) VALUES ('1', '123456789', 'Duc Minh', '2000-01-18');
INSERT INTO `household`.`member` (`id_member`, `CMND`, `name_member`, `DateOfBirth`) VALUES ('2', '123456789', 'AS', '2000-01-18');
INSERT INTO `household`.`member` (`id_member`, `CMND`, `name_member`, `DateOfBirth`) VALUES ('3', '123456789', 'AXC', '2000-01-18');
INSERT INTO `household`.`member` (`id_member`, `CMND`, `name_member`, `DateOfBirth`) VALUES ('4', '123456789', 'AS', '2000-01-18');
INSERT INTO `household`.`member` (`id_member`, `CMND`, `name_member`, `DateOfBirth`) VALUES ('5', '123456789', 'as', '2000-01-18');
INSERT INTO `household`.`member` (`id_member`, `CMND`, `name_member`, `DateOfBirth`) VALUES ('6', '123456789', 'asd', '2000-01-18');

INSERT INTO `household`.`house_hold` ( `id_member`, `name_House_Hold`, `number_House_Hold`, `founding`, `Address`) 
VALUES ( '1', 'ASD', '3', '2000-03-06', 'dsaf'),
 ( '2', 'ASD', '3', '2000-03-06', 'dsaf'),
 ( '3', 'ASD', '3', '2000-03-06', 'dsaf'),
 ( '4', 'ASD', '3', '2000-03-06', 'dsaf'),
 ( '5', 'ASD', '3', '2000-03-06', 'dsaf'),
 ( '6', 'ASD', '3', '2000-03-06', 'dsaf'),
 ( '1', 'ASD', '3', '2000-03-06', 'dsaf'),
 ( '3', 'ASD', '3', '2000-03-06', 'dsaf'),
 ( '1', 'ASD', '3', '2000-03-06', 'dsaf'),
 ( '6', 'ASD', '3', '2000-03-06', 'dsaf');
UPDATE `household`.`house_hold` SET `name_House_Hold` = 'ASDs' WHERE (`id_House_Hold` = '1');

