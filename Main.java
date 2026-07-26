package employeeApp;

import employeeApp.model.Employee;

public class Main {
  public static void main(String[] args) {
    Employee emp = new Employee(1, "山田太郎", 25, "営業");
    System.out.println(emp.getId());
    System.out.println(emp.getName());
    System.out.println(emp.getAge());
    System.out.println(emp.getDepartment());
  }
}
