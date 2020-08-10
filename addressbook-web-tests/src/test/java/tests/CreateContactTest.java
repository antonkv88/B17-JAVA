package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class CreateContactTest extends TestBase {

  @Test
  public void createContactTest() throws Exception {
    app.getNavigationHelper().gotoAddNewContact();
    ContactData contactData = new ContactData("anton", "kozlov","nick","title","company",
            "address","222666", "8999999333222", "666222", "2332",
            "test1@mail.ru", "test2@gmail.com", "test3@test.ru","test1");
    app.getContactHelper().createContact(contactData);
    app.getNavigationHelper().returnHomePage();
  }

}
