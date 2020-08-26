package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

@Parameter(names = "-c", description = "Contact count")
public int count;
@Parameter(names = "-f", description = "Target file")
public String file;

public static void main (String[] args) throws IOException {
  ContactDataGenerator contactGenerator = new ContactDataGenerator();
  JCommander commander = new JCommander(contactGenerator);
  try{
    commander.parse(args);
  }
  catch(ParameterException ex){
    commander.usage();
    return;
  }
  contactGenerator.run();
}

private void save(List<ContactData> contacts, File file) throws IOException {
  FileWriter writer = new FileWriter(file);
  for (ContactData contact : contacts){
    writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstname(), contact.getLastname(), contact.getAddress(),
            contact.getHome(), contact.getMobile(), contact.getWork(),
            contact.getEmail1(), contact.getEmail2(), contact.getEmail3()));
  }
  writer.close();
}

private void run() throws IOException {
  List<ContactData> contacts = generateContacts(count);
  save(contacts, new File(file));
}

private List<ContactData> generateContacts(int count) {
  List<ContactData> contact = new ArrayList<ContactData>();
  for (int i = 0; i < count; i++) {
    contact.add(new ContactData().withFirstname(String.format("firstname %s",i)).withLastname(String.format("lastname %s",i)).withAddress(String.format("address %s",i))
            .withHome(String.format("111222000%s",i)).withMobile(String.format("899911166%s",i)).withWork(String.format("222333%s",i))
            .withEmail1(String.format("email%s@test1.ru",i)).withmail2(String.format("email%s@test2.ru",i)).withEmail3(String.format("email%s@test3.ru",i)));
  }
  return contact;
}
}
