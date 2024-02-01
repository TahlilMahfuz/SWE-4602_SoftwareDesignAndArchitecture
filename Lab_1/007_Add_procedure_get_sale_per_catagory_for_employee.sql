use kids_shop;

DELIMITER //
CREATE PROCEDURE get_sale_per_category(IN employee_id INT)
BEGIN
    select c.id,c.name, sum(s.quantity) as total_sales
        from sale s
    join category c on s.category_id = c.id
    where s.employee_id = employee_id
    group by c.id;
END //
DELIMITER ;

call get_sale_per_category(1);