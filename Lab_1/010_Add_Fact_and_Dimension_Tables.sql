use kids_shop;

create table kids_shop_reporting_db.dimension_product
as select * from kids_shop.product;

create table kids_shop_reporting_db.dimension_categories
as select * from kids_shop.category;

create table kids_shop_reporting_db.dimension_customer
as select * from kids_shop.customer;

create table kids_shop_reporting_db.dimension_employee
as select * from kids_shop.employee;

create table kids_shop_reporting_db.dimension_invoice
as select * from kids_shop.invoice;

create table kids_shop_reporting_db.dimension_rating
as select * from kids_shop.rating;


CREATE TABLE kids_shop_reporting_db.fact_sale
as select * from kids_shop.sale;