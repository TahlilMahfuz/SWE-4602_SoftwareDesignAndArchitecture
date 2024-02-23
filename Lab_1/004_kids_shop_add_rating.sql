# Task B
use kids_shop;

DELIMITER //

CREATE PROCEDURE add_rating(
    IN p_product_id INT,
    IN p_rating_value INT,
    IN p_customer_id INT
)
BEGIN
    DECLARE cat_id INT;
    DECLARE avg_rating INT;

    INSERT INTO rating (rating, customer_id, product_id)
    VALUES (p_rating_value, p_customer_id, p_product_id);

    UPDATE product
    SET average_rating = (SELECT AVG(rating) FROM rating WHERE product_id = p_product_id)
    WHERE id = p_product_id;

    SELECT category_id, average_rating INTO cat_id, avg_rating FROM product WHERE id = p_product_id;

    UPDATE category
    SET average_rating = (SELECT AVG(average_rating) FROM product WHERE category_id = cat_id)
    WHERE id = cat_id;
END //

DELIMITER ;

call add_rating(1, 5, 1);
call add_rating(2, 4, 1);
call add_rating(3, 3, 1);
call add_rating(4, 2, 1);
call add_rating(5, 5, 1);

insert into change_log (applied_at, created_by, script_name, script_details)
values (now(), 'Tahlil', '004_kids_add_rating.sql', 'added rating procedure');