

CREATE TABLE brands (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    website varchar(128) NOT NULL,
    hq_address varchar(255) NOT NULL
);

CREATE TABLE factories
(
    id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    type VARCHAR(128) NOT NULL,
    address VARCHAR(255) NOT NULL
);

CREATE TABLE models (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    type varchar(128) NOT NULL,
    brand_id int NOT NULL REFERENCES brands(id)
);

CREATE TABLE machines (
    id int PRIMARY KEY AUTO_INCREMENT,
    model_id int NOT NULL REFERENCES models(id),
    serial_number varchar(128) NOT NULL,
    need_maintenance boolean NOT NULL,
    factory_id int REFERENCES factories(id),
    created_at varchar(255) NOT NULL,
    last_maintenance_date varchar(255),
    state varchar(64) NOT NULL
);

CREATE TABLE pc_element_types (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    code varchar(128) NOT NULL UNIQUE
);

CREATE TABLE pc_elements (
    id int PRIMARY KEY AUTO_INCREMENT,
    brand varchar(128) NOT NULL,
    model varchar(128) NOT NULL,
    price float NOT NULL,
    img varchar(255),
    element_type_id int NOT NULL REFERENCES pc_element_types(id)
);

CREATE TABLE pc_constraints (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(128) NOT NULL,
    code varchar(128) NOT NULL,
    type varchar(128) NOT NULL
);

CREATE TABLE pc_specifications (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    code varchar(128) NOT NULL UNIQUE
);

CREATE TABLE pc_element_types_constraints (
    id int PRIMARY KEY AUTO_INCREMENT,
    element_type_id int NOT NULL REFERENCES pc_element_types(id),
    constraint_id int NOT NULL REFERENCES pc_constraints(id)
);

CREATE TABLE pc_elements_constraints (
    element_id int NOT NULL,
    constraint_id int NOT NULL,
    c_value varchar(64) NOT NULL,
    PRIMARY KEY (element_id, constraint_id, c_value),
    FOREIGN KEY (element_id) REFERENCES pc_elements(id),
    FOREIGN KEY (constraint_id) REFERENCES pc_constraints(id)
);

CREATE TABLE pc_element_types_specifications (
    id int PRIMARY KEY AUTO_INCREMENT,
    element_type_id int NOT NULL REFERENCES pc_element_types(id),
    specification_id int NOT NULL REFERENCES pc_specifications(id)
);

CREATE TABLE pc_elements_specifications (
    element_id int NOT NULL,
    specification_id int NOT NULL,
    s_value varchar(64) NOT NULL,
    PRIMARY KEY (element_id, specification_id, s_value),
    FOREIGN KEY (element_id) REFERENCES pc_elements(id),
    FOREIGN KEY (specification_id) REFERENCES pc_specifications(id)
);
