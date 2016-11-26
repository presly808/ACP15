package jpabush.dao;


import jpabush.model.Student;

import javax.persistence.EntityManager;

public class StudentDao extends GeneralDao<Student>{

    public StudentDao(EntityManager manager, Class<Student> studentClass) {
        super(manager, studentClass);
    }

}