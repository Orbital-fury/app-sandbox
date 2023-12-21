DROP TABLE brands;
CREATE TABLE brands (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(128) NOT NULL,
    website varchar(128) NOT NULL,
    hq_address varchar(255) NOT NULL
);