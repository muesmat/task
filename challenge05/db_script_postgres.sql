CREATE DATABASE tasks_db;

CREATE TABLE task (
  id SERIAL PRIMARY KEY,
  title VARCHAR (50)  NOT NULL,
  description VARCHAR (200),
  status VARCHAR (10) NOT NULL,
  priority VARCHAR (10) NOT NULL,
  due_date timestamp NOT NULL,
  created_at timestamp,
  updated_at timestamp
);

CREATE TABLE "user" (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR (50)  NOT NULL,
  last_name VARCHAR (50) NOT NULL,
  email VARCHAR (100) NOT NULL UNIQUE,
  password VARCHAR (100) NOT NULL,
  role VARCHAR (10) NOT NULL,
  created_at timestamp,
  updated_at timestamp
);


