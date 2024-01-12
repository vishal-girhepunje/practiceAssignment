CREATE DATABASE IF NOT EXISTS college;
DROP DATABASE IF EXISTS company;
SHOW DATABASES;
SHOW TABLES;
USE college;
-- -TABLE RELATED-- 
CREATE TABLE STUDENT(
id INT PRIMARY KEY,
name VARCHAR(50),
age INT NOT NULL
);

INSERT INTO student VALUES(101,"AMAN",20);
INSERT INTO student VALUES(102,"SRSDHAA",22);

-- Start All Operation-- 


CREATE TABLE student(
rollNo INT PRIMARY KEY,
name VARCHAR(50)
);


INSERT INTO student (rollNo, name) 
VALUES
(101,"karan"),
(102,"arjun"),
(103,"ram");
SELECT * FROM student;
DROP TABLE student;

INSERT INTO student (rollNo, name) 
VALUES
(104,"shyam");
-- single line entry-- 
INSERT INTO student  
VALUES
(105,"raju");

create database xyz_Employee;
use xyz_Employee;

CREATE TABLE employee(
id INT PRIMARY KEY,
name varchar(100),
salary int 
);
INSERT INTO employee(id, name, salary)
values
(1,"ADAM",2500),
(2,"bob",3000),
(3,"jew",3500);
select * from employee;
create database apnacollege;
use apnacollege;

create table student(
rollno INT PRIMARY KEY,
name varchar(50),
marks INT not null,
grade varchar(1),
city varchar(20)
);

insert into student (rollno, name, marks, grade, city)
values
(101, "Anil", 78, "C", "Pune"),
(102, "Bhumika", 93, "A", "Mumbai"),
(103, "chetan", 85, "B", "Mumbai"),
(104, "dhruv", 96, "A", "Delhi"),
(105, "emanuel", 12, "F", "Delhi"),
(106, "farah", 82, "B", "Delhi");


select name, marks from student;
select * from student;
select distinct city from student;

-- clauses--  
select * 
from student 
where 
marks>80;

select * 
from student 
where 
marks<=80;

select * 
from student 
where  
city="Mumbai"; 

select * 
from student 
where 
marks>80 and city="Mumbai";

-- OR-- 

select * 
from student 
where 
marks>80 && city="Mumbai";

-- you can right && / AND both are same.-- 

select * 
from student 
where 
marks+10>100;
-- OR / || operator-- 
select * 
from student
where
marks>90 || city="Mumbai";

select * 
from student
where
marks>90 or city="Mumbai";

-- Use of BETWEEN operator--  
select * 
from student
where
marks between 80 and 90;


-- IN Operator--
select * 
from student
where
city in("Mumbai", "Delhi"); 


-- Limit-- 
select * 
from student
limit 3; 

select * 
from student
where
marks>75
limit 3; 


-- ORDER-- 
select * from student
order by marks desc;

select * from student
order by city desc;

select * from student
order by grade;

-- Aggregate function--

select max(marks)
from student;

select avg(marks)
from student;  

select grade, count(rollno) 
from student
group by grade; 

-- HAVING CLause--  
SELECT city
FROM student
WHERE grade="A"
GROUP BY city
HAVING MAX(marks)>=93
ORDER BY city DESC;

SELECT *FROM student;
-- tableREALATED QUERIES-- 
set sql_safe_updates=0;


update student
set grade="O"
where grade="A";


UPDATE student
SET grade = "O"
WHERE grade = "A";

UPDATE student
SET marks = 12
WHERE rollno = 105;


UPDATE student
SET grade = "C"
WHERE marks between 60 and 80;

SELECT *FROM student;

DELETE from student
where marks<33;

--  Alter Queries-- 

alter table student
add column age int not null default 19;
 
alter table student
drop column age;

alter table stu
rename to student;

alter table student
change column namE name varchar(50);

select * from student;






create database ForignKey;
use ForignKey;

create table dept(
id int primary key,
name varchar(50)
);

insert into dept
values
(101, "english"),
(102, "IT");

update dept
set id=103
where id=102;

update dept
set id=111
where id=101;

select * from dept;

create table teacher (
id int primary key,
name varchar(50),
dept_id int,
foreign key (dept_id) references dept (id)
on update cascade
on delete cascade
);
Drop table teacher;
insert into teacher
values
(101, "Adam", 101),
(102, "Bob", 102);

select * from teacher;