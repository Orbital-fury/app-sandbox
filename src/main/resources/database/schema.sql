CREATE TABLE brands (
    id int NOT NULL PRIMARY KEY,
    name varchar(128) NOT NULL,
    website varchar(128) NOT NULL,
    hq_address varchar(255) NOT NULL
);

CREATE TABLE factories
(
    id int NOT NULL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    type VARCHAR(128) NOT NULL,
    address VARCHAR(255) NOT NULL
);

CREATE TABLE models (
    id int NOT NULL PRIMARY KEY,
    name varchar(128) NOT NULL,
    type varchar(128) NOT NULL,
    brand_id int NOT NULL REFERENCES brands(id)
);

CREATE TABLE machines (
    id int NOT NULL PRIMARY KEY,
    model_id int NOT NULL REFERENCES models(id),
    serial_number varchar(128) NOT NULL,
    need_maintenance boolean NOT NULL,
    factory_id int REFERENCES factories(id),
    created_at varchar(255) NOT NULL,
    last_maintenance_date varchar(255),
    state varchar(64) NOT NULL
);
