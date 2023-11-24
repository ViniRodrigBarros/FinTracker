-- init.sql
CREATE DATABASE IF NOT EXISTS fintracker;

USE fintracker;

CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    cpf VARCHAR(11),
    date_of_birth DATE
);

INSERT INTO user (username, email, password,  cpf, date_of_birth) VALUES
    ('thiagoaciole@gmail.com', '1234', 'thiagoaciole', '12345678901', '2002-10-21'),
    ('vinicius@gmail.com', '1234', 'vinicius', '23456789012', '1995-05-15'),
    ('lucas@gmail.com', '1234', 'lucas', '23456789012', '1995-05-15'),
    ('rafael@gmail.com', '1234', 'rafael', '34567890123', '2000-10-30');