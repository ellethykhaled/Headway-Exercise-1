package P1;

import java.sql.Connection;
import java.sql.SQLException;

public class Problem1 {

    public static void main(String... args) {
        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();

        try {
            Connection connection = databaseConnectionManager.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
