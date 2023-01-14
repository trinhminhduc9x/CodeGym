DROP DATABASE IF EXISTS QuanLyPhim;
CREATE DATABASE QuanLyPhim;
USE QuanLyPhim;
CREATE TABLE TheLoai (
	SttTheLoai INT AUTO_INCREMENT,
    TenTheLoai VARCHAR(45) NOT NULL,
    PRIMARY KEY (SttTheLoai)
);
CREATE TABLE QuocGia (
	SttQuocGia INT AUTO_INCREMENT,
    TenQuocGia VARCHAR(45) NOT NULL,
    PRIMARY KEY (SttQuocGia)
);CREATE TABLE DoTuoi (
	SttDoTuoi INT AUTO_INCREMENT,
    TenDoTuoi VARCHAR(45) NOT NULL,
    PRIMARY KEY (SttDoTuoi)
);
CREATE TABLE Phim (
    SttPhim INT AUTO_INCREMENT,
    TenPhim VARCHAR(45) NOT NULL,
    NgayChieuPhim DATE NOT NULL,
   	SttTheLoai INT ,
    SttQuocGia INT ,
    SttDoTuoi INT ,
    PRIMARY KEY (SttPhim),
     FOREIGN KEY (SttTheLoai)
      REFERENCES TheLoai (SttTheLoai),
      FOREIGN KEY (SttQuocGia)
      REFERENCES QuocGia (SttQuocGia),
      FOREIGN KEY (SttDoTuoi)
      REFERENCES DoTuoi (SttDoTuoi)
);
INSERT INTO `quanlyphim`.`theloai` (`TenTheLoai`) VALUES 
( 'hành động'),
( 'tình cảm'),
( 'hài hước'),
( 'cổ trang'),
( 'võ thuật'),
( 'hoạt hình'),
( 'tâm lý'),
( 'hình sự'),
( 'viễn tưởng');
INSERT INTO `quanlyphim`.`quocgia` (`TenQuocGia`) VALUES 
('Trung Quốc'),
('Mỹ'),
('Hàn Quốc'),
('Nhật Bản,'),
('Việt Nam'),
('Ấn Độ');
INSERT INTO `quanlyphim`.`dotuoi` (`TenDoTuoi`) VALUES 
('Trên 18 tuổi'),
('Dưới 18 tuổi'),
('Tuổi nào cũng được ');

