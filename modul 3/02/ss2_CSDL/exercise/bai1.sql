
create database if not exists mo_hinh_quan_he;
use mo_hinh_quan_he;


CREATE TABLE phieu_xuat (
    soXP INT PRIMARY KEY AUTO_INCREMENT,
    ngayXuat DATE
);

CREATE TABLE phieu_nhap (
    soPN INT PRIMARY KEY AUTO_INCREMENT,
    ngayNhap DATE
);

CREATE TABLE vat_tu (
    maVatTu INT PRIMARY KEY AUTO_INCREMENT,
    tenVatTu VARCHAR(45)
);


CREATE TABLE don_dh (
    soDh INT PRIMARY KEY AUTO_INCREMENT,
    ngayDh DATE
);

ALTER TABLE don_dh ADD  maNCC INT;
ALTER TABLE don_dh ADD  FOREIGN KEY (maNCC) REFERENCES nha_cung_cap (maNCC);

-- ALTER TABLE Users ADD FOREIGN KEY(groupid) REFERENCES Groups(groupid);


CREATE TABLE nha_cung_cap (
    maNCC INT PRIMARY KEY AUTO_INCREMENT,
    tenNCC VARCHAR(45),
    diaChi VARCHAR(45)
);

CREATE TABLE so_dien_thoai (
    masdt INT,
    nhapSo VARCHAR(45) PRIMARY KEY,
    FOREIGN KEY (masdt)
        REFERENCES nha_cung_cap (maNCC)
);

CREATE TABLE chi_tiet_phieu_xuat (
    dGXuat INT NOT NULL,
    soLuongXuat INT NOT NULL,
    soXP INT,
    maVatTu INT,
    PRIMARY KEY (soXP , maVatTu),
    FOREIGN KEY (soXP)
        REFERENCES phieu_xuat (soXP),
    FOREIGN KEY (maVatTu)
        REFERENCES vat_tu (maVatTu)
);


CREATE TABLE chi_tiet_phieu_nhap (
    dGNhap INT NOT NULL,
    soLuongNhap INT NOT NULL,
    soPN INT,
    maVatTu INT,
    PRIMARY KEY (soPN , maVatTu),
    FOREIGN KEY (soPN)
        REFERENCES phieu_nhap (soPN),
    FOREIGN KEY (maVatTu)
        REFERENCES vat_tu (maVatTu)
);


CREATE TABLE chi_tiet_don_dat_hang (
    soDh INT,
    maVatTu INT,
    PRIMARY KEY (soDh , maVatTu),
    FOREIGN KEY (soDh)
        REFERENCES don_dh (soDh),
    FOREIGN KEY (maVatTu)
        REFERENCES vat_tu (maVatTu)
);




