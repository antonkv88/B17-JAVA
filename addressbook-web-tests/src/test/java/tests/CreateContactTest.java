package tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class CreateContactTest extends TestBase {

  @Test
  public void createContactTest() throws Exception {
    List<ContactData> before = app.contact().list();
    app.goTo().newContact();
    ContactData contactData = new ContactData("aaa", "bbb","nick","title","company",
            "address","222666", "8999999333222", "666222", "2332",
            "test1@mail.ru", "test2@gmail.com", "test3@test.ru","test1");
    app.contact().create(contactData);
    app.contact().homePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contactData);
    Comparator<? super ContactData> ById = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    before.sort(ById);
    after.sort(ById);
    Assert.assertEquals(before, after);
  }

}
