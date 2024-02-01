# Task A
use kids_shop;

# Alter tables
alter table product add column average_rating double not null default 0;
alter table product add column price double not null;
alter table product add foreign key (category_id) references category(id);

# Create Tables
CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

create table employee(
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    salary INT NOT NULL
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


# insert customer
insert into customer (name) values ('tahlil');

# insert employee
insert into employee (employee_id, name, salary) values (1, 'tahlil', 1000);