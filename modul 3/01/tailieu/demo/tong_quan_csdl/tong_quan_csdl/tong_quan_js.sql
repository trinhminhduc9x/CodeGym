CREATE DATABASE if not exists c0622g1;
USE c0622g1;
create table student(
id int primary key auto_increment,
`name` varchar(45),
age int,
class_id int
);
-- hiện thị toàn bộ dữ liệu bảng student
select id,name
from student  where age =23;
-- nhập dữ liêu cho bảng
insert into student
 values(3,"hoàng",23,1),
	   (4,"tiến",25,1);
insert into student(name,age,class_id)
            values("chanh",37,1);
-- edit record
select * from student;
SET SQL_SAFE_UPDATES = 0;
update student set class_id=1 where name ='chanh';
-- thêm cột cho bảng
alter table student add column address varchar(50) after name;
-- xoá cột
alter table student drop column address;
-- xoá dữ liêu theo id;
delete from student where id =2 or id =3;
-- xoá bảng 
drop table student;
-- xoá database
drop database c0622g1;

