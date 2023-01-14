USE QuanLySinhVien;
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
  *
FROM
    Subject s
        JOIN
    Mark m ON m.SubId = s.SubId
WHERE
    m.mark = (
    SELECT 
            MAX(mark)
        FROM
            mark
            );
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT 
    *, AVG(m.Mark) AS diem_trung_binh
FROM
    Student s
        LEFT JOIN
    Mark m ON m.StudentId = s.StudentId
GROUP BY m.StudentId
ORDER BY diem_trung_binh DESC;
		