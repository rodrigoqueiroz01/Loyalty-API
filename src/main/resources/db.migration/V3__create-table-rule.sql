create table "rule-data" (
    rule_id varchar(255) not null primary key,
    created_at timestamp(6),
    name varchar(255) not null,
    conversion double precision not null,
    days_to_expire integer not null,
    redeem_limit integer,
    product_id varchar(255),
    product_name varchar(255)
);

alter table "rule-data" owner to postgres;