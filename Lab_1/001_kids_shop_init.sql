/*
-- CLEAN UP
-- run the following lines to clean up the database
drop table category;
drop table product;
drop table vote;
*/

/*
If you already have the database, do not run the next two lines
*/
# drop database kids_shop;
# drop database if exists kids_shop_reporting_db;
create database kids_shop;
use kids_shop;

create table category (
    id int not null auto_increment primary key,
    name varchar(100)
);

create table product (
    id int not null auto_increment primary key,
    name varchar(100),
    category_id int not null,
    votes int not null default 0
);

create table vote (
    id int not null auto_increment primary key,
    product_id int not null,
    is_up_vote bit
);

delimiter //
create procedure recalculate_product_votes()
begin
    update product p
        set votes =
            (select count(*) from vote where product_id = p.id and is_up_vote = true)
            - (select count(*) from vote where product_id = p.id and is_up_vote = false)
    where 1 = 1;
end;//
delimiter ;

CREATE TABLE change_log (
    id INT AUTO_INCREMENT PRIMARY KEY,
    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    script_name VARCHAR(255),
    script_details varchar(255)
);

insert into change_log (applied_at, created_by, script_name, script_details)
values (now(), 'Tahlil', '001_kids_shop_init.sql', 'provided in the lab task');





