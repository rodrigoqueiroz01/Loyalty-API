create table "balance-data" (
    customer_id varchar(255) not null primary key,
    store_id    varchar(255) not null,
    rule_id     varchar(255) not null,
    points integer not null,
    amount integer not null,
    next_expiration_date timestamp(6),
    next_expiration_points integer not null,
    points_to_expire_in_30 integer not null
);

alter table "balance-data" owner to postgres;

