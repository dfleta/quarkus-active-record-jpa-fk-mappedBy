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
    name VARCHAR (255) NOT NULL UNIQUE, 
    description VARCHAR(255), 
    farmer_name VARCHAR (255),
    PRIMARY KEY (name),
    CONSTRAINT `fk_fruit_farmer`
        FOREIGN KEY (farmer_name) REFERENCES farmer (name)
        ON DELETE SET NULL
        ON UPDATE SET NULL
) ENGINE = InnoDB;
INSERT INTO 
    farmer (name, location) 
VALUES
    ('Farmer Rick', 'Sa Pobla'),
    ('Morty Vegan', 'Es Vivero');
INSERT INTO 
    fruit (name, description, farmer_name) 
VALUES 
    ('Apple', 'Winter fruit', 'Farmer Rick'),
    ('Pineapple', 'Tropical fruit', 'Morty Vegan');
