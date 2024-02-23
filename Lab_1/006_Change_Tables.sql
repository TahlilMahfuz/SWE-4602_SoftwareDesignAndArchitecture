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
insert into invoice (customer_id, employee_id, total_price) values (1, 1, 20000);
insert into invoice (customer_id, employee_id, total_price) values (1, 1, 30000);
insert into invoice (customer_id, employee_id, total_price) values (1, 1, 40000);
insert into invoice (customer_id, employee_id, total_price) values (1, 1, 50000);

insert into invoice (customer_id, employee_id, total_price) values (1, 1, 500000);
insert into invoice (customer_id, employee_id, total_price) values (1, 1, 1000);
insert into invoice (customer_id, employee_id, total_price) values (1, 1, 20000);
insert into invoice (customer_id, employee_id, total_price) values (1, 1, 440000);
insert into invoice (customer_id, employee_id, total_price) values (1, 1, 230000);

# add sale data
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (1, 1, 1, 100, 1, now(), 1);
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (2, 2, 2, 200, 4, now(), 1);
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (3, 3, 1, 30000, 5, now(), 1);
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (4, 2, 1, 40000, 2, now(), 1);
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (5, 1, 1, 50000, 5, now(), 1);

insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (6, 4, 1, 70000, 2, now(), 1);
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (7, 5, 1, 230000, 5, now(), 1);
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (8, 6, 1, 310000, 1, now(), 1);
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (9, 2, 1, 910000, 4, now(), 1);
insert into sale (invoice_id, product_id, quantity, unit_price, category_id, Datetime, employee_id)
values (10, 1, 1, 110000, 16, now(), 1);


insert into change_log (applied_at, created_by, script_name, script_details)
values (now(), 'Tahlil', '006_kids_Change_Tables.sql', 'Added more redundancy to the database');