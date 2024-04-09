DROP TABLE IF EXISTS names;

CREATE TABLE names (
 id int unsigned AUTO_INCREMENT,
 name VARCHAR(20) NOT NULL,
 PRIMARY KEY(id)
);
INSERT INTO names (name) VALUES ('name1');
INSERT INTO names (name) VALUES ('name2');
INSERT INTO names (name) VALUES ('john');
INSERT INTO names (name) VALUES ('mike');



