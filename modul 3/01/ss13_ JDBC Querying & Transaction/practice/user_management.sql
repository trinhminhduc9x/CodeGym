drop database if exists demo;
create database demo;
use demo;

create table users(
id int primary key auto_increment,
name varchar(120) not null,
email varchar(120) not null,
country varchar(120) not null
);

insert into users (name,email,country) 
values ('Minh','minh@codegym.vn','Viet Nam'),
	   ('Kante','kante@che.uk','Kenia');
	
delimiter $$
create procedure get_user_by_id(user_id int)
begin 
	select users.name, users.email, users.country
    from users
    where id = user_id;
    end $$
    delimiter ;
    
    call get_user_by_id(1);
    
    delimiter $$
create procedure insert_user (
     in user_name varchar(50),
     in user_email varchar(50),
     in user_country varchar(50)
     )
     begin
     insert into users(name, email,country) 
     value (user_name,user_email,user_country);
     end $$
     delimiter ;
     
     call insert_user('Bon','thaonhien9991@gmail.com','Viet Nam');
     
     create table permision (
     id int(11) primary key,
     name varchar (50)
     );
     
     create table user_permision(
     permision_id int(11),
     user_id int (11)
     );
     
     insert into permision (id,name)
     value (1,'add'),
     (2,'edit'),
     (3,'delete'),
     (4,'view');
     
 --     insert into user_permision (permision_id,user_id)
--      value(?,?)