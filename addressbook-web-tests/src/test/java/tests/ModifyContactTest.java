package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ModifyContactTest extends TestBase {

 @Test
 public void testModifyContact() {
  ContactData contact;
  if (! app.getContactHelper().isThereAContact()) {
   ContactData contactData = new ContactData("anton", "kozlov","nick","title","company",
           "address","222666", "8999999333222", "666222", "2332",
           "test1@mail.ru", "test2@gmail.com", "test3@test.ru","test1");
   app.getNavigationHelper().gotoAddNewContact();
   app.getContactHelper().createContact(contactData);
   app.getNavigationHelper().returnHomePage();
  }
  app.getContactHelper().modifyFirstContract();
  contact = new ContactData("modify", "modify2", "modify_nick","modify_title",
          "modify_company","modify_address" ,"0000000", "111111111111",
          "123123", "9999999","modify1@mail.ru", "modify2@gmail.com", "modify3@test.ru", null);
  app.getContactHelper().fillContacts(contact, false);
  app.getContactHelper().submitModifyContact();
  app.getNavigationHelper().returnHomePage();
}

}
