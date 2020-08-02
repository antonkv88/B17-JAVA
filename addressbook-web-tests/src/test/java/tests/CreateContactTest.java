package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class CreateContactTest extends TestBase {

  @Test
  public void createContactTest() throws Exception {
    app.getNavigationHelper().gotoAddNewContact();
    app.getContactHelper().fillNames("anton", "kozlov");
    app.getContactHelper().fillNickname("nick");
    app.getContactHelper().fillTitle( "title");
    app.getContactHelper().fillCompany("company");
    app.getContactHelper().fillAddess("address");
    app.getContactHelper().fillContacts(new ContactData("222666", "8999999333222", "666222", "2332","test1@mail.ru", "test2@gmail.com", "test3@test.ru"));
    app.getContactHelper().finishAddNewEntity();
  }

}
