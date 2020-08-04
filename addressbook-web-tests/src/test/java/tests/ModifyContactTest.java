package tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ModifyContactTest extends TestBase {

 @Test
 public void testModifyContact() {
  app.getContactHelper().selectContact();
  app.getContactHelper().modifySelectedContract();
  app.getContactHelper().fillNames("modify", "modify2");
  app.getContactHelper().fillNickname("modify_nick");
  app.getContactHelper().fillTitle( "modify_title");
  app.getContactHelper().fillCompany("modify_company");
  app.getContactHelper().fillAddess("modify_address");
  app.getContactHelper().fillContacts(new ContactData("0000000", "111111111111", "123123", "9999999","modify1@mail.ru", "modify2@gmail.com", "modify3@test.ru"));
  app.getContactHelper().submitModifyContact();
  app.getNavigationHelper().returnHomePage();
}

}
