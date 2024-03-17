use kids_shop;
DELIMITER //
CREATE PROCEDURE get_average_rating(
    IN p_product_id INT,
    OUT p_average_rating DOUBLE
)
BEGIN
    declare counts int;
    declare sum_of_ratings int;
    select count(*) into  counts
                    from rating
                    where product_id = p_product_id;

    select sum(rating) into sum_of_ratings
                    from rating
                    where product_id = p_product_id;

    update product
    set average_rating = sum_of_ratings/counts
    where id = p_product_id;

    SELECT average_rating INTO p_average_rating
    FROM product
    WHERE id = p_product_id;

END //

DELIMITER ;


call get_average_rating(1, @average_rating);
select @average_rating;

insert into change_log (applied_at, created_by, script_name, script_details)
values (now(), 'Tahlil', '005_kids_shop_average_rating.sql', 'added procedure get_average_rating');