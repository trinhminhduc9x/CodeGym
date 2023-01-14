use furama_resort;

/*
6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).*/



SELECT 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.chi_phi_thue,
    ldv.ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
        JOIN
    hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
WHERE
    dv.ma_dich_vu NOT IN (SELECT 
            dv.ma_dich_vu
        FROM
            dich_vu dv
                JOIN
            hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
        WHERE
            ((MONTH(hd.ngay_lam_hop_dong) BETWEEN 1 AND 3)
                AND YEAR(hd.ngay_lam_hop_dong) = '2021')
        GROUP BY dv.ten_dich_vu)
GROUP BY dv.ten_dich_vu
ORDER BY dv.dien_tich DESC;

/*7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch 
vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.*/


SELECT 
    dv.ma_dich_vu,
    dv.ten_dich_vu,
    dv.dien_tich,
    dv.so_nguoi_toi_da,
    dv.chi_phi_thue,
    ldv.ten_loai_dich_vu
FROM
    dich_vu dv
        JOIN
    loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
        JOIN
    hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
WHERE
    dv.ma_dich_vu NOT IN (SELECT 
            dv.ma_dich_vu
        FROM
            dich_vu dv
                JOIN
            hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu
        WHERE
            (hd.ngay_lam_hop_dong) BETWEEN '2021-01-01' AND '2021-12-31'
        GROUP BY dv.ten_dich_vu)
        AND YEAR(hd.ngay_lam_hop_dong) = '2020'
GROUP BY dv.ten_dich_vu;

 /*8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.*/

 /*cách1 */

SELECT 
    khach_hang.ho_ten
FROM
    khach_hang 
UNION 
SELECT 
    khach_hang.ho_ten
FROM
    khach_hang;

/*cach2*/
SELECT 
    khach_hang.ho_ten,
    COUNT(khach_hang.ho_ten) so_nguoi_trung_ten
FROM
    khach_hang
GROUP BY khach_hang.ho_ten
HAVING so_nguoi_trung_ten > 1;

/*cach 3*/
SELECT DISTINCT
    khach_hang.ho_ten
FROM
    khach_hang
GROUP BY khach_hang.ho_ten > 1;

/*9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/

SELECT 
    MONTH(hd.ngay_lam_hop_dong) thang,
    COUNT(hd.ngay_lam_hop_dong) so_luong_khach_hang
FROM
    hop_dong hd
WHERE
    YEAR(hd.ngay_lam_hop_dong) = '2021'
GROUP BY MONTH(hd.ngay_lam_hop_dong)
ORDER BY thang;

/*10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, 
ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).*/

SELECT 
    hd.ma_hop_dong,
    hd.ngay_lam_hop_dong,
    hd.ngay_ket_thuc,
    hd.tien_dat_coc,
    SUM(IFNULL(hdct.so_luong, 0)) so_luong_dich_vu_di_kem
FROM
    hop_dong hd
        LEFT JOIN
    hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
GROUP BY hd.ma_hop_dong;
