import java.sql.Connection;
import util.DBUtil;

public class Main {

  public static void main(String[] args) {

    try (Connection connection = DBUtil.getConnection()) {
      System.out.println("データベース接続成功！");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}