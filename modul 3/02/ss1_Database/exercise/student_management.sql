DROP DATABASE IF EXISTS student_management;
CREATE DATABASE  student_management;
USE student_management;
CREATE TABLE teacher (
    id INT AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    contry VARCHAR(50),
    PRIMARY KEY (id)
);
CREATE TABLE student (
    id INT AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY (id)
);
-- them vao
insert into student(name) value ( "minh duc"),("minh duc dep trai"),( "minh duc goodboy");
-- xem bang
SELECT 
    *
FROM
    student;
-- them cot
alter table student add age int;
-- them gia tri vao cot ko can key 
set sql_safe_updates = 0;
UPDATE student 
SET 
    student.age = 5
WHERE
    name = 'minh duc';
set sql_safe_updates = 1;
-- xoa gia tri ko can key 
SELECT 
    *
FROM
    student;
set sql_safe_updates = 0;
DELETE FROM student 
WHERE
    name = 'minh duc dep trai';
set sql_safe_updates = 1;
-- them gia tri vao cot can key 
UPDATE student 
SET 
    student.age = 3
WHERE
    id = 4;

SELECT 
    *
FROM
    student;
