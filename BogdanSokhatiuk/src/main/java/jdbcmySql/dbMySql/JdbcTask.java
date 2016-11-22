package jdbcmySql.dbMySql;


import jdbcmySql.annotation.SqlDB;
import jdbcmySql.model.Group;
import jdbcmySql.model.Student;
import jdbcmySql.model.Subject;
import jdbcmySql.model.Teacher;
import jdbcmySql.utils.PropertiesHolder;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static jdbcmySql.model.SqlScripts.*;


public class JdbcTask<T> {
    private T t;
    private static final Logger LOG = Logger.getLogger(PropertiesHolder.class);

    public List<T> getAll(Class cl) {
        if (cl.equals(Student.class)) return getAllfromBase(cl, SQLSELECT1);
        if (cl.equals(Group.class)) return getAllfromBase(cl, SQLSELECT2);
        if (cl.equals(Subject.class)) return getAllfromBase(cl, SQLSELECT3);
        if (cl.equals(Teacher.class)) return getAllfromBase(cl, SQLSELECT4);
        else return null;
    }

    private List<T> getAllfromBase(Class cl, String sql) {
        Field[] fields = cl.getDeclaredFields();
        Object obj = null;
        List list = new ArrayList<>();
        JdbcBush jdbcBush = new JdbcBushIpml();
        ResultSet resultSet = null;
        try {
            obj = cl.newInstance();
        } catch (InstantiationException e) {
            LOG.error(e);
        } catch (IllegalAccessException e) {
            LOG.error(e);
        }
        try {
            resultSet = jdbcBush.sqlSelect(sql);

            while (resultSet.next()) {

                for (int i = 0; i < fields.length; i++) {

                    fields[i].setAccessible(true);
                    if (fields[i].isAnnotationPresent(SqlDB.class)) {
                        if (fields[i].getType().isPrimitive()) {
                            try {
                                fields[i].set(obj, resultSet.getInt(i + 1));
                            } catch (IllegalAccessException e) {
                                LOG.error(e);;
                            }
                        } else {
                            try {
                                fields[i].set(obj, resultSet.getString(i + 1));
                            } catch (IllegalAccessException e) {
                                LOG.error(e);
                            }
                        }
                    }
                }
                list.add((T) obj);
            }
            jdbcBush.closeConnection();
        } catch (SQLException e) {
            LOG.error(e);
        }
        return list;
    }

    public boolean insert(Object obj) {
        if (obj.getClass().equals(Student.class)) return insertToDataBase(obj, SQLINSERT1);
        if (obj.getClass().equals(Group.class)) return insertToDataBase(obj, SQLINSERT2);
        if (obj.getClass().equals(Subject.class)) return insertToDataBase(obj, SQLINSERT3);
        if (obj.getClass().equals(Teacher.class)) return insertToDataBase(obj, SQLINSERT4);
        else return false;
    }

    public List<Student> getAllstudentsByGroup(Integer group) {
        List<Student> list = new ArrayList<>();
        Student obj = new Student();
        Class cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();
        Connection con = new SqlConnection().getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement(SQLSTUDENTSBYGROUP)) {
            preparedStatement.setInt(1, group);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {

                for (int i = 0; i < fields.length; i++) {

                    fields[i].setAccessible(true);
                    if (fields[i].isAnnotationPresent(SqlDB.class)) {
                        if (fields[i].getType().isPrimitive()) {
                            try {
                                fields[i].set(obj, resultSet.getInt(i + 1));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                fields[i].set(obj, resultSet.getString(i + 1));
                            } catch (IllegalAccessException e) {
                                LOG.error(e);
                            }
                        }
                    }
                }
                list.add(obj);

            }
            con.close();
        } catch (SQLException e) {
            LOG.error(e);
        }

        return list;
    }


    private boolean insertToDataBase(Object obj, String sql) {
        Class cl = obj.getClass();
        Field[] field = cl.getDeclaredFields();
        Connection con = new SqlConnection().getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            for (int i = 0; i < field.length; i++) {

                field[i].setAccessible(true);
                if (field[i].isAnnotationPresent(SqlDB.class)) {
                    if (field[i].getType().isPrimitive())
                        preparedStatement.setInt(i + 1, field[i].getInt(obj));
                    else preparedStatement.setString(i + 1, (String) field[i].get(obj));
                }
            }
            boolean result = preparedStatement.execute();
            con.close();
            return result;

        } catch (SQLException e) {
            LOG.error(e);
        } catch (IllegalAccessException e) {
            LOG.error(e);
        }
        return false;
    }

}