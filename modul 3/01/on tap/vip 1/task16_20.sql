use furama_resort;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.

-- cach1
set sql_safe_updates = 0;
DELETE FROM nhan_vien 
WHERE
    ma_nhan_vien NOT IN (SELECT 
        *
    FROM
        (SELECT 
            nv.ma_nhan_vien
        FROM
            nhan_vien nv
        JOIN hop_dong hd ON hd.ma_nhan_vien = nv.ma_nhan_vien
        
        WHERE
            hd.ngay_lam_hop_dong BETWEEN '2019-01-01' AND '2021-12-31'
        GROUP BY nv.ma_nhan_vien) temp_table);
set sql_safe_updates = 1;

-- cach 2
SET SQL_SAFE_UPDATES = 0;
with ma_nhan_vien_can_xoa as (
select ma_nhan_vien from nhan_vien
where ma_nhan_vien
not in (select nhan_vien.ma_nhan_vien from nhan_vien
		join hop_dong on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
		where hop_dong.ngay_lam_hop_dong between '2019-01-01' and '2021-12-31'
		group by nhan_vien.ma_nhan_vien)
)
update nhan_vien
set `status` = 1
where ma_nhan_vien in (select ma_nhan_vien from ma_nhan_vien_can_xoa);
SET SQL_SAFE_UPDATES = 1;

SELECT 
    nv.ma_nhan_vien, nv.ho_ten
FROM
    nhan_vien nv
WHERE
    `status` = 1;


/*17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng
 Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.*/
 
UPDATE khach_hang 
SET 
    khach_hang.ma_loai_khach = (SELECT 
            ma_loai_khach
        FROM
            loai_khach
        WHERE
            ten_loai_khach = 'Diamond')
WHERE
    kh.ma_khach_hang IN (SELECT 
            *
        FROM
            (SELECT 
                kh.ma_khach_hang
            FROM
                khach_hang kh
            JOIN loai_khach lk ON lk.ma_loai_khach = kh.ma_loai_khach
            JOIN hop_dong hd ON hd.ma_khach_hang = kh.ma_khach_hang
            JOIN dich_vu dv ON dv.ma_dich_vu = hd.ma_dich_vu
            JOIN hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
            JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
            WHERE
                (YEAR(hd.ngay_lam_hop_dong) = 2021
                    AND lk.ten_loai_khach = 'Platinium')
                    AND (kh.`status` = 0)
            HAVING SUM((hdct.so_luong * dvdk.gia) + chi_phi_thue) >= 10000000) temp_table);
            
SELECT 
    *
FROM
    khach_hang;       
  /*  
18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).*/

-- cach 1

SET SQL_SAFE_UPDATES = 0;
with ma_khach_hang_can_xoa as (
select distinct kh.ma_khach_hang from khach_hang kh
		join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
		where  year(hd.ngay_lam_hop_dong) < 2021
)
update khach_hang
set `status` = 1
where ma_khach_hang in (select ma_khach_hang from ma_khach_hang_can_xoa);
SET SQL_SAFE_UPDATES = 1;

select kh.ma_khach_hang,kh.ho_ten
from khach_hang kh
where `status` = 1;  

-- cach 2

set sql_safe_updates = 0;
set foreign_key_checks = 0;
delete from khach_hang
where ma_khach_hang  in(select temp_table.ma_khach_hang  from (
select distinct kh.ma_khach_hang from khach_hang kh
		join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
		where  year(hd.ngay_lam_hop_dong) < 2021) temp_table);
set foreign_key_checks = 1;
set sql_safe_updates = 1;
            
            
 /*  19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.*/
 
 
UPDATE dich_vu_di_kem 
SET 
    gia = gia * 2
WHERE
    dvdk.ma_dich_vu_di_kem = (SELECT 
            temp.ma_dich_vu_di_kem
        FROM
            (SELECT 
               dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia,SUM(hdct.so_luong)
            FROM
                hop_dong_chi_tiet hdct
            JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
            JOIN hop_dong hd ON hd.ma_hop_dong = hdct.ma_hop_dong
            WHERE
                YEAR(hd.ngay_lam_hop_dong) = 2020
            GROUP BY hdct.ma_dich_vu_di_kem
            HAVING SUM(hdct.so_luong) > 10)  temp);
            
            
 
 /*20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), 
 ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.*/
 
SELECT 
    nv.ma_nhan_vien AS id,
    nv.ho_ten,
    nv.ngay_sinh,
    nv.so_dien_thoai,
    nv.email,
    nv.dia_chi,
    'Nhân viên' as chuc_vu
FROM
    nhan_vien nv
UNION ALL SELECT 
    kh.ma_khach_hang,
    kh.ho_ten,
    kh.ngay_sinh,
    kh.so_dien_thoai,
    kh.email,
    kh.dia_chi,
    'Khách hàng' as chuc_vu
FROM
    khach_hang kh;

         

            


