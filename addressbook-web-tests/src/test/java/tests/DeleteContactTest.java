package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

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
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.closeAlert();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
