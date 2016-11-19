CREATE TABLE students (id int not null, name varchar(20), id_Group int, PRIMARY KEY (id));
CREATE TABLE Group_students(id_Group int, name varchar(20),PRIMARY KEY (id_Group));
CREATE TABLE Subject(id_Subject int, name varchar(20),description varchar(100),PRIMARY KEY (id_Subject));
CREATE TABLE teacher(id_teacher int, name varchar(20),experience int, id_Subject int, PRIMARY KEY (id_teacher));
CREATE TABLE Study_process(id int, id_Group int, id_Subject int, mark int);

INSERT INTO students VALUES(11,'Bogdan',1);
INSERT INTO students VALUES(21,'Andrey',1);
INSERT INTO students VALUES(31,'Ivan',2);
INSERT INTO students VALUES(41,'Peter',2);
INSERT INTO students VALUES(51,'Kiril',2);
INSERT INTO students VALUES(61,'Vanya',3);
INSERT INTO students VALUES(71,'Sergii',1);
INSERT INTO students VALUES(81,'Taras',3);
INSERT INTO students VALUES(91,'Sasha',2);
INSERT INTO students VALUES(101,'Leonid',1);


INSERT INTO Group_students VALUES (1,'APC_1');
INSERT INTO Group_students VALUES (2,'APC_2');
INSERT INTO Group_students VALUES (3,'APC_3');

INSERT INTO Subject VALUES (401,'Math' 'mathematics');
INSERT INTO Subject VALUES (402,'Prog' 'programming');
INSERT INTO Subject VALUES (403,'Liter' 'literature');
INSERT INTO Subject VALUES (404,'Eng' 'english');



INSERT INTO teacher VALUES (1001,'Kiril', 5,402);
INSERT INTO teacher VALUES (1002,'Taras', 4,401);
INSERT INTO teacher VALUES (1003,'Sasha', 10,404);
INSERT INTO teacher VALUES (1004,'Leonid', 6,403);


INSERT INTO Study_process VALUES (11,1,401,97);
INSERT INTO Study_process VALUES (11,1,402,75);
INSERT INTO Study_process VALUES (11,1,403,94);
INSERT INTO Study_process VALUES (11,1,404,90);

INSERT INTO Study_process VALUES (21,1,401,44);
INSERT INTO Study_process VALUES (21,1,402,66);
INSERT INTO Study_process VALUES (21,1,403,36);
INSERT INTO Study_process VALUES (21,1,404,94);


INSERT INTO Study_process VALUES (31,2,401,78);
INSERT INTO Study_process VALUES (31,2,402,66);
INSERT INTO Study_process VALUES (31,2,403,57);
INSERT INTO Study_process VALUES (31,2,404,90);

INSERT INTO Study_process VALUES (41,2,401,46);
INSERT INTO Study_process VALUES (41,2,402,67);
INSERT INTO Study_process VALUES (41,2,403,89);
INSERT INTO Study_process VALUES (41,2,404,95);

INSERT INTO Study_process VALUES (61,3,401,68);
INSERT INTO Study_process VALUES (61,3,402,45);
INSERT INTO Study_process VALUES (61,3,403,80);
INSERT INTO Study_process VALUES (61,3,404,95);

INSERT INTO Study_process VALUES (101,3,401,46);
INSERT INTO Study_process VALUES (101,3,402,57);
INSERT INTO Study_process VALUES (101,3,403,49);
INSERT INTO Study_process VALUES (101,3,404,97);




