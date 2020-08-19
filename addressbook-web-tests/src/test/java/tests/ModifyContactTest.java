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
  ContactData contactData = new ContactData("anton", "kozlov","nick","title","company",
          "address","222666", "8999999333222", "666222", "2332",
          "test1@mail.ru", "test2@gmail.com", "test3@test.ru","test1");
  app.goTo().newContact();
  app.contact().create(contactData);
  app.contact().homePage();
 }
}

 @Test
 public void testModifyContact() {
  List<ContactData> before = app.contact().list();
  int index = before.size() - 1;
  ContactData contact = new ContactData(before.get(index).getId(),"modify", "modify2", "modify_nick","modify_title",
          "modify_company","modify_address" ,"0000000", "111111111111",
          "123123", "9999999","modify1@mail.ru", "modify2@gmail.com", "modify3@test.ru", null);
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
