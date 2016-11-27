CREATE TABLE IF NOT EXISTS TEACHERS
(
    ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    NAME VARCHAR(40) NOT NULL,
    EXPERIENCE INTEGER
);

CREATE TABLE IF NOT EXISTS GROUPS
(
ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
NAME VARCHAR(20) NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS groups_name_uindex ON GROUPS (NAME);

CREATE TABLE IF NOT EXISTS STUDENTS
(
ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
NAME VARCHAR(40) NOT NULL,
GROUP_ID INTEGER,
CONSTRAINT STUDENTS_GROUPS_ID_FK FOREIGN KEY (GROUP_ID) REFERENCES GROUPS (ID)
);

CREATE TABLE IF NOT EXISTS SUBJECT_CATEGORYS
(
ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
TITLE VARCHAR(20) NOT NULL
);
CREATE UNIQUE INDEX IF NOT EXISTS subject_categorys_title_uindex ON SUBJECT_CATEGORYS (TITLE);

CREATE TABLE IF NOT EXISTS SUBJECTS
(
ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
NAME VARCHAR(20) NOT NULL,
CATEGORY_ID INTEGER,
DESCRIPTION CLOB,
CONSTRAINT SUBJECTS_SUBJECT_CATEGORYS_ID_FK FOREIGN KEY (CATEGORY_ID) REFERENCES SUBJECT_CATEGORYS (ID)
);
CREATE UNIQUE INDEX IF NOT EXISTS subjects_name_uindex ON SUBJECTS (NAME);


CREATE TABLE IF NOT EXISTS STUDY
(
    GROUP_ID INTEGER,
    SUBJECT_ID INTEGER,
    TEACHER_ID INTEGER,
    CONSTRAINT STUDY_GROUPS_ID_FK FOREIGN KEY (GROUP_ID) REFERENCES GROUPS (ID),
    CONSTRAINT STUDY_SUBJECTS_ID_FK FOREIGN KEY (SUBJECT_ID) REFERENCES SUBJECTS (ID),
    CONSTRAINT STUDY_TEACHERS_ID_FK FOREIGN KEY (TEACHER_ID) REFERENCES TEACHERS (ID)
);

INSERT INTO SUBJECT_CATEGORYS(ID, TITLE) VALUES (1,'Exact'),(2,'Humanities');
//INSERT INTO subjects(name, category_id, description) VALUES ('TestName', 1, 'TestDescription');