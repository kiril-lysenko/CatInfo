INSERT INTO cats (id, name, color, tail_length, whiskers_length)
VALUES (1, 'Orange', 'RED', 18, 12),
       (2, 'Snow', 'WHITE', 21, 22),
       (3, 'John', 'BLACK_RED', 15, 11),
       (4, 'Lucky', 'BLACK_RED', 21, 10),
       (5, 'Norman', 'BLACK_RED', 11, 8);
ALTER SEQUENCE cats_seq RESTART WITH 5;

INSERT INTO cat_colors_info (cat_color, count) VALUES ('BLACK', 7);