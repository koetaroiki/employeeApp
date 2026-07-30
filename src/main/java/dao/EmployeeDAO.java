package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.DBUtil;

public class EmployeeDAO {
  public List<Employee> findAll() {

    List<Employee> employees = new ArrayList<>();

    String sql = "SELECT id, name, age, department FROM employees";

    try (
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()) {

      while (resultSet.next()) {

        Employee employee = new Employee(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("age"),
            resultSet.getString("department"));

        employees.add(employee);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return employees;
  }
}
