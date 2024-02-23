use kids_shop_reporting_db;

DELIMITER //
CREATE PROCEDURE get_top_3_products()
BEGIN
    SELECT * FROM dimension_product ORDER BY average_rating DESC LIMIT 3;
END //
DELIMITER ;

call get_top_3_products();


