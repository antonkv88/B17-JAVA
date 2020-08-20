package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class DeleteContactTest extends TestBase {

  @BeforeMethod
public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().list().size() ==0) {
      ContactData contact = new ContactData().withFirstname("aaa").withLastname("bbb").withNickname("nick").withTitle("title")
              .withCompany("company").withAddress("address").withHome("222666").withMobile("8999999333222").withWork("666222")
              .withFax("2332").withEmail1("test1@mail.ru").withmail2("test2@gmail.com").withEmail3("test3@gmail.com").withGroup("test1");
      app.goTo().newContact();
      app.contact().create(contact);
      app.contact().homePage();
    }
}

@Test
  public void testDeleteContact(){
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.closeAlert();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }

}
