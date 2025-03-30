CREATE TABLE clients
(
    id   LONG PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NUlL CHECK (LENGTH(name) BETWEEN 3 AND 200)
);

CREATE TABLE planets
(
    id   VARCHAR(20) PRIMARY KEY,
    name VARCHAR(500) NOT NUlL CHECK (LENGTH(name) BETWEEN 1 AND 500)
);

CREATE TABLE tickets
(
    id             LONG PRIMARY KEY AUTO_INCREMENT,
    created_at     TIMESTAMP WITH TIME ZONE,
    client_id      LONG REFERENCES clients (id),
    from_planet_id VARCHAR(20) REFERENCES planets (id),
    to_planet_id   VARCHAR(20) REFERENCES planets (id)
);
