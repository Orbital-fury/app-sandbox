CREATE TABLE machines (
    id int NOT NULL AUTO_INCREMENT,
    model_id int NOT NULL,
    serial_number varchar(128) NOT NULL,
    need_maintenance boolean NOT NULL,
    factory_id int,
    created_at date,
    last_maintenance_date date,
    state varchar(64),
    PRIMARY KEY (id)
    FOREIGN KEY (model_id) REFERENCES models(id),
    FOREIGN KEY (factory_id) REFERENCES factories(id)
);