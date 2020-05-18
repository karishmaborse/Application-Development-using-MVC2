use student;
create table users (
 sl_no  varchar(15) unique,
user_name varchar(24),
email_id varchar(60),
mobile varchar(12),
PRIMARY KEY (sl_no));


create table recovered(
sl_no varchar(15),
user_name varchar(24));

select * from student.users;

select * from student.recovered;


