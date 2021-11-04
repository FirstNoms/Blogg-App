create database blogdb;

create user 'bloguser'@'localhost'identified by 'user111';
grant all privileges on blogdb.* to 'bloguser'@'localhost';
flush privileges;