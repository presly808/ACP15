package jdbcmySql.model;

/**
 * Created by lost on 19.11.2016.
 */
public class Constants {
    public static final String SQLSELECT1 = "Select * from students";
    public static final String SQLSELECT2 = "Select * from Group_students";
    public static final String SQLSELECT3 = "Select * from Subject";
    public static final String SQLSELECT4 = "Select * from teacher";
    public static final String SQLINSERT1 = "INSERT INTO students values (?,?,?)";
    public static final String SQLINSERT2 = "INSERT INTO Group_students values (?,?)";
    public static final String SQLINSERT3 = "INSERT INTO Subject values (?,?,?)";
    public static final String SQLINSERT4 = "INSERT INTO teacher values (?,?,?,?)";
    public static final String SQLSTUDENTSBYGROUP = "Select * from students where id_Group=?";

}
