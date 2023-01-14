drop database if exists chuyen_doi_ERD;
create database chuyen_doi_ERD;
USE chuyen_doi_ERD;
CREATE TABLE phieu_xuat (
    so_PX INT AUTO_INCREMENT PRIMARY KEY,
    ngay_xuat DATE
);
CREATE TABLE vat_tu (
    ma_vat_tu INT AUTO_INCREMENT PRIMARY KEY,
    ten_vat_tu VARCHAR(45)
);
CREATE TABLE phieu_nhap (
    so_PN INT AUTO_INCREMENT PRIMARY KEY,
    ngay_nhap DATE
);
CREATE TABLE don_dat_hang (
    so_dat_hang INT AUTO_INCREMENT PRIMARY KEY,
    ngay_dat_hang DATE
);
CREATE TABLE nha_cung_cap (
    ma_nha_cung_cap INT AUTO_INCREMENT PRIMARY KEY,
    ten_nha_cung_cap VARCHAR(45),
    dia_chi_nha_cung_cap VARCHAR(45),
    so_dat_hang INT,
    FOREIGN KEY (so_dat_hang)
        REFERENCES don_dat_hang (so_dat_hang)
);
CREATE TABLE so_dien_thoai (
    ma_nha_cung_cap INT AUTO_INCREMENT PRIMARY KEY,
    so_dien_thoai VARCHAR(10),
    FOREIGN KEY (ma_nha_cung_cap)
        REFERENCES nha_cung_cap (ma_nha_cung_cap)
);
CREATE TABLE chi_tiet_phieu_xuat (
    don_gia_xuat INT,
    so_luong_xuat INT,
    so_PX INT,
    ma_vat_tu INT,
    PRIMARY KEY (so_PX , ma_vat_tu),
    FOREIGN KEY (so_PX)
        REFERENCES phieu_xuat (so_PX),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);
CREATE TABLE chi_tiet_phieu_nhap (
    don_gia_nhap INT,
    so_luong_nhap INT,
    so_PN INT,
    ma_vat_tu INT,
    PRIMARY KEY (so_PN , ma_vat_tu),
    FOREIGN KEY (so_PN)
        REFERENCES phieu_nhap (so_PN),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);
CREATE TABLE chi_tiet_don_dat_hang (
    so_don_hang INT,
    ngay_dat_hang INT,
    ma_vat_tu INT,
    so_dat_hang INT,
    PRIMARY KEY (so_dat_hang , ma_vat_tu),
    FOREIGN KEY (so_dat_hang)
        REFERENCES don_dat_hang (so_dat_hang),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);