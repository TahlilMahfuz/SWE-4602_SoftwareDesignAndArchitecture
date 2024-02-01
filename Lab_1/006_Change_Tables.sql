use kids_shop;

alter table category add column total_sale double not null default 0;
alter table category add column average_rating double not null default 0;

alter table product add column sale_count int not null default 0;

alter table sale add column category_id int not null references category(id);
alter table sale add column Datetime datetime not null default now();
alter table sale add column employee_id int not null references employee(employee_id) ;

alter table invoice add column total_price double not null default 0;

# add invoice for customer
insert into invoice (customer_id, employee_id, total_price) values (1, 1, 10000);
# add sale data
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (1, 1, 1, 10000, 1, now(), 1);