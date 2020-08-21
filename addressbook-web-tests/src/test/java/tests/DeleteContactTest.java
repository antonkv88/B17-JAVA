package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactTest extends TestBase {

  @BeforeMethod
public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().all().size() ==0) {
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
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.closeAlert();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }

}
