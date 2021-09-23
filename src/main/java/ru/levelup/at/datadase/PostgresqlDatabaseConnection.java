package ru.levelup.at.datadase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class PostgresqlDatabaseConnection {

    private static PostgresqlDatabaseConnection instance;

    private Connection connection;

    private Properties dbProperties;

    private PostgresqlDatabaseConnection() {
        dbProperties = new Properties();
        try {
            dbProperties.load(this.getClass().getClassLoader().getResourceAsStream("database/db.properties"));
        } catch (IOException e) {
            System.err.println("Unable to read db connection properties file");
            e.printStackTrace();
            return;
        }
    }

    public static PostgresqlDatabaseConnection getInstance() {
        if (instance == null) {
            instance = new PostgresqlDatabaseConnection();
            instance.createConnection();
        }
        return instance;
    }

    private void createConnection() {
        try {
            connection = DriverManager.getConnection(dbProperties.getProperty("postgresql.url"),
                    dbProperties.getProperty("postgresql.username"), dbProperties.getProperty("postgresql.password"));
        } catch (SQLException throwables) {
            throw new RuntimeException("Connection failed", throwables);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
