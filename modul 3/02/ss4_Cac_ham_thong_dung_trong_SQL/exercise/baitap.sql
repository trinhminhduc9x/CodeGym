-- 1. Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
SELECT 
    *
FROM
    subject s
WHERE
    s.credit = (SELECT 
            MAX(credit)
        FROM
            subject);
            
            
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT 
    s.*, m.mark
FROM
    subject s
        JOIN
    mark m ON m.sub_id = s.sub_id
WHERE
    m.mark = (SELECT 
            MAX(mark)
        FROM
            mark);
            
            
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT 
    s.*, AVG(m.mark) AS diem_trung_binh
FROM
    student s
        LEFT JOIN
    mark m ON m.student_id = s.student_id
GROUP BY m.student_id
ORDER BY diem_trung_binh DESC;
		