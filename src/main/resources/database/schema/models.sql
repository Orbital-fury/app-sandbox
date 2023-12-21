DROP TABLE models;
CREATE TABLE models (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    type varchar(128) NOT NULL,
    brand_id int NOT NULL REFERENCES brands(id)
);