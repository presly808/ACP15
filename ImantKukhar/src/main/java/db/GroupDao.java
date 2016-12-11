package db;

import converter.ResultSetToUpdatedIdConverter;
import converter.ResultSetToObjectConverter;
import converter.ResultSetToObjectListConverter;
import model.Group;
import model.Subject;
import utils.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imant on 30.11.16.
 */
public class GroupDao {

    private static GroupDao instance;

    public static final String ADD_NEW_GROUP_PREPARED_STATEMENT = "INSERT INTO groups (group_Name) VALUES (?)";
    public static final String DELETE_GROUP_PREPARED_STATEMENT = "DELETE FROM groups WHERE id = ?";
    public static final String GET_GROUP_PREPARED_STATEMENT = "SELECT groups.id, groups.group_Name FROM groups WHERE groups.id = ?";
    public static final String EDIT_GROUP_PREPARED_STATEMENT = "UPDATE groups SET group_Name = ? WHERE id = ?";
    public static final String GET_GROUPS_LIST = "SELECT * FROM groups LIMIT ? OFFSET ?";
    public static final String GET_GROUPS_LIST_BY_SUBJECT = "SELECT groups.id, groups.group_Name FROM groups " +
            "INNER JOIN studying ON groups.id = studying.group_id WHERE studying.subject_id = ?";


    public static GroupDao getInstance() {
        if (instance == null)
            instance = new GroupDao();
        return instance;
    }

    public boolean addNewGroup(Group group) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (ADD_NEW_GROUP_PREPARED_STATEMENT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, group.getName());
            preparedStatement.execute();

            int updatedId = ResultSetToUpdatedIdConverter.getUpdatedIdByResultSet(preparedStatement.getGeneratedKeys());
            if (updatedId != 0) {
                group.setId(updatedId);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteGroup(Group group) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GROUP_PREPARED_STATEMENT)) {

            preparedStatement.setInt(1, group.getId());
            if (preparedStatement.executeUpdate() != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Group getGroup(Group group) {
        Group gettingGroup = new Group();
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_GROUP_PREPARED_STATEMENT)) {

            preparedStatement.setInt(1, group.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            gettingGroup = ResultSetToObjectConverter.convertResultSetToGroup(resultSet);

            System.out.println(gettingGroup.toString());
            //перевірка на null

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gettingGroup;
    }

    public boolean editGroup(Group updatedGroup) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_GROUP_PREPARED_STATEMENT)) {

            preparedStatement.setString(1, updatedGroup.getName());
            preparedStatement.setInt(2, updatedGroup.getId());

            if (preparedStatement.executeUpdate() != 0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Group> getGroupsList(int limit, int offset) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_GROUPS_LIST)) {

            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);

            ResultSet resultSet = preparedStatement.executeQuery();
            return ResultSetToObjectListConverter.getGroupsListFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Group> returnSmth = new ArrayList<>();
        return returnSmth;
    }

    public List<Group> getGroupsListBySubject(Subject subject) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_GROUPS_LIST_BY_SUBJECT)) {

            preparedStatement.setInt(1, subject.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            return ResultSetToObjectListConverter.getGroupsListFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Group> returnSmth = new ArrayList<>();
        return returnSmth;
    }
}
