drop database if exists Furama;

create database Furama;
use Furama;

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin 
-- của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng
-- cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.

create or replace view v_nhan_vien as
select  nv.ma_nhan_vien,
		ho_ten ,
		ngay_sinh,
		so_cmnd ,
		luong ,
		so_dien_thoai,
		email ,
		dia_chi ,
		ma_vi_tri ,
		ma_trinh_do ,
		ma_bo_phan
from nhan_vien nv
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
and nv.dia_chi like "% Yên Bái%"
and ngay_lam_hop_dong = "2021-04-25" ;

SELECT 
    *
FROM
    v_nhan_vien;

-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành 
-- “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.

set sql_safe_updates =0;
UPDATE v_nhan_vien 
SET 
    dia_chi = 'Liên Chiểu, Đà Nẵng';
set sql_safe_updates =1;

SELECT 
    *
FROM
    nhan_vien;

-- 23.Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của 
-- một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.

delimiter $$
create procedure sp_xoa_khach_hang (in ma_kh int)
begin
set sql_safe_updates =0;
set foreign_key_checks =0;
 
delete from khach_hang kh
where kh.ma_khach_hang = ma_kh;
end $$

set foreign_key_checks =0;
set sql_safe_updates =1;
delimiter ;

drop procedure sp_xoa_khach_hang;

select * from khach_hang;
call sp_xoa_khach_hang(2);

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu 
-- sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không 
-- được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

DROP procedure IF EXISTS sp_them_moi_hop_dong ;

delimiter $$
create procedure sp_them_moi_hop_dong (in ngay_lam_hop_dong_f DATETIME,
    ngay_ket_thuc_f DATETIME,
    tien_dat_coc_f DOUBLE,
    ma_nhan_vien_f INT,
    ma_khach_hang_f INT ,
    ma_dich_vu_f INT)
begin
if(select checkCorrect(
    ma_nhan_vien_f ,
    ma_khach_hang_f ,
    ma_dich_vu_f)) then
    insert into hop_dong(ngay_lam_hop_dong,
		ngay_ket_thuc, 
		tien_dat_coc, 
		ma_nhan_vien, 
		ma_khach_hang, 
		ma_dich_vu)
	values(ngay_lam_hop_dong_f,
		ngay_ket_thuc_f ,
		tien_dat_coc_f,
		ma_nhan_vien_f ,
		ma_khach_hang_f ,
		ma_dich_vu_f);
end if;
end$$
delimiter ;
    
call sp_them_moi_hop_dong("2025-07-15", "2020-07-21", "900000", "3", "7", "4");
select * from hop_dong;

-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng
 -- hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong 
 -- bảng hop_dong ra giao diện console của database.
 
delimiter $$
create trigger tr_xoa_hop_dong 
AFTER DELETE ON hop_dong for each row
begin 
declare so_luong_hd int;
declare msg varchar(128);
select count(ma_hop_dong) into so_luong_hd from hop_dong;
set msg = concat('Số bảng ghi còn lai = ',so_luong_hd);
insert into mess(mess)
values(concat('Số bảng ghi còn lai = ',so_luong_hd));
end $$
delimiter ;

drop trigger tr_xoa_hop_dong ;

select * from hop_dong;

-- xóa hợp đồng test --
set sql_safe_updates = 0;
set foreign_key_checks =0;
DELETE FROM hop_dong 
WHERE
    ma_hop_dong = 7;
SELECT 
    *
FROM
    mess;
set foreign_key_checks =1;
set sql_safe_updates = 1;

truncate table mess;

-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, 
-- cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: 
-- Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. 
-- Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra 
-- thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.

delimiter $$
create trigger tr_cap_nhat_hop_dong 
before update on hop_dong 
for each row
begin
declare mess varchar(128);

set mess= "Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày";
if((new.ngay_ket_thuc - new.ngay_lam_hop_dong)<2) then
signal sqlstate '45000' set message_text = mess;
end if;
end $$
delimiter ;

SELECT 
    *
FROM
    hop_dong;

drop trigger tr_cap_nhat_hop_dong  ;

-- cập nhập hợp đồng -- 

set sql_safe_updates = 0;
UPDATE hop_dong 
SET 
    ngay_lam_hop_dong = '2021-09-19',
    ngay_ket_thuc = '2021-09-10'
WHERE
    ma_hop_dong = 7;
set sql_safe_updates = 1;

SELECT 
    *
FROM
    hop_dong;


-- 27.	Tạo Function thực hiện yêu cầu sau:
-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
DROP function IF EXISTS func_dem_dich_vu;

delimiter $$
create function func_dem_dich_vu (money int)
returns int
deterministic
begin
	declare result int;
	select count(*) into result from
	(
		select
			dv.ma_dich_vu
		from dich_vu dv
			join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
			left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
			left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem= dvdk.ma_dich_vu_di_kem
		group by dv.ma_dich_vu
		having SUM(chi_phi_thue + ifnull( so_luong * gia,0)) >= money
    ) as tmp;
return result;
end $$
delimiter ;

SELECT FUNC_DEM_DICH_VU(2000000);