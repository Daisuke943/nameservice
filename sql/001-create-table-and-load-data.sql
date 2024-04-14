DROP TABLE IF EXISTS users;

CREATE TABLE users (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(20) NOT NULL,
 email VARCHAR(40) NOT NULL,
 PRIMARY KEY(id)
);
INSERT INTO users (name,email) VALUES ('john','john@example.com');
INSERT INTO users (name,email) VALUES ('mike','mike@example.com');



