use kids_shop_reporting_db;

DELIMITER //
CREATE PROCEDURE top_3_categories()
BEGIN
    SELECT * FROM dimension_categories ORDER BY average_rating DESC LIMIT 3;
END //
DELIMITER ;

call top_3_categories();

