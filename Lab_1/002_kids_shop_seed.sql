use kids_shop;

insert into category (name) values
    ('toys'),
    ('cloths'),
    ('diaper');

insert into product (name, category_id) values
    ('light ball', 1),
    ('blocks', 1),
    ('cool red shirt', 2),
    ('long blue skirt', 2),
    ('nice green pants', 2),
    ('kids comfi', 3);

insert into vote(product_id, is_up_vote) values
    (1, true),
    (1, true),
    (1, false),
    (2, false),
    (2, false),
    (3, true),
    (3, true),
    (5, false),
    (5, true),
    (5, true),
    (5, true);

call recalculate_product_votes();

select * from product;

insert into change_log (applied_at, created_by, script_name, script_details)
values (now(), 'Tahlil', '002_kids_shop_seed.sql', 'provided in the lab task');