package tests;

import org.testng.annotations.Test;

@Test
public class DeleteContactTest extends TestBase {
  public void testDeleteContact(){
    app.getContactHelper().selectContact();
    app.getContactHelper().delSelectedContract();
    app.closeAlert();
  }
}
