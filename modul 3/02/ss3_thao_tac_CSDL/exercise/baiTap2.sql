use quan_ly_ban_hang;

INSERT INTO  quan_ly_ban_hang.customer (customer_id, customer_name, customer_age) 
VALUES ('1', 'Minh Quan', '10'),
('2', 'Ngoc Oanh', '20'),
('3', 'Hong Ha', '50');

INSERT INTO quan_ly_ban_hang.product (product_id, product_name, product_price) 
VALUES ('1', 'May Giat', '3'),
('2', 'Tu Lanh', '5'),
('3', 'Dieu Hoa', '7'),
('4', 'Quat', '1'),
('5', 'Bep Dien', '2');


INSERT INTO quan_ly_ban_hang.order (order_id, customer_id, order_date, order_total_price) 
VALUES ('1', '1', '2006-03-21', Null),
('2', '2', '2006-03-23', Null),
('3', '1', '2006-03-16', Null);

INSERT INTO quan_ly_ban_hang.order_detail (order_id, product_id, quantity) 
VALUES ('1', '1', '3'),
('1', '3', '7'),
('1', '4', '2'),
('2', '1', '1'),
('3', '1', '8'),
('2', '5', '4'),
('2', '3', '3');


-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT 
    order_id, order_date, order_total_price
FROM
    `order` ;
    
    
-- danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách

SELECT 
    c.customer_name, p.product_name
FROM
    order_detail od
        JOIN
    product p ON od.product_id = p.product_id
        JOIN
    `order` o ON o.order_id = od.order_id
        JOIN
    customer c ON c.customer_id = o.customer_id;


-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT 
    c.customer_name
FROM
    customer c
        LEFT JOIN
    `order` o ON (o.customer_id = c.customer_id)
WHERE
    o.customer_id IS NULL;
    
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
--    (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
--     Giá bán của từng loại được tính = odQTY*pPrice)
SELECT 
    o.order_id, o.order_date, SUM(p.product_price * od.quantity)
FROM
    order_detail od
        JOIN
    product p ON p.product_id = od.product_id
        JOIN
    `order` o ON od.order_id = o.order_id
GROUP BY od.order_id