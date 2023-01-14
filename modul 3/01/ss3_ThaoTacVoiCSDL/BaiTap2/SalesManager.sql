use SalesManager;

INSERT INTO  SalesManager.customer (cID, cName, cAge) 
VALUES ('1', 'Minh Quan', '10'),
('2', 'Ngoc Oanh', '20'),
('3', 'Hong Ha', '50');

INSERT INTO SalesManager.product (pID, pName, pPrice) 
VALUES ('1', 'May Giat', '3'),
('2', 'Tu Lanh', '5'),
('3', 'Dieu Hoa', '7'),
('4', 'Quat', '1'),
('5', 'Bep Dien', '2');


INSERT INTO SalesManager.ordera (oID, cID, oDate, oTotal) 
VALUES ('1', '1', '2006-03-21', Null),
('2', '2', '2006-03-23', Null),
('3', '1', '2006-03-16', Null);

INSERT INTO SalesManager.orderDetail (oID, pID, odQTY) 
VALUES ('1', '1', '3'),
('1', '3', '7'),
('1', '4', '2'),
('2', '1', '1'),
('3', '1', '8'),
('2', '5', '4'),
('2', '3', '3');


-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT 
    oID, oDate, oTotal
FROM
    `ordera`;
    -- sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách

SELECT 
    c.cName, p.pName
FROM
    orderDetail od
        JOIN
    product p ON od.pID = p.pID
        JOIN
    `ordera` o ON o.oID = od.oID
        JOIN
    customer c ON c.cID = o.cID;


-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT 
    c.cName
FROM
    customer c
        LEFT JOIN
    `ordera` o ON (o.cID = c.cID)
WHERE
    o.cID IS NULL;
    
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
--    (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
--     Giá bán của từng loại được tính = odQTY*pPrice)
SELECT 
    o.oID, o.oDate, SUM(p.pPrice * od.odQTY)
FROM
    orderDetail od
        JOIN
    product p ON p.pID = od.pID
        JOIN
    `ordera` o ON od.oID = o.oID
GROUP BY od.oID