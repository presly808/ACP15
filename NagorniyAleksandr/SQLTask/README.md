# University
## (JDBC task form ArtCode)

### This program provides API for working with the simple data base of MySQL.

### List of supported functionality(task requirements)
+ Get list of all students, groups, subjects, teachers
+ Add student, group, subject,teacher
+ Update the information on the database entities (eg the student has changed the group or name)
+ Get list of a particular group of students
+ Find out which groups are studying math
+ Find out which subjects is studying by all groups
+ Find teacher who have the least and the most experience
+ Find teachers with teach experience more than 3 years
+ Get list of humanitarian subjects

#### Used Objects:
+ Group
+ Student
+ Study
+ Subject
+ SubjectCategory
+ Teacher

#### PROJECT REQUIREMENTS:
+ SOFTWARE
++ JDK 1.8
++ MySQL Server

+LIBS(DEPENDENCY)
++ MySQL-Connector v.6.0.5
++ H2Database v.1.4.193
++ Log4j v.1.2.17
++ JUnit v.4.12
++ Mockito-Core v.2.2.22

#### RUN PROGRAM:
for running program run:
+ API - PROJECT_FOLDER/src/main/java/university/service/Service.java
+ RUN(form manual testing API) - PROJECT_FOLDER/SQLTask/src/main/java/TestRun.java
+ TESTs - PROJECT_FOLDER/SQLTask/src/test/*



