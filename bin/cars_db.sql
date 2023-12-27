DROP DATABASE cars_db;
DROP USER cars;


CREATE DATABASE cars_db WITH TEMPLATE=template0;

\connect cars_db;



CREATE TABLE cars (
  car_id INTEGER PRIMARY KEY NOT NULL,
  make VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  body_type VARCHAR(255) NOT NULL,
  engine VARCHAR(255) NOT NULL,
  transmission VARCHAR(255) NOT NULL,
  drivetrain VARCHAR(255) NOT NULL,
  passengers INT NOT NULL,
  doors INT NOT NULL,
  fuel_type VARCHAR(255) NOT NULL,
  city_mpg FLOAT NOT NULL,
  highway_mpg FLOAT NOT NULL,
  price DECIMAL(10,2) NOT NULL
);

CREATE TABLE users (
  user_id INTEGER PRIMARY KEY NOT NULL,
  username VARCHAR(255) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE car_reviews (
  review_id INTEGER PRIMARY KEY NOT NULL,
  car_id INT NOT NULL,
  user_id INT NOT NULL,
  rating INT NOT NULL,
  review_text TEXT NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL,

  CONSTRAINT car_reviews_fk_car FOREIGN KEY (car_id) REFERENCES cars(car_id),
  CONSTRAINT car_reviews_fk_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE SEQUENCE cars_seq INCREMENT 1 START 1000;
CREATE SEQUENCE users_seq INCREMENT 1 START 1;
CREATE SEQUENCE car_reviews_seq INCREMENT 1 START 10000;
