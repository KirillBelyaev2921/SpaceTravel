INSERT INTO clients (name)
VALUES ('Alice Johnson');
INSERT INTO clients (name)
VALUES ('Bob Smith');
INSERT INTO clients (name)
VALUES ('Charlie Brown');
INSERT INTO clients (name)
VALUES ('David White');
INSERT INTO clients (name)
VALUES ('Emma Wilson');
INSERT INTO clients (name)
VALUES ('Frank Black');
INSERT INTO clients (name)
VALUES ('Grace Kelly');
INSERT INTO clients (name)
VALUES ('Henry Ford');
INSERT INTO clients (name)
VALUES ('Isabella Adams');
INSERT INTO clients (name)
VALUES ('Jack Daniels');

INSERT INTO planets (id, name)
VALUES ('MARS', 'Mars');
INSERT INTO planets (id, name)
VALUES ('VEN', 'Venus');
INSERT INTO planets (id, name)
VALUES ('EARTH', 'Earth');
INSERT INTO planets (id, name)
VALUES ('JUP', 'Jupiter');
INSERT INTO planets (id, name)
VALUES ('SAT', 'Saturn');

INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -10, NOW()), 1, 'EARTH', 'MARS');
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -9, NOW()), 2, 'MARS', 'VEN');
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -8, NOW()), 3, 'VEN', 'EARTH');
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -7, NOW()), 4, 'EARTH', 'JUP');
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -6, NOW()), 5, 'JUP', 'SAT');
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -5, NOW()), 6, 'SAT', 'EARTH');
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -4, NOW()), 7, 'MARS', 'JUP');
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -3, NOW()), 8, 'JUP', 'VEN');
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -2, NOW()), 9, 'VEN', 'SAT');
INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id)
VALUES (DATEADD('DAY', -1, NOW()), 10, 'SAT', 'MARS');