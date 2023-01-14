DROP DATABASE IF EXISTS facility;
CREATE DATABASE facility;
USE facility;
CREATE TABLE facility_type (
    facility_type_id INT PRIMARY KEY AUTO_INCREMENT,
    facility_type_name VARCHAR(45)
);

CREATE TABLE rent_type (
    rent_type_id INT PRIMARY KEY AUTO_INCREMENT,
    rent_type_name VARCHAR(45)
);

CREATE TABLE facility (
    facility_id INT PRIMARY KEY AUTO_INCREMENT,
    facility_name VARCHAR(45) NOT NULL,
    area INT,
    cost DOUBLE NOT NULL,
    max_people INT,
    rent_type_id INT NOT NULL,
    facility_type_id INT NOT NULL,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floor INT,
    facility_free TEXT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (rent_type_id)  on delete cascade,
    FOREIGN KEY (facility_type_id)
        REFERENCES facility_type (facility_type_id) on delete cascade
);
INSERT INTO rent_type (rent_type_name) 
  VALUE ('year'),
   ('month'),
   ('day'),
   ('hour');
    
   INSERT INTO facility_type(facility_type_name)
   VALUE ('Villa'),
    ('House'),
    ('Room');
        
   INSERT INTO facility(facility_name,area,cost,max_people,standard_room,description_other_convenience,pool_area,number_of_floor,facility_free,rent_type_id,facility_type_id)
    VALUE ('Villa Beach Front',25000,1000000,10,'vip','Có hồ bơi',500,4,null,3,1),
     ('House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',null,3,null,2,2),
     ('Room Twin 01',5000,1000000,2,'normal','Có tivi',null,null,'1 Xe máy, 1 Xe đạp',4,3),
     ('Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,null,3,1),
     ('House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',null,2,null,3,2),
     ('Room Twin 02',3000,900000,2,'normal','Có tivi',null,null,'1 Xe máy',4,3);
     