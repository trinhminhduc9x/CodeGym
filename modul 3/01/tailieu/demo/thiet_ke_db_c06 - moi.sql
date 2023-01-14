create database if not exists c0622g1;
use c0622g1;
create table class(
id int primary key auto_increment,
name varchar(20)
);
create table room(
id int primary key auto_increment,
name varchar(20),
class_id int,
foreign key(class_id) references class(id)
);
create table jame(
`account` varchar(50) primary key,
`password` varchar(50)
);
create table student(
id int primary key auto_increment,
name varchar(50),
birthday date,
gender boolean,
email varchar(50),
`point` float,
class_id int,
`account` varchar(50) unique,
foreign key (class_id) references class(id),
foreign key (`account`) references jame(`account`)
);

create table instructor(
id int primary key auto_increment,
name varchar(50),
birthday date,
salary double
);

create table instructor_class(
 class_id int,
 instructor_id int,
 start_time date,
 end_time date,
 primary key (class_id, instructor_id),
 foreign key(class_id) references class(id),
 foreign key(instructor_id) references instructor(id)
);

insert into class (name) values ('c1121g1'), ('c1221g1'),('a0821i1'),('a0921i1');
insert into room(name,class_id) values ('Ken',1), ('Jame',1),('Ada',2),('Andy',2);

insert into jame(`account`,`password`)
 values('cunn','12345'),('chunglh','12345'),('hoanhh','12345'),('dungd','12345'),('huynhtd','12345'),
 ('hainm','12345'),('namtv','12345'),('hieuvm','12345'),('kynx','12345'),('vulm','12345');

insert into jame(`account`,`password`)
 values('anv','12345'),('bnv','12345');

 
insert into instructor(`name`,birthday, salary)
 values('tran van chanh','1985-02-03',100),('tran minh chien','1985-02-03',200),('vu thanh tien','1985-02-03',300);
insert into instructor(`name`,birthday, salary)
 values('tran van nam','1989-12-12',100);

 
 insert into student(`name`,birthday, gender,`point`, class_id,`account`) 
 values ('nguyen ngoc cu','1981-12-12',1,8,1,'cunn'),('le hai chung','1981-12-12',1,5,1,'chunglh'),
 ('hoang huu hoan','1990-12-12',1,6,2,'hoanhh'),('dau dung','1987-12-12',1,8,1,'dungd'),
 ('ta dinh huynh','1981-12-12',1,7,2,'huynhtd'),('nguyen minh hai','1987-12-12',1,9,1,'hainm'),
 ('tran van nam','1989-12-12',1,4,2,'namtv'),('vo minh hieu','1981-12-12',1,3,1,'hieuvm'),
 ('le xuan ky','1981-12-12',1,7,2,'kynx'),('le minh vu','1981-12-12',1,7,1,'vulm');

 insert into student(`name`,birthday, gender,`point`, class_id,`account`) 
 values ('nguyen van a','1981-12-12',1,8,null,'anv'),('tran van b','1981-12-12',1,5,null,'bnv');

 insert into instructor_class(class_id,instructor_id) values (1,1),(1,2),(2,1),(2,2),(3,1),(3,2);

select * from room;
select* from class;
select* from student;
select* from jame;
select* from instructor;
select * from instructor_class;

select c.name,group_concat(r.name separator "&") as room from class c join room r on c.id=r.class_id group by c.name;
select id,name, ifnull(email,"khong có email") from student;

-- ss3 thao tác với csdl

-- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào.
select s.id, s.name, s.point, c.name as class_name from student s
join class c on s.class_id=c.id;

-- 2. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào 
-- và cả các bạn đã đăng ký nhưng chưa có lớp học.
select s.id, s.name, s.point, ifnull(c.name,'chưa có lớp') as class_name from student s
left join class c on s.class_id=c.id;

-- join 3 bảng lấy thêm thông tin tên loại lớp

select * from room;
select s.id, s.name, s.birthday, c.name as class_name
from student s
left join class c on s.class_id = c.id
left join room r on r.class_id=c.id;

-- 3. Lấy thông tin của các học viên tên 'nguyen minh hai'.
select * 
from student where name ='nguyen minh hai';
-- 4. Lấy ra học viên có họ là “nguyen”
select * 
from student where name like 'nguyen%';

-- 5. Lấy thông tin của các học viên tên 'hai' hoặc 'huynh’.
select * 
from student where name like '% hai' or name like '% huynh';

-- lấy các học viên có tên bắt đầu bằng chữ h => regexp
select * from student where name  regexp '(^[a-zA-Z\\s]+\\sh[a-z]+$)';

-- 6. Lấy ra các học viên có điểm lớn hơn 5 .
select * from student where point >5;
-- 7. lấy ra thông tin các học viên có điểm 4,6,8
select * from student where point in(4,6,8);

-- 8. Thông kế số lượng học sinh theo từng loại điểm.
select point, count(point) as so_luong from student s 
group by point;


-- 9 . Thông kế số lượng học sinh theo điểm và điểm phải lớn hơn = 5
select point, count(point) as so_luong from student s 
group by point
having point>=5;
select point, count(point) as so_luong from student s 
where point>=5
group by point;

-- 10. Thông kế số lượng học sinh theo điểm lớn hơn 5 và chỉ hiện thị với số lượng>=2
select point, count(point) as so_luong from student s 
where point>=5
group by point
having so_luong>2;
select * from student
where point>=5;

-- 11. Lấy ra danh sách học viên của lớp c1121g1 và sắp xếp  học viên theo point,
-- nếu point bằng nhau thì sắp xếp theo tên.
select * from student s
join class c on s.class_id=c.id where c.name='c1121g1'
order by s.point desc, s.name desc;

-- test
select ifnull(class_id,"noclas"), count(ifnull(class_id,0)) as so_luong from student s 
group by class_id;


-- bài 4: sử dụng các hàm thông dụng
select * from student;
-- đếm số học viên toàn trung tâm
select count(point) as so_luong from student; 
-- 1.1	Hiện thị danh sách các lớp có học viên theo học và số lượng học viên của mỗi lớp
select c.name as class_name, count(s.id) as so_luong from student s right join class c on s.class_id=c.id
group by c.id;

-- 1.2.	 Tính điểm lớn nhất của mỗi các lớp
select c.name as class_name, max(s.point) as max_point from student s right join class c on s.class_id=c.id
group by c.id;

-- 1.3	 Tình điểm trung bình  của từng lớp
select c.name as class_name, ifnull(avg(s.point),0) as max_point from student s right join class c on s.class_id=c.id
group by c.id;

 -- 2 Lấy ra toàn bộ tên và ngày sinh các instructor và student ở CodeGym.
 select s.name as ten, s.birthday as ngay_sinh from student s;
 select i.name, i.birthday from instructor i;
 
 select s.name as ten, s.birthday as ngay_sinh from student s
 union
 select i.name, i.birthday from instructor i;

  -- 4 Lấy ra top 3 học viên có điểm cao nhất của trung tâm.
  select * from student order by point desc limit 3;


 -- 5. Lấy ra các học viên có điểm số là cao nhất của trung tâm.
 select * from student where point =(select max(point)from student);
 select max(point)from student;
 -- dùng subquery

-- 6 tìm  những gv chưa từng tham gia giảng dạy;
-- dùng join
select i.name, ic.instructor_id from instructor_class ic
right join instructor i on ic.instructor_id=i.id
where ic.instructor_id is null;

-- dùng truy vấn con với in
select * from instructor i where i.id not in (select distinct instructor_id from instructor_class);

-- dùng truy vấn con với exist 
select *
from instructor i
where not exists (select * from instructor_class ic where ic.instructor_id=i.id);


-- ss5: index, view, sp, function, trigger
-- 1. index
select * from customers;
explain select * from customers where city like 'lyon';
 select count(*) from customers where city= 'lyon';
explain select * from customers;
create index i_city on customers(city);

drop index i_city on customers;

 -- 2.view (tạo view lấy thông tin của học viên)
 create view w_student as 
select s.id, s.name, s.point, c.name as class_name from student s
join class c on s.class_id=c.id;
 -- sử dụng view
select * from w_student;

-- 3.1  tạo một sp không tham số  để lấy danh sách student
delimiter //
create procedure sp_get_all_student()
begin
select * from student;
end //
delimiter ;
-- goi sp
call sp_get_all_student();
-- 3.2 sp có tham số in để lấy ra học viên có tham số id
delimiter //
create procedure sp_get_student_by_id(in p_id int)
begin
select * from student where id =p_id;
end //
delimiter ;

call sp_get_student_by_id(1);

-- 3.3 sp đếm số lượng học viên của trung tâm sử dụng OUT param
delimiter //
create procedure count_student(out p_count int)
begin
select count(*) into p_count from student;
end //
delimiter ;

-- gọi sp
call count_student(@sl);
select @sl;

select * from student;

-- 4 viêt 1 function xếp loại học lưc theo point
delimiter //
create function f_xep_loai(diem int)
returns varchar(50)
deterministic
begin
declare loai varchar(50);
if diem>=8 then
set loai ='giỏi';
elseif diem>=7 then
set loai='khá';
else
set loai='trung bình';
end if;
return loai;
end //
delimiter ;
-- sử dụng function
select f_xep_loai(9);

   select *, f_xep_loai(point) as xep_loai from student ;
-- 5 tạo trigger tự động tạo tài khoản jame trước khi thêm mới một học viên
 select * from student;
 select * from jame;

insert into student(`name`,birthday, email, gender,`point`, class_id,`account`) 
 values ('Bùi minh tiến','1990-12-12','tienb@gmail.com',1,8,1,'tienb@gmail.com')

DELIMITER //
CREATE TRIGGER tr_auto_create_jame 
BEFORE INSERT ON student
FOR EACH ROW
BEGIN
insert into jame(`account`, `password`) values ( new.email, '123');
END //
DELIMITER ;


-- tạo trigger để ghi lại lich sử thây đổi thông tin bảng student
DELIMITER //
CREATE TRIGGER tr_history 
AFTER UPDATE ON student
FOR EACH ROW
BEGIN
insert into `history`(`name`, old_point, new_point, update_day) 
values ( old.`name`, old.`point`,new.`point`,now());
END //
DELIMITER ;

select * from history;
select * from student;

-- tạo bảng để ghi log
create table `history`(
id int auto_increment primary key,
name varchar(50),
old_point int,
new_point int,
update_day date
);

























