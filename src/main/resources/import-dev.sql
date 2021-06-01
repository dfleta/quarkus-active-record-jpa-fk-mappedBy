DROP TABLE IF EXISTS Fruit;
DROP TABLE IF EXISTS Farmer;
CREATE TABLE Farmer
(
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    PRIMARY KEY (id)
) ENGINE = InnoDB;
CREATE TABLE Fruit
(
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR (255) NOT NULL, 
    description VARCHAR(255), 
    farmer_id BIGINT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT `fk_fruit_farmer`
        FOREIGN KEY (farmer_id) REFERENCES Farmer (id)
) ENGINE = InnoDB;
INSERT INTO 
    Farmer (id, name, location) 
VALUES
    (1000, 'Farmer Rick', 'Sa Pobla'),
    (2000, 'Morty Vegan', 'Es Vivero');
INSERT INTO 
    Fruit (id, name, description, farmer_id) 
VALUES 
    (1000, 'Apple', 'Winter fruit', 1000),
    (2000, 'Pineapple', 'Tropical fruit', 2000);
