CREATE DATABASE MuseumDB;

USE MuseumDB;

CREATE TABLE Museum (
	id BIGINT PRIMARY KEY,
	title VARCHAR(40) NOT NULL UNIQUE,
	address VARCHAR(100),
	phone VARCHAR(15),
	site VARCHAR(100),
	founding_date date
);

CREATE TABLE Painter (
	id BIGINT PRIMARY KEY,
	first_name VARCHAR(40) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	birth_date date,
	country VARCHAR(20),
    CONSTRAINT UC_Painter UNIQUE (first_name, last_name)
);

CREATE TABLE Picture (
	id BIGINT PRIMARY KEY,
	title VARCHAR(100) NOT NULL UNIQUE,
	painter_id BIGINT,
	museum_id BIGINT,
	creation_date date,
	FOREIGN KEY (painter_id) REFERENCES Painter(id),
	FOREIGN KEY (museum_id) REFERENCES Museum(id)
);

CREATE TABLE Visitor (
	id BIGINT PRIMARY KEY,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    birth_date date,
    CONSTRAINT UC_Visitor UNIQUE (first_name, last_name)
);

CREATE TABLE visitor_museum (
    visitor_id BIGINT,
    museum_id BIGINT,
    FOREIGN KEY (visitor_id) REFERENCES Visitor(id),
    FOREIGN KEY (museum_id) REFERENCES Museum(id),
    CONSTRAINT UC_Кatio PRIMARY KEY (visitor_id, museum_id)
);