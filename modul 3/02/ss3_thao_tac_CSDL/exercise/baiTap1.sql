USE quan_ly_sinh_vien;


-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT 
    *
FROM
    student
WHERE
    student_name LIKE 'h%';
    
    
SELECT 
    *
FROM
    class
WHERE
    MONTH(start_date) = 12;


-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
 -- c1
-- select * from subject
-- where credit in (3,4,5)

-- c2
SELECT 
    *
FROM
    subject
WHERE
    credit BETWEEN 3 AND 5;
    
    
--     Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
SET sql_safe_updates = 0;
UPDATE student 
SET 
    class_id = 2
WHERE
    student_name = 'Hung';
SET sql_safe_updates = 1;


-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT 
    s.student_name, m.mark, su.sub_name
FROM
    mark m
        JOIN
    student s ON m.student_id = s.student_id
        JOIN
    subject su ON m.sub_id = su.sub_id
ORDER BY m.mark DESC , s.student_name ASC;