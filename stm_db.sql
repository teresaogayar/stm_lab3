create database stm_db; 	

use stm_db; 				

create user 'stm_user'@'localhost' identified by 'qwe123';

grant
CREATE, DROP, ALTER, SELECT, UPDATE, INSERT, DELETE, REFERENCES
on stm_db.*
to 'stm_user'@'localhost';
