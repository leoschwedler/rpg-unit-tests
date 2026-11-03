CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY ,
    first_name VARCHAR(150),
    last_name VARCHAR(150),
    email TEXT NOT NULL UNIQUE
);