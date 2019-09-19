create table shop
(
    id   integer not null
        constraint shop_pkey
            primary key,
    name varchar(255)
);


create table product
(
    id integer not null
            constraint product_pkey
                primary key,
    availability boolean,
    category     varchar(255),
    description  varchar(500),
    name         varchar(255),
    price        real,
    by_weight     boolean,
    shop_id      integer not null
        constraint fk94hgg8hlqfqfnt3dag950vm7n
            references shop
);
