USE CaseStudyforDatabase;

/* 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” 
và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.*/

SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem
FROM
    khach_hang
        INNER JOIN
    loai_khach ON loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
        INNER JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        INNER JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        INNER JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
WHERE
    loai_khach.ten_loai_khach = 'Diamond'
        AND (khach_hang.dia_chi LIKE '%Vinh'
        OR khach_hang.dia_chi LIKE '%Quảng Ngãi');
-- 12.	Hiển thị thông tin
-- ma_hop_dong,ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- ten_dich_vu, 
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), 
-- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 
-- nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.


SELECT 
    hop_dong.ma_hop_dong,
    nhan_vien.ho_ten AS ho_ten_nhan_vien,
    khach_hang.ho_ten AS ho_ten_khach_hang,
    khach_hang.so_dien_thoai,
    dich_vu.ten_dich_vu,
    SUM(hop_dong_chi_tiet.so_luong) AS so_luong_dich_vu_di_kem,
    hop_dong.tien_dat_coc
FROM
    hop_dong
        INNER JOIN
    khach_hang
			ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        LEFT JOIN
    nhan_vien
			ON nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
        LEFT JOIN
    dich_vu 
			ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet 
			ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
WHERE
    YEAR(ngay_lam_hop_dong) = 2020
        AND QUARTER(ngay_lam_hop_dong) = 4
        AND hop_dong.ma_hop_dong 
			NOT IN (
				SELECT 
					hop_dong.ma_hop_dong
				FROM
					hop_dong
				WHERE
					YEAR(ngay_lam_hop_dong) = 2021
						AND (QUARTER(ngay_lam_hop_dong) = 1
						OR QUARTER(ngay_lam_hop_dong) = 2)
				GROUP BY hop_dong.ma_hop_dong
			)
GROUP BY hop_dong.ma_hop_dong;

select quarter('2022-07-19');


-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).


SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    SUM(hop_dong_chi_tiet.so_luong) AS so_luong_dich_vu_di_kem
FROM
    dich_vu_di_kem
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
        LEFT JOIN
    hop_dong ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem
HAVING so_luong_dich_vu_di_kem >= (SELECT 
        MAX(hop_dong_chi_tiet.so_luong) 
    FROM
        dich_vu_di_kem
            LEFT JOIN
        hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
            LEFT JOIN
        hop_dong ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong)
;


-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, 
-- so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).


SELECT DISTINCT
    hop_dong.ma_hop_dong,
    dich_vu.ten_dich_vu,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    COUNT(dich_vu_di_kem.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM
    dich_vu_di_kem
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
        LEFT JOIN
    hop_dong ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        LEFT JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
GROUP BY dich_vu_di_kem.ma_dich_vu_di_kem
HAVING so_lan_su_dung <= 1
;

-- 15.	Hiển thi thông tin của tất cả nhân viên 
-- bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
-- mới chỉ lập được tối đa
-- 3 hợp đồng 
-- từ năm 2020 đến 2021.

SELECT 
    nhan_vien.ma_nhan_vien,
    nhan_vien.ho_ten,
    trinh_do.ten_trinh_do,
    bo_phan.ten_bo_phan,
    nhan_vien.so_dien_thoai,
    nhan_vien.dia_chi
FROM
    nhan_vien
        LEFT JOIN
    trinh_do ON trinh_do.ma_trinh_do = nhan_vien.ma_trinh_do
        LEFT JOIN
    bo_phan ON bo_phan.ma_bo_phan = nhan_vien.ma_bo_phan
        LEFT JOIN
    hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN 2020 AND 2021
GROUP BY nhan_vien.ma_nhan_vien
HAVING COUNT(hop_dong.ma_nhan_vien) <= 3
ORDER BY hop_dong.ma_nhan_vien
;

