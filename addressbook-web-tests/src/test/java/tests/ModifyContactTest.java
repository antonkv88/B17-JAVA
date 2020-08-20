package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;

public class ModifyContactTest extends TestBase {

@BeforeMethod
public void ensurePreconditions() {
 app.contact().homePage();
 if (app.contact().list().size() ==0) {
  ContactData contact = new ContactData().withFirstname("anton").withLastname("kozlov").withNickname("nick").withTitle("title")
          .withCompany("company").withAddress("address").withHome("222666").withMobile("8999999333222").withWork("666222")
          .withFax("2332").withEmail1("test1@mail.ru").withmail2("test2@gmail.com").withEmail3("test3@gmail.com").withGroup("test1");
  app.goTo().newContact();
  app.contact().create(contact);
  app.contact().homePage();
 }
}

 @Test
 public void testModifyContact() {
  List<ContactData> before = app.contact().list();
  int index = before.size() - 1;
  ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("modify").withLastname("modify2")
          .withNickname("modify_nick").withTitle("modify_title").withCompany("modify_company").withAddress("modify_address").withHome("0000000")
          .withMobile("111111111111").withWork("123123").withFax("9999999").withEmail1("modify1@mail.ru")
          .withmail2("modify2@gmail.com").withEmail3("modify3@test.ru");
  app.contact().modify(index, contact);
  List<ContactData> after = app.contact().list();
  Assert.assertEquals(after.size(), before.size());

  before.remove(0);
  before.add(contact);

  Comparator<? super ContactData> ById = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
  before.sort(ById);
  after.sort(ById);
  Assert.assertEquals(before, after);
}

}
