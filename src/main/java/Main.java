
import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

public class Main {

  public static void main(String[] args) {

    EmployeeDAO dao = new EmployeeDAO();

    List<Employee> employees = dao.findAll();

    System.out.println("取得件数：" + employees.size());

    for (Employee employee : employees) {
      System.out.println(employee);
    }
  }
}