create table "store-data" (
    store_id varchar(255) not null primary key,
    created_at timestamp(6),
    document varchar(14) not null,
    name varchar(255) not null
);

alter table "store-data" owner to postgres;