package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContactTest extends TestBase {
@DataProvider
public Iterator<Object[]> validGroups(){
  List<Object[]> list = new ArrayList<Object[]>();
  list.add(new Object[] {new ContactData().withFirstname("aaa").withLastname("bbb").withNickname("nick").withTitle("title")
          .withCompany("company").withAddress("address").withHome("222666").withMobile("8999999333222").withWork("666222")
          .withFax("2332").withEmail1("test1@mail.ru").withmail2("test2@gmail.com").withEmail3("test3@gmail.com")
          .withGroup("test1")});
  list.add(new Object[] {new ContactData().withFirstname("rrr").withLastname("ddd").withNickname("nick2").withTitle("title2")
          .withCompany("company2").withAddress("address2").withHome("7657567").withMobile("9999785675").withWork("654674")
          .withFax("7777").withEmail1("test4@mail.ru").withmail2("test5@gmail.com").withEmail3("test6@gmail.com")
          .withGroup("test1")});
  list.add(new Object[] {new ContactData().withFirstname("dddd").withLastname("hhh").withNickname("nick3").withTitle("title3")
          .withCompany("company3").withAddress("address3").withHome("76567").withMobile("756763663").withWork("55544433")
          .withFax("76756").withEmail1("test7@mail.ru").withmail2("test8@gmail.com").withEmail3("test9@gmail.com")
          .withGroup("test1")});
  return list.iterator();
}

  @Test(dataProvider = "validGroups")
  public void createContactTest(ContactData contact) throws Exception {
    Contacts before = app.contact().all();
    app.goTo().newContact();
    File photo = new File("");
    app.contact().create(contact);
    app.contact().homePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
