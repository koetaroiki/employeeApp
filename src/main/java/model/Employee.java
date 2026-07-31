package model;

/**
 * 社員情報を保持するモデルクラス
 * 
 * データベースの employees テーブルの1件分のデータを
 * Javaオブジェクトとして扱うためのクラス
 */
public class Employee {

  // 社員ID
  private int id;

  // 社員名
  private String name;

  // 年齢
  private int age;

  // 所属部署
  private String department;

  /**
   * JavaBeans形式で使用するための引数なしコンストラクタ
   */
  public Employee() {
  }

  /**
   * 社員情報を初期化するコンストラクタ
   *
   * @param id         社員ID
   * @param name       社員名
   * @param age        年齢
   * @param department 所属部署
   */
  public Employee(int id, String name, int age, String department) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.department = department;
  }

  /**
   * 社員IDを取得する
   *
   * @return 社員ID
   */
  public int getId() {
    return id;
  }

  /**
   * 社員名を取得する
   *
   * @return 社員名
   */
  public String getName() {
    return name;
  }

  /**
   * 年齢を取得する
   *
   * @return 年齢
   */
  public int getAge() {
    return age;
  }

  /**
   * 所属部署を取得する
   *
   * @return 所属部署
   */
  public String getDepartment() {
    return department;
  }

  /**
   * Employeeオブジェクトの内容を文字列として表示する
   *
   * @return 社員情報の文字列
   */
  @Override
  public String toString() {
    return "Employee [id=" + id
        + ", name=" + name
        + ", age=" + age
        + ", department=" + department + "]";
  }
}