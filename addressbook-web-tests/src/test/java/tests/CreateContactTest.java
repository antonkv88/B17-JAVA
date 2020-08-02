package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class CreateContactTest extends TestBase {

  @Test
  public void createContactTest() throws Exception {
    app.getNavigationHelper().gotoAddNewEntity();
    app.getContactHelperHelper().fillNames("anton", "kozlov");
    app.getContactHelperHelper().fillNickname("nick");
    app.getContactHelperHelper().fillTitle( "title");
    app.getContactHelperHelper().fillCompany("company");
    app.getContactHelperHelper().fillAddess("address");
    app.getContactHelperHelper().fillContacts(new ContactData("222666", "8999999333222", "666222", "2332","test1@mail.ru", "test2@gmail.com", "test3@test.ru"));
    app.getContactHelperHelper().finishAddNewEntity();
  }

}
