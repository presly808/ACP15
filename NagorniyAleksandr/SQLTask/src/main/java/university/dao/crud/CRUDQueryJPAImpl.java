package university.dao.crud;

import org.apache.log4j.Logger;
import university.exceptions.AppDBException;
import university.models.Group;
import university.models.Student;
import university.models.Subject;
import university.models.Teacher;

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
            factory.close();
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
            factory.close();
        }

        return true;
    }

    @Override
    public boolean addSubject(Subject subject) throws AppDBException {
        LOGGER.info("Add subject");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

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
            factory.close();
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
            factory.close();
        }

        return true;
    }

    @Override
    public boolean editStudent(Student studentWithNewData) throws AppDBException {
        return false;
    }

    @Override
    public boolean editGroup(Group groupWithNewData) throws AppDBException {
        return false;
    }

    @Override
    public boolean editTeacher(Teacher teacherWithNewData) throws AppDBException {
        return false;
    }

    @Override
    public boolean editSubject(Subject subjectWithNewData) throws AppDBException {
        return false;
    }

    @Override
    public boolean deleteStudent(Student student) throws AppDBException {
        LOGGER.info("Delete student");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        student = manager.find(Student.class, student.getId());

        try {
            transaction.begin();
            manager.remove(student);
            transaction.commit();
            LOGGER.info("Student was deleted to DB");
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
    public boolean deleteGroup(Group group) throws AppDBException {
        LOGGER.info("Delete group");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        group = manager.find(Group.class, group.getId());

        try {
            transaction.begin();
            manager.remove(group);
            transaction.commit();
            LOGGER.info("Group was deleted to DB");
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
    public boolean deleteTeacher(Teacher teacher) throws AppDBException {
        LOGGER.info("Delete teacher");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        teacher = manager.find(Teacher.class, teacher.getId());

        try {
            transaction.begin();
            manager.remove(teacher);
            transaction.commit();
            LOGGER.info("Teacher was deleted to DB");
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
    public boolean deleteSubject(Subject subject) throws AppDBException {
        LOGGER.info("Delete subject");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        subject = manager.find(Subject.class, subject.getId());

        try {
            transaction.begin();
            manager.remove(subject);
            transaction.commit();
            LOGGER.info("Subject was deleted to DB");
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
    public Student getStudent(Student student) throws AppDBException {
        return null;
    }

    @Override
    public Group getGroup(Group group) throws AppDBException {
        return null;
    }

    @Override
    public Teacher getTeacher(Teacher teacher) throws AppDBException {
        return null;
    }

    @Override
    public Subject getSubject(Subject subject) throws AppDBException {
        return null;
    }
}
