package ru.levelup.at.database;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.datadase.PostgresqlDatabaseConnection;
import ru.levelup.at.datadase.model.UserTableModel;

public class DatabaseSelectQueryTest {

    private Connection connection;

    @BeforeMethod
    public void setUp() {
        connection = PostgresqlDatabaseConnection.getInstance().getConnection();
    }

    @Test
    public void testSelectData() {
        Statement statement = null;

        try {
            statement = connection.createStatement();
            final String selectQuery = "SELECT * FROM user_table";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString("name");
                String email = resultSet.getString(3);

                System.out.println(String.format("id = %d | name = %s | email = %s", id, name, email));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testPreparedSelectData() {
        PreparedStatement statement = null;

        try {
            final String selectQuery = "SELECT * FROM user_table WHERE id = ?";
            statement = connection.prepareStatement(selectQuery);
            statement.setInt(1, 2);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString("name");
                String email = resultSet.getString(3);

                System.out.println(String.format("id = %d | name = %s | email = %s", id, name, email));
                assertEquals(id.longValue(), Long.parseLong("2"));
                assertEquals(name, "emma");
                assertEquals(email, "emma@ya.ru");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testObjectSelectData() {
        PreparedStatement statement = null;
        UserTableModel expected = new UserTableModel(2L, "emma", "emma@ya.ru");
        UserTableModel actual = null;

        try {
            final String selectQuery = "SELECT * FROM user_table WHERE id = ?";
            statement = connection.prepareStatement(selectQuery);
            statement.setInt(1, 2);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString("name");
                String email = resultSet.getString(3);

                actual = new UserTableModel(id, name, email);

                System.out.println(actual);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        assertThat(actual)
            .as("Incorrect data was retrieved from database")
            .isEqualTo(expected);
    }

    @AfterMethod
    public void tearDown() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
