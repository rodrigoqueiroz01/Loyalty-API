create table "transaction-data" (
    seq_id serial primary key,
    trasaction_id varchar(255),
    type integer,
    rule_id varchar(255) not null,
    customer_id varchar(255) not null
    store_id varchar(255) not null,
    order_id varchar(255) not null,
    created_at timestamp(6),
    points integer not null,
    amount integer not null,
    expiration timestamp(6),
    product_id varchar(255),
    product_name varchar(255)
);

alter table "transaction-data" owner to postgres;