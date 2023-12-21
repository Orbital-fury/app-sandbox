DROP TABLE machines;
CREATE TABLE machines (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    model_id int NOT NULL REFERENCES models(id),
    serial_number varchar(128) NOT NULL,
    need_maintenance boolean NOT NULL,
    factory_id int REFERENCES factories(id),
    created_at date NOT NULL,
    last_maintenance_date date,
    state_machine varchar(64) NOT NULL
);