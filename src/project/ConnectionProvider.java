package project;

import java.sql.*;

public class ConnectionProvider {
    private static final String URL = "jdbc:mysql://localhost:3306/gms";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    /**
     * Returns a database connection. Throws SQLException if connection fails.
     *
     * @return A connection to the database
     * @throws SQLException If a database access error occurs
     */
    public static Connection getCon() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // This error would indicate that the JDBC driver is not available in the classpath.
            throw new SQLException("MySQL JDBC driver not found.", e);
        } catch (SQLException e) {
            // This captures errors like wrong URL, username, or password, or if the database is not reachable.
            throw new SQLException("Failed to connect to the database", e);
        }
    }
}
