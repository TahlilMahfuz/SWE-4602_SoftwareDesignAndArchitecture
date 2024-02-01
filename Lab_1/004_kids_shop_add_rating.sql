# Task B
use kids_shop;
DELIMITER //

CREATE PROCEDURE add_rating(
    IN p_product_id INT,
    IN p_rating_value INT,
    IN p_customer_id INT
)
BEGIN
    INSERT INTO rating (rating, customer_id, product_id)
    VALUES (p_rating_value, p_customer_id, p_product_id);
    UPDATE product
    SET average_rating = (SELECT AVG(rating) FROM rating WHERE product_id = p_product_id)
    WHERE id = p_product_id;
END //

DELIMITER ;

call add_rating(1, 5, 1);

