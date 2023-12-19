CREATE TABLE models (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    type varchar(128) NOT NULL,
    brand_id int NOT NULL,
    PRIMARY KEY (id)
    FOREIGN KEY (brand_id) REFERENCES brands(id)
);