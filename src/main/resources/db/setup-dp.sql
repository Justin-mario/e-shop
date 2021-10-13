create database shopdb;

create user 'shop_user'@'localhost' identified by 'shop123';
grant all privileges on shopdb.* to 'shop_user'@'localhost';
flush privileges;