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
INSERT INTO `quanlyphim`.`phim` (`TenPhim`, `NgayChieuPhim`, `SttTheLoai`, `SttQuocGia`, `SttDoTuoi`) VALUES 
('Phim B', '2022-09-09', '1', '1', '1'),
('Phim C', '2022-09-09', '2', '2', '2'),
('Phim D', '2022-09-09', '3', '3', '3'),
('Phim E', '2022-09-09', '4', '4', '1'),
('Phim F', '2022-09-09', '5', '5', '2'),
('Phim G', '2022-09-09', '6', '6', '3'),
('Phim H', '2022-09-09', '7', '1', '1'),
('Phim I', '2022-09-09', '8', '1', '2'),
('Phim G', '2022-09-09', '9', '1', '3');

