-- データベース作成
-- ==============================================================
drop database if exists user_register_sc;
GRANT USAGE ON *.* TO 'user_register_sc'@'localhost';
DROP USER 'user_register_sc'@'localhost';

create database user_register_sc character set utf8mb4;
create user 'user_register_sc'@'localhost' identified by 'user_register_sc';
grant all privileges on user_register_sc.* to 'user_register_sc'@'localhost';
-- ==============================================================