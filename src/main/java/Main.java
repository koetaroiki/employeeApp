import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

/**
 * アプリケーションの実行クラス
 */
public class Main {

  public static void main(String[] args) {

    // EmployeeDAOを生成
    EmployeeDAO dao = new EmployeeDAO();
    // 登録する社員データを作成
    // Employee employee = new Employee(
    // 0,
    // "鈴木花子",
    // 30,
    // "総務");

    // // 社員を登録
    // dao.insert(employee);

    // 社員情報をデータベースから取得
    List<Employee> employees = dao.findAll();

    // 取得件数を表示
    System.out.println("取得件数：" + employees.size());

    // 取得した社員情報を1件ずつ表示
    for (Employee emp : employees) {
      System.out.println(emp);
    }
  }
}