create database stm_db; 	

use stm_db; 				

create user 'stm_user'@'localhost' identified by 'qwe123';

grant
CREATE, DROP, ALTER, SELECT, UPDATE, INSERT, DELETE, REFERENCES
on spring_rest_api_.*
to 'stm_user'@'localhost';