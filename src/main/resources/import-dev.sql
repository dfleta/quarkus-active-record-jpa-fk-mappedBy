DROP TABLE IF EXISTS fruit;
DROP TABLE IF EXISTS farmer;
CREATE TABLE farmer
(
    name VARCHAR(255) NOT NULL UNIQUE,
    location VARCHAR(255),
    PRIMARY KEY (name)
) ENGINE = InnoDB;
CREATE TABLE fruit
(
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR (255) NOT NULL, 
    description VARCHAR(255), 
    farmer_name VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id),
    CONSTRAINT `fk_fruit_farmer`
        FOREIGN KEY (farmer_name) REFERENCES farmer (name)
) ENGINE = InnoDB;
INSERT INTO
    farmer (name, location) 
VALUES
    ('Farmer Rick', 'Sa Pobla'),
    ('Morty Vegan', 'Es Vivero');
INSERT INTO 
    fruit (id, name, description, farmer_name) 
VALUES 
    (1000, 'Apple', 'Winter fruit', 'Farmer Rick'),
    (2000, 'Pineapple', 'Tropical fruit', 'Morty Vegan');
