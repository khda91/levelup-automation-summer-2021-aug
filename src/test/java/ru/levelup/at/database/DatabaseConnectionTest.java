package ru.levelup.at.database;

import static org.testng.Assert.assertFalse;

import java.sql.Connection;
import java.sql.SQLException;
import org.testng.annotations.Test;
import ru.levelup.at.datadase.PostgresqlDatabaseConnection;

public class DatabaseConnectionTest {

    @Test
    public void testDatabaseConnection() {
        Connection connection = null;
        try {
            connection = PostgresqlDatabaseConnection.getInstance().getConnection();
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
