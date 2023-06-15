create table "customer-data" (
    customer_id varchar(255) not null primary key,
    created_at  timestamp(6),
    document varchar(11)  not null constraint uk_394dfwelqldc7fm0t4tujsy1r unique,
    name varchar(255) not null constraint uk_8r0odc056xdesaggurb8iotc5 unique
);

alter table "customer-data" owner to postgres;