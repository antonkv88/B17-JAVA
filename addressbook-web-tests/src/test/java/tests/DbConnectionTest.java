package tests;

import model.GroupData;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnectionTest {

  @Test
  public void dbConnectiontest(){
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook?user=root&password=&serverTimezone=UTC");
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
      while (result.next()){
        new GroupData().withId(result.getInt("group_id")).withName(result.getString("group_name"))
                .withHeader(result.getString("group_header")).withFooter(result.getString("group_footer"));
      }
      result.close();
      statement.close();
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
