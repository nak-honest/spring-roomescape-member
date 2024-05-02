INSERT INTO theme (name, description, thumbnail)
VALUES ('theme1', 'description1', 'thumbnail1');
INSERT INTO theme (name, description, thumbnail)
VALUES ('theme2', 'description2', 'thumbnail2');

INSERT INTO reservation_time (start_at)
VALUES ('10:00');
INSERT INTO reservation_time (start_at)
VALUES ('11:00');

INSERT INTO reservation (name, date, reservation_time_id, theme_Id)
VALUES ('resevation', CURRENT_DATE + INTERVAL '1' DAY , 1, 1);
