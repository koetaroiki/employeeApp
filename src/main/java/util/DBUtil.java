package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

  public static Connection getConnection() throws SQLException {

    String url = "jdbc:postgresql://localhost:5432/employee_db";
    String user = "postgres";
    String password = System.getenv("DB_PASSWORD");

    return DriverManager.getConnection(url, user, password);
  }
}