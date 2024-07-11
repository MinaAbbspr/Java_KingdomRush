package controller;

import java.sql.*;

public class SQLConnection {
    private static SQLConnection sqlConnection;
    private final String url = "jdbc:mysql://localhost/kingdom_rush";
    private final String className;

    private SQLConnection() {
        this.className = "com.mysql.cj.jdbc.Driver";
    }

    public static SQLConnection getSqlConnection() {
        if (sqlConnection == null)
            sqlConnection = new SQLConnection();
        return sqlConnection;
    }

    public void execute(String sqlCommand) {
        try {
            Class.forName(className);
            Connection connection = DriverManager.getConnection(url, "root", "");

            Statement statement = connection.prepareStatement(sqlCommand);
            statement.execute(sqlCommand);
            connection.close();

        } catch (SQLException | ClassNotFoundException ignored) {}
    }

    public ResultSet executeSelect(String sqlCommand) {
        try {
            Class.forName(className);
            Connection connection = DriverManager.getConnection(url, "root", "");

            Statement statement = connection.prepareStatement(sqlCommand);
            return statement.executeQuery(sqlCommand);
        } catch (Exception e) {
            return null;
        }
    }
}
