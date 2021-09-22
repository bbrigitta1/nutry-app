DROP TABLE IF EXISTS foods;

CREATE TABLE foods (
    id serial PRIMARY KEY,
    description varchar(255)
);

INSERT INTO foods(description) VALUES('Apple');
INSERT INTO foods(description) VALUES('Egg');
INSERT INTO foods(description) VALUES('Bread');
INSERT INTO foods(description) VALUES('Cherry');