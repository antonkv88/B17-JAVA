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
      ContactData contactData = new ContactData("anton", "kozlov","nick","title","company",
              "address","222666", "8999999333222", "666222", "2332",
              "test1@mail.ru", "test2@gmail.com", "test3@test.ru","test1");
      app.goTo().newContact();
      app.contact().create(contactData);
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
