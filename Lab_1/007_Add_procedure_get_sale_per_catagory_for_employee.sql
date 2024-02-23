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

insert into change_log (applied_at, created_by, script_name, script_details)
values (now(), 'Tahlil', '007_Add_Procedure_get_sale_per_category_for_employees', 'added procedure to get sale per category for employees');