USE CaseStudyforDatabase;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
SET sql_safe_updates = 0;
DELETE FROM nhan_vien 
WHERE
    nhan_vien.ma_nhan_vien NOT IN (SELECT 
        nhan_vien_new.ma_nhan_vien
    FROM
        (SELECT 
            nhan_vien.ma_nhan_vien
        FROM
            nhan_vien
        LEFT JOIN bo_phan ON bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
        LEFT JOIN hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
        
        WHERE
            YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN 2019 AND 2021
        GROUP BY nhan_vien.ma_nhan_vien) nhan_vien_new);
 SET sql_safe_updates =1;


-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với
--  Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
-- TEST
SELECT 
    k.ma_khach_hang, k.ho_ten, lk.ten_loai_khach
FROM
    khach_hang k
        LEFT JOIN
    loai_khach lk ON k.ma_loai_khach = lk.ma_loai_khach
        LEFT JOIN
    hop_dong hd ON hd.ma_khach_hang = k.ma_khach_hang
        LEFT JOIN
    dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE lk.ten_loai_khach ='Platinium' 
		AND YEAR(hd.ngay_lam_hop_dong) = '2021'
GROUP BY k.ma_loai_khach
HAVING SUM((IFNULL(hdct.so_luong * dvdk.gia, 0)) + chi_phi_thue) > 1000000;

-- CACH CHINH
SET sql_safe_updates = 0;
 UPDATE khach_hang 
 SET ma_loai_khach = 1 
 WHERE ma_loai_khach =2 
 AND khach_hang.ma_loai_khach
 IN  (
 SELECT 
        khach_new.ma_khach_hang
    FROM
    ( 
    SELECT
    k.ma_khach_hang
FROM
    khach_hang k
        LEFT JOIN
    loai_khach lk ON k.ma_loai_khach = lk.ma_loai_khach
        LEFT JOIN
    hop_dong hd ON hd.ma_khach_hang = k.ma_khach_hang
        LEFT JOIN
    dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE lk.ten_loai_khach ='Platinium' 
		AND YEAR(hd.ngay_lam_hop_dong) = '2021'
GROUP BY k.ma_khach_hang
HAVING SUM((IFNULL(hdct.so_luong * dvdk.gia, 0)) + chi_phi_thue) > 1000000)khach_new);
SET sql_safe_updates =1;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
-- tim kiem khach hang
SELECT DISTINCT
    k.ma_khach_hang, k.ho_ten
	FROM
    khach_hang k
        LEFT JOIN
    loai_khach lk ON k.ma_loai_khach = lk.ma_loai_khach
        LEFT JOIN
    hop_dong hd ON hd.ma_khach_hang = k.ma_khach_hang
        LEFT JOIN
    dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE
     YEAR(hd.ngay_lam_hop_dong) < '2021';



-- cach lam
SET sql_safe_updates = 0;
SET foreign_key_checks =0;
DELETE FROM khach_hang 
WHERE
    khach_hang.ma_khach_hang IN (SELECT 
        khach_hang_new.ma_khach_hang
    FROM (SELECT DISTINCT
    k.ma_khach_hang, k.ho_ten
	FROM
    khach_hang k
        LEFT JOIN
    loai_khach lk ON k.ma_loai_khach = lk.ma_loai_khach
        LEFT JOIN
    hop_dong hd ON hd.ma_khach_hang = k.ma_khach_hang
        LEFT JOIN
    dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE
     YEAR(hd.ngay_lam_hop_dong) < '2021')
      khach_hang_new );
SET sql_safe_updates =1;



-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.


-- xac dinh dich vu dk duoc su xung tren 10 lan


SELECT 
    dvdk.ma_dich_vu_di_kem,
    dvdk.ten_dich_vu_di_kem,
    SUM(hdct.so_luong) AS tong_so
FROM
    hop_dong hd
        JOIN
    hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
        JOIN
    dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE
    YEAR(hd.ngay_lam_hop_dong) = '2020'
GROUP BY dvdk.ma_dich_vu_di_kem
HAVING tong_so > 10
;

-- bai lam


SET sql_safe_updates = 0;
UPDATE dich_vu_di_kem 
SET 
    gia = gia * 2
WHERE
    ma_dich_vu_di_kem IN (SELECT 
            ma_dich_vu_di_kem
        FROM
            hop_dong hd
                JOIN
            hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
                AND YEAR(ngay_lam_hop_dong) = '2020'
        GROUP BY ma_dich_vu_di_kem
        HAVING SUM(so_luong) > 10);
SET sql_safe_updates =1;


-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang),
--  ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
-- cach 1
SELECT 
    nv.ma_nhan_vien,
    kh.ma_khach_hang,
    kh.ho_ten,
    kh.email,
    kh.so_dien_thoai,
    kh.ngay_sinh,
    kh.dia_chi,
    nv.ho_ten,
    nv.email,
    nv.so_dien_thoai,
    nv.ngay_sinh,
    nv.dia_chi
FROM
    hop_dong hd
        RIGHT JOIN
    khach_hang kh ON kh.ma_khach_hang = hd.ma_khach_hang
        RIGHT JOIN
    nhan_vien nv ON nv.ma_nhan_vien = hd.ma_nhan_vien
;
-- cach2 
SELECT 
    kh.ma_khach_hang AS id,
    kh.ho_ten,
    kh.email,
    kh.so_dien_thoai,
    kh.ngay_sinh,
    kh.dia_chi
FROM
    khach_hang kh 
UNION SELECT 
    nv.ma_nhan_vien,
    nv.ho_ten,
    nv.email,
    nv.so_dien_thoai,
    nv.ngay_sinh,
    nv.dia_chi
FROM
    nhan_vien nv;
       

