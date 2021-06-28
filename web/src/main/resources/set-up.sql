drop user if exists 'estore'@'localhost';

create user 'estore'@'localhost' identified by 'estore123';
grant all privileges on estore_db.* to 'estore'@'localhost';
flush privileges;

drop database if exists estore_db;

create database estore_db;