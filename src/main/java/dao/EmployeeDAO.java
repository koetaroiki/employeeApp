package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.DBUtil;

/**
 * employeesテーブルを操作するDAOクラス
 */
public class EmployeeDAO {

  /**
   * employeesテーブルの全件を取得する
   *
   * @return 社員情報のリスト
   */
  public List<Employee> findAll() {

    // Employeeオブジェクトを格納するリスト
    List<Employee> employees = new ArrayList<>();

    // 実行するSQL
    String sql = "SELECT id, name, age, department FROM employees";

    try (
        // データベースへ接続
        Connection connection = DBUtil.getConnection();

        // SQLを準備
        PreparedStatement statement = connection.prepareStatement(sql);

        // SQLを実行し、結果を取得
        ResultSet resultSet = statement.executeQuery()) {

      // 検索結果を1件ずつ取り出す
      while (resultSet.next()) {

        // 取得した1件分のデータをEmployeeオブジェクトに変換
        Employee employee = new Employee(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("age"),
            resultSet.getString("department"));

        // リストへ追加
        employees.add(employee);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    // 取得した社員一覧を返す
    return employees;
  }
}