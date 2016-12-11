package converter;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Imant on 30.11.16.
 */
public class ResultSetToUpdatedIdConverter {

    public static int getUpdatedIdByResultSet(ResultSet generatedKeysResultSet) {
        try {
            if (generatedKeysResultSet.next()) {
                return generatedKeysResultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
