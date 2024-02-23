use kids_shop_reporting_db;

DELIMITER //
CREATE PROCEDURE get_top_employee_by_duration(IN start_date DATE, IN end_date DATE)
BEGIN
    SELECT employee_id, SUM(unit_price * quantity) AS total_sale
    FROM fact_sale
    WHERE fact_sale.Datetime BETWEEN start_date AND end_date
    GROUP BY employee_id
    ORDER BY total_sale DESC
    LIMIT 1;
END //
DELIMITER ;

call get_top_employee_by_duration('2020-01-01', '2024-12-31');