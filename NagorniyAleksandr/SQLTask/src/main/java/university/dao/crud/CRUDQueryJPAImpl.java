package university.dao.crud;

import org.apache.log4j.Logger;
import university.exceptions.AppDBException;
import university.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


public class CRUDQueryJPAImpl implements CRUDQuery {


    private static final Logger LOGGER = Logger.getLogger(CRUDQueryJPAImpl.class);

    private EntityManagerFactory factory;

    public CRUDQueryJPAImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public boolean addStudent(Student student) throws AppDBException {
        LOGGER.info("Add student");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(student);
            transaction.commit();
            LOGGER.info("Student was saved to DB");
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }

        return true;
    }

    @Override
    public boolean addGroup(Group group) throws AppDBException {
        LOGGER.info("Add group");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(group);
            transaction.commit();
            LOGGER.info("Group was saved to DB");
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }

        return true;
    }

    @Override
    public boolean addSubject(Subject subject) throws AppDBException {
        LOGGER.info("Add subject");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

/*        SubjectCategory subjectCategory = subject.getCategory();
        manager.find(SubjectCategory.class, subjectCategory.getId());*/
        try {
            transaction.begin();
            manager.persist(subject);
            transaction.commit();
            LOGGER.info("Subject was saved to DB");
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }

        return true;
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws AppDBException {
        LOGGER.info("Add teacher");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(teacher);
            transaction.commit();
            LOGGER.info("Teacher was saved to DB");
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }

        return true;
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws AppDBException {
        LOGGER.info("Edit student");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        if (manager.find(Student.class, studentWithNewData.getId()) == null) {
            manager.close();
            String errorMessage = "Student not found";
            LOGGER.error(errorMessage);
            throw new AppDBException(errorMessage);
        }

        try {
            transaction.begin();
            manager.merge(studentWithNewData);
            transaction.commit();
            LOGGER.info("Student was edited");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws AppDBException {
        LOGGER.info("Edit group");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();


        if (manager.find(Group.class, groupWithNewData.getId()) == null) {
            manager.close();
            String errorMessage = "Group not found";
            LOGGER.error(errorMessage);
            throw new AppDBException(errorMessage);
        }

        try {
            transaction.begin();
            manager.merge(groupWithNewData);
            transaction.commit();
            LOGGER.info("Group was edited");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws AppDBException {
        LOGGER.info("Edit teacher");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        if (manager.find(Teacher.class, teacherWithNewData.getId()) == null) {
            manager.close();
            String errorMessage = "Teacher not found";
            LOGGER.error(errorMessage);
            throw new AppDBException(errorMessage);
        }

        try {
            transaction.begin();
            manager.merge(teacherWithNewData);
            transaction.commit();
            LOGGER.info("Teacher was edited");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws AppDBException {
        LOGGER.info("Edit subject");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        if (manager.find(Subject.class, subjectWithNewData.getId()) == null) {
            manager.close();
            String errorMessage = "Subject not found";
            LOGGER.error(errorMessage);
            throw new AppDBException(errorMessage);
        }

        try {
            transaction.begin();
            manager.merge(subjectWithNewData);
            transaction.commit();
            LOGGER.info("Subject was edited");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean deleteStudent(Student student) throws AppDBException {
        LOGGER.info("Delete student");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Student tempStudent = manager.find(Student.class, student.getId());
        if (tempStudent == null) {
            manager.close();
            String errorMessage = "Student not found";
            LOGGER.error(errorMessage);
            throw new AppDBException(errorMessage);
        }

        try {
            transaction.begin();
            manager.remove(tempStudent);
            transaction.commit();
            LOGGER.info("Student was deleted from DB");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean deleteGroup(Group group) throws AppDBException {
        LOGGER.info("Delete group");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Group tempGroup = manager.find(Group.class, group.getId());
        if (tempGroup == null) {
            manager.close();
            String errorMessage = "Group not found";
            LOGGER.error(errorMessage);
            throw new AppDBException(errorMessage);
        }

        try {
            transaction.begin();
            manager.remove(tempGroup);
            transaction.commit();
            LOGGER.info("Group was deleted from DB");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean deleteTeacher(Teacher teacher) throws AppDBException {
        LOGGER.info("Delete teacher");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Teacher tempTeacher = manager.find(Teacher.class, teacher.getId());
        if (tempTeacher == null) {
            manager.close();
            String errorMessage = "Teacher not found";
            LOGGER.error(errorMessage);
            throw new AppDBException(errorMessage);
        }

        try {
            transaction.begin();
            manager.remove(tempTeacher);
            transaction.commit();
            LOGGER.info("Teacher was deleted from DB");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }
    }

    @Override
    public boolean deleteSubject(Subject subject) throws AppDBException {
        LOGGER.info("Delete subject");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Subject tempSubject = manager.find(Subject.class, subject.getId());
        if (tempSubject == null) {
            manager.close();
            String errorMessage = "Subject not found";
            LOGGER.error(errorMessage);
            throw new AppDBException(errorMessage);
        }

        try {
            transaction.begin();
            manager.remove(tempSubject);
            transaction.commit();
            LOGGER.info("Subject was deleted from DB");
            return true;
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage() + ". Throw: AppDBException");
            throw new AppDBException(e.getMessage());
        } finally {
            manager.close();
        }
    }

    @Override
    public Student getStudent(Student student) throws AppDBException {
        LOGGER.info("Get student");
        EntityManager manager = factory.createEntityManager();

        Student foundedStudent = manager.find(Student.class, student.getId());
        if (foundedStudent != null) {
            manager.close();
            LOGGER.info("Student founded successful");
            return foundedStudent;
        } else {
            manager.close();
            String errorMessage = "Student not found";
            LOGGER.error(errorMessage + ". Throw: AppDBException");
            throw new AppDBException(errorMessage);
        }
    }

    @Override
    public Group getGroup(Group group) throws AppDBException {
        LOGGER.info("Get group");
        EntityManager manager = factory.createEntityManager();


        Group foundedGroup = manager.find(Group.class, group.getId());
        if (foundedGroup != null) {
            manager.close();
            LOGGER.info("Group founded successful");
            return foundedGroup;
        } else {
            manager.close();
            String errorMessage = "Group not found";
            LOGGER.error(errorMessage + ". Throw: AppDBException");
            throw new AppDBException(errorMessage);
        }
    }

    @Override
    public Teacher getTeacher(Teacher teacher) throws AppDBException {
        LOGGER.info("Get teacher");
        EntityManager manager = factory.createEntityManager();


        Teacher foundedTeacher = manager.find(Teacher.class, teacher.getId());
        if (foundedTeacher != null) {
            manager.close();
            LOGGER.info("Teacher founded successful");
            return foundedTeacher;
        } else {
            manager.close();
            String errorMessage = "Teacher not found";
            LOGGER.error(errorMessage + ". Throw: AppDBException");
            throw new AppDBException(errorMessage);
        }
    }

    @Override
    public Subject getSubject(Subject subject) throws AppDBException {
        LOGGER.info("Get subject");
        EntityManager manager = factory.createEntityManager();

        Subject foundedSubject = manager.find(Subject.class, subject.getId());
        if (foundedSubject != null) {
            manager.close();
            LOGGER.info("Subject founded successful");
            return foundedSubject;
        } else {
            manager.close();
            String errorMessage = "Subject not found";
            LOGGER.error(errorMessage + ". Throw: AppDBException");
            throw new AppDBException(errorMessage);
        }
    }
}
