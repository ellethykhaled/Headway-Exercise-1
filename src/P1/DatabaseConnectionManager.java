package P1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final String HOST_NAME = "localhost";
    private static final String DATABASE_NAME = "company";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "password";

    private final String url;
    private final Properties properties;

    DatabaseConnectionManager() {
        this.url = "jdbc:postgresql://" + HOST_NAME + "/" + DATABASE_NAME;
        this.properties = new Properties();
        properties.setProperty("user", USERNAME);
        properties.setProperty("password", PASSWORD);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, properties);
    }
}
