package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class CreateContactTest extends TestBase {

  @Test
  public void createContactTest() throws Exception {
    Set<ContactData> before = app.contact().all();
    app.goTo().newContact();
    ContactData contact = new ContactData().withFirstname("aaa").withLastname("bbb").withNickname("nick").withTitle("title")
            .withCompany("company").withAddress("address").withHome("222666").withMobile("8999999333222").withWork("666222")
            .withFax("2332").withEmail1("test1@mail.ru").withmail2("test2@gmail.com").withEmail3("test3@gmail.com").withGroup("test1");
    app.contact().create(contact);
    app.contact().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
