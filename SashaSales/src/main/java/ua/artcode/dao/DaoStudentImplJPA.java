package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.artcode.model.Group;
import ua.artcode.model.Student;
import ua.artcode.model.Teacher;
import ua.artcode.util.UtilsMethod;

import javax.persistence.*;
import java.util.List;

@Repository
public class DaoStudentImplJPA implements DaoStudent<Student> {

    @PersistenceContext
    private EntityManager entityManager;

    public DaoStudentImplJPA() {
    }

    @Override
    @Transactional
    public Student create(Student student) {

        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public boolean delete(String entity_name) {

        Student student = getEntityByName(entity_name, entityManager);
        entityManager.remove(student);
        return true;
    }

    @Override
    @Transactional
    public Student updateByGroup(String student_name, String group_name) {

        int idG = UtilsMethod.getIdOfGroup(group_name, entityManager);
        int idS = UtilsMethod.getIdOfStudent(student_name, entityManager);
        Student student = entityManager.find(Student.class, idS);
        Group group = entityManager.find(Group.class, idG);
        student.setGroup(group);

        return student;
    }

    @Override
    public Student findById(Object id) {

        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAll() {

        TypedQuery<Student> query = entityManager.createQuery("SELECT t FROM Student t", Student.class);
        return query.getResultList();
    }

    @Override
    public Student getEntityByName(String student_name) {

        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :student_name", Student.class);
        query.setParameter("student_name", student_name);
        return query.getSingleResult();
    }

    public Student getEntityByName(String student_name, EntityManager entityManager) {

        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :student_name", Student.class);
        query.setParameter("student_name", student_name);
        return query.getSingleResult();
    }


}
