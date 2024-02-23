USE kids_shop_reporting_db;
drop procedure if exists get_top_product_by_duration;
DELIMITER //
CREATE PROCEDURE get_top_product_by_duration(IN StartDate DATE, IN EndDate DATE)
BEGIN
    select  product_id,count(quantity) as total
        from fact_sale
        where fact_sale.Datetime between StartDate and EndDate
        group by product_id
        order by total desc
        limit 1;
END //
DELIMITER ;

call get_top_product_by_duration('2019-01-01', '2024-12-31');


