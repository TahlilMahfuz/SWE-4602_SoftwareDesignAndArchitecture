use kids_shop;

DELIMITER //
CREATE PROCEDURE set_sell_per_category(IN product_id INT, IN category_id INT)
BEGIN
    update product
        set category_id=category_id
        where id=product_id;
END //
DELIMITER ;