#Mysql db used, Initial setup for databases and table in local machine by running sql command

CREATE DATABASE demo1;

#Create table , if there is a problem suffix table as demo1.user
CREATE TABLE user(id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR (50), last_name VARCHAR(50));

#Insert two rows
INSERT into user(first_name, last_name) VALUES ('Wayne', 'Rooney');
INSERT into user(first_name, last_name) VALUES ('Maxine', 'Johnson');

