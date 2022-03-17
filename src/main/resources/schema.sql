DROP TABLE IF EXISTS users;

CREATE TABLE users (
                   id bigint(20) AUTO_INCREMENT  PRIMARY KEY,
                   username VARCHAR(20) NOT NULL UNIQUE,
                   email VARCHAR(50) NOT NULL UNIQUE,
                   password VARCHAR(120) NOT NULL
);

DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
                       id int(11) AUTO_INCREMENT  PRIMARY KEY,
                       name VARCHAR(20) NOT NULL
);

-- DROP TABLE IF EXISTS user_roles;
--
-- CREATE TABLE user_roles (
--                        user_id bigint(20) PRIMARY KEY,
--                        role_id int(11) PRIMARY KEY
-- );