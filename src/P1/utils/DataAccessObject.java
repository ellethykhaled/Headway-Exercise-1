package P1.utils;

import java.sql.Connection;

public abstract class DataAccessObject {

    protected final Connection connection;

    public DataAccessObject(Connection connection) {
        super();
        this.connection = connection;
    }
}
