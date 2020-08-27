package tests;

import model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

  @BeforeMethod
public void ensurePreconditions() {
  app.contact().homePage();
  if (app.contact().all().size() == 0) {
    ContactData contact = new ContactData().withFirstname("anton").withLastname("kozlov").withNickname("nick").withTitle("title")
            .withCompany("company").withAddress("address").withHome("222666").withMobile("8999999333222").withWork("666222")
            .withFax("2332").withEmail1("test1@mail.ru").withmail2("test2@gmail.com").withEmail3("test3@gmail.com").withGroup("test1");
    app.goTo().newContact();
    app.contact().create(contact);
    app.contact().homePage();
  }
}

  @Test
public void testContactPhone(){
    ContactData contactFromMainForm = app.contact().all().iterator().next();
    ContactData contactFromEditHome = app.contact().infoFromEditForm(contactFromMainForm);
    assertThat(contactFromMainForm.getAddress().replaceAll(" ",""),equalTo(contactFromEditHome.getAddress().replaceAll(" ","")));
    assertThat(contactFromMainForm.getAllPhones(),equalTo(mergePhones(contactFromEditHome)));
    assertThat(contactFromMainForm.getAllEmails(),equalTo(mergeEmails(contactFromEditHome)));
  }

private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome(), contact.getMobile(), contact.getWork()).stream()
            .filter((s) -> !s.equals("")).map(ContactPhoneTest::cleanedPhone).collect(Collectors.joining("\n"));

}

private String mergeEmails(ContactData contact) {
  return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).stream()
          .filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));

}

public static String cleanedPhone(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

}
