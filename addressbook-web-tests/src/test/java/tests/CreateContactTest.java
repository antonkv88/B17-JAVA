package tests;

import com.thoughtworks.xstream.XStream;
import model.ContactData;
import model.Contacts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateContactTest extends TestBase {
@DataProvider
public Iterator<Object[]> validContacts() throws IOException {
  BufferedReader reader = new BufferedReader (new FileReader(new File("src/test/resources/contact.xml")));
  String xml = "";
  String line = reader.readLine();
  while (line != null) {
    xml += line;
    line = reader.readLine();
  }
  XStream stream = new XStream();
  stream.processAnnotations(ContactData.class);
  List<ContactData> contacts = (List<ContactData>)stream.fromXML(xml);
  return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
}

  @Test(dataProvider = "validContacts")
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
