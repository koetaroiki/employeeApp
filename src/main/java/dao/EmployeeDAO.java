package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.DBUtil;

public class EmployeeDAO {
  public void findAll() {

    try (Connection connection = DBUtil.getConnection()) {

      System.out.println("EmployeeDAOからDB接続成功！");

    } catch (SQLException e) {

      e.printStackTrace();
    }
  }
}
