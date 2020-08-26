package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContactTest extends TestBase {

  @Test
  public void createContactTest() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().newContact();
    File photo = new File("");
    ContactData contact = new ContactData().withFirstname("aaa").withLastname("bbb").withNickname("nick").withTitle("title")
            .withCompany("company").withAddress("address").withHome("222666").withMobile("8999999333222").withWork("666222")
            .withFax("2332").withEmail1("test1@mail.ru").withmail2("test2@gmail.com").withEmail3("test3@gmail.com")
            .withGroup("test1").withPhoto(photo);
    app.contact().create(contact);
    app.contact().homePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
