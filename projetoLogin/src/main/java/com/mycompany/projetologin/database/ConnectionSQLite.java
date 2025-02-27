package com.mycompany.projetologin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {
    public Connection connect() {
        Connection connection = null;

        String url = "jdbc:sqlite:users.db";

        try {
            connection = DriverManager.getConnection(url);
            System.out.println(" Success to connect to SQLite database!");
        } catch (SQLException e) {
            System.out.println(" Connection ERROR: " + e.getMessage());
        }

        return connection;
    }

    public void disconnect(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException e) {
            System.out.println("ERROR to close connection " + e.getMessage());
        }
    }
}
