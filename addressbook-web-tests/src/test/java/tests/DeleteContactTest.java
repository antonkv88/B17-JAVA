package tests;

import model.ContactData;
import org.testng.annotations.Test;

@Test
public class DeleteContactTest extends TestBase {
  public void testDeleteContact(){
    if (! app.getContactHelper().isThereAContact()) {
      ContactData contactData = new ContactData("anton", "kozlov","nick","title","company",
              "address","222666", "8999999333222", "666222", "2332",
              "test1@mail.ru", "test2@gmail.com", "test3@test.ru","test1");
      app.getNavigationHelper().gotoAddNewContact();
      app.getContactHelper().createContact(contactData);
      app.getNavigationHelper().returnHomePage();
    }
    app.getContactHelper().selectFirstContact();
    app.getContactHelper().delSelectedContract();
    app.closeAlert();
  }
}
