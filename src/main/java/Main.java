
import dao.EmployeeDAO;

public class Main {

  public static void main(String[] args) {

    EmployeeDAO dao = new EmployeeDAO();
    dao.findAll();
  }
}