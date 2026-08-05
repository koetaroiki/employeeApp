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

    // 実行するSQL（必要な列だけを指定して抽出）
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

  /**
   * 社員情報を登録する
   *
   * @param employee 登録する社員情報
   */
  public void insert(Employee employee) {
    // 実行するSQL
    String sql = "INSERT INTO employees(name, age, department) VALUES (?, ?, ?)";

    try (
        // データベースへ接続
        Connection connection = DBUtil.getConnection();

        // SQLを準備
        PreparedStatement statement = connection.prepareStatement(sql)) {

      // SQLの?に値を設定
      statement.setString(1, employee.getName());
      statement.setInt(2, employee.getAge());
      statement.setString(3, employee.getDepartment());

      // SQLを実行
      int count = statement.executeUpdate();

      // 登録件数を表示
      System.out.println(count + "件登録しました。");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
