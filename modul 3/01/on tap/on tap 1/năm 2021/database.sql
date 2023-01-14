DROP DATABASE IF EXISTS QuanLyThuePhongTro;
CREATE DATABASE QuanLyThuePhongTro;
USE QuanLyThuePhongTro;
CREATE TABLE HinhThucThanhToan (
	STTHinhThucThanhToan INT AUTO_INCREMENT,
    TenHinhThucThanhToan VARCHAR(45) NOT NULL,
    PRIMARY KEY (STTHinhThucThanhToan)
);

CREATE TABLE PhongTro (
    MaPhongTro INT AUTO_INCREMENT,
    TenNguoiThueTro VARCHAR(45) NOT NULL,
    SoDienThoai VARCHAR(45) NOT NULL,
    GhiChu VARCHAR(45) NOT NULL,
    STTHinhThucThanhToan INT ,
    PRIMARY KEY (MaPhongTro),
     FOREIGN KEY (STTHinhThucThanhToan)
      REFERENCES HinhThucThanhToan (STTHinhThucThanhToan)
);
INSERT INTO `quanlythuephongtro`.`hinhthucthanhtoan` (`STTHinhThucThanhToan`, `TenHinhThucThanhToan`) VALUES 
('1', 'Thueo Thang'),
('2', 'Thueo Quy'),
('3', 'Thueo Nam');

INSERT INTO `quanlythuephongtro`.`phongtro` ( `TenNguoiThueTro`, `SoDienThoai`, `GhiChu`, `STTHinhThucThanhToan`) VALUES 
( 'Nguyen Van B', '123456789', 'Nhân viên văn phòng', '1'),
( 'Nguyen Van C', '123456789', 'Học sinh', '1'),
( 'Nguyen Van D', '123456789', 'Công nhân', '1'),
( 'Nguyen Van E', '123456789', 'Lao động tự do', '1'),
( 'Nguyen Van F', '123456789', 'Mẹ đơn thân', '1'),
( 'Nguyen Van G', '123456789', 'Công an chìm', '1');

UPDATE `quanlythuephongtro`.`phongtro` SET `STTHinhThucThanhToan` = '2' WHERE (`MaPhongTro` = '2');
UPDATE `quanlythuephongtro`.`phongtro` SET `STTHinhThucThanhToan` = '3' WHERE (`MaPhongTro` = '3');
UPDATE `quanlythuephongtro`.`phongtro` SET `STTHinhThucThanhToan` = '2' WHERE (`MaPhongTro` = '5');
UPDATE `quanlythuephongtro`.`phongtro` SET `STTHinhThucThanhToan` = '3' WHERE (`MaPhongTro` = '6');
