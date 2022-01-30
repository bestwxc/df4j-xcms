create user if not exists xcms identified by '12345678';
create database if not exists xcms collate utf8mb4_bin;
grant all on xcms.* to xcms@'%';
flush privileges;
use xcms;