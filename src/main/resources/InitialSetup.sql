#Mysql db used, Initial setup for databases and table in local machine by running sql command

CREATE DATABASE demo1;

#Create table , if there is a problem suffix table as demo1.user
CREATE TABLE user(id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR (50), last_name VARCHAR(50));

#Insert two rows
INSERT into user(first_name, last_name) VALUES ('Wayne', 'Rooney');
INSERT into user(first_name, last_name) VALUES ('Maxine', 'Johnson');

CREATE TABLE dept(dept_id INT NOT NULL AUTO_INCREMENT, dept_name VARCHAR(50),
    dept_desc VARCHAR(50) , Userid INT, PRIMARY KEY(dept_id), FOREIGN KEY(Userid) REFERENCES user (id));

INSERT into dept (dept_id, dept_name, dept_desc, Userid)values (100, "History", "WorldWar-1", 1);
INSERT into dept (dept_id, dept_name, dept_desc, Userid)values (101, "History", "WorldWar-2", 1);

