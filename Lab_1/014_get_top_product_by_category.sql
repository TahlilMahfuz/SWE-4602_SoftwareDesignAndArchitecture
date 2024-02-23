use kids_shop_reporting_db;

DELIMITER //
CREATE PROCEDURE get_top_product_by_category(IN category_id INT)
BEGIN
    SELECT p.id, p.name, p.average_rating
    FROM dimension_product p
    WHERE p.category_id = category_id
    order by average_rating desc limit 1;
END //
DELIMITER ;

call get_top_product_by_category(1);
call get_top_product_by_category(2);