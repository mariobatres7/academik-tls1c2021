package edu.telus.web.jdbc.servicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mario Batres
 */
public class ConexionDBSingleton {

    private static final String URL = "jdbc:mariadb://localhost:3306/db1C2021";

    private static final String USER = "root";

    private static final String PASSWORD = "felicia";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {            
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            }
            return connection;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

}
