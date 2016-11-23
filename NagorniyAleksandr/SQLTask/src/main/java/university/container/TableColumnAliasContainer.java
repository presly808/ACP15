package university.container;

import university.dao.QueryCreatorImpl;
import university.dao.crud.CRUDQueryImpl;
import university.jdbc.DBConnectorImpl;
import university.service.Service;
import university.service.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class TableColumnAliasContainer {

    public static final Map<String, String> aliasMap = new HashMap<>();

    static {
        aliasMap.put("students.id", "studentId");
        aliasMap.put("students.name", "studentName");
        aliasMap.put("students.group_id", "studentGroupId");

        aliasMap.put("groups.id", "groupId");
        aliasMap.put("groups.name", "groupName");

        aliasMap.put("subjects.id", "subjectId");
        aliasMap.put("subjects.name", "subjectName");
        aliasMap.put("subjects.category_id", "subjectCategoryId");
        aliasMap.put("subjects.description", "subjectDescription");

        aliasMap.put("subject_categorys.id", "categoryId");
        aliasMap.put("subject_categorys.title", "categoryTitle");

        aliasMap.put("teachers.id", "teacherId");
        aliasMap.put("teachers.name", "teacherName");
        aliasMap.put("teachers.experience", "teacherExperience");
    }

    public static String getColumnNameWithAlias(String columnName){
        String alias = aliasMap.get(columnName);
        if (alias == null) throw new NullPointerException(
                "Column name:" + columnName + "haven't defined alias");

        return columnName + " AS " + alias;
    }

    public static String getColumnAlias(String columnName){
        String alias = aliasMap.get(columnName);
        if (alias == null) throw new NullPointerException(
                "Column name:" + columnName + "haven't defined alias");

        return alias;
    }
}
