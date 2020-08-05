package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ModifyContactTest extends TestBase {

 @Test
 public void testModifyContact() {
  app.getContactHelper().modifyFirstContract();
  ContactData contactData = new ContactData("modify", "modify2", "modify_nick","modify_title",
          "modify_company","modify_address" ,"0000000", "111111111111",
          "123123", "9999999","modify1@mail.ru", "modify2@gmail.com", "modify3@test.ru");
  app.getContactHelper().fillContacts(contactData);
  app.getContactHelper().submitModifyContact();
  app.getNavigationHelper().returnHomePage();
}

}
