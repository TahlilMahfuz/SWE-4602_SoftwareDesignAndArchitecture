# Task A
CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

create table employee(
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    salary INT NOT NULL
);

create table category (
    id int not null auto_increment primary key,
    name varchar(100)
);

create table product (
    id int not null auto_increment primary key,
    name varchar(100),
    category_id int not null,
    average_rating double not null default 0,
    price double not null,
    foreign key (category_id) references category(id)
);

create table rating(
    rating_id INT AUTO_INCREMENT PRIMARY KEY,
    rating INT NOT NULL CHECK (rating >= 0 AND rating <= 5),
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    rating_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP, #added for requirements
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

create table invoice(
    invoice_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
    invoice_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

create table sale(
    sale_id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    unit_price INT NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoice(invoice_id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

insert into category (name) values
    ('toys'),
    ('cloths'),
    ('diaper');

insert into product (name, category_id,price) values
    ('light ball', 1,100),
    ('blocks', 1,200),
    ('cool red shirt', 2,300),
    ('long blue skirt', 2,400),
    ('nice green pants', 2,500),
    ('kids comfi', 3,600);




# Task B
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



DELIMITER //



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

alter table category add column total_sale double not null default 0;
alter table sale add column category_id int not null references category(id);







DELIMITER //
CREATE PROCEDURE get_sale_per_category(IN employee_id INT)
BEGIN
    SELECT c.id AS category_id,
           c.name AS category_name,
           SUM(s.quantity * s.unit_price) AS total_sale
    FROM sale s
    JOIN invoice i ON s.invoice_id = i.invoice_id
    JOIN category c ON s.category_id = c.id
    WHERE i.employee_id = employee_id
    GROUP BY c.id, c.name;
END //
DELIMITER ;









