package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntityHelper extends HelperBase{

public EntityHelper(WebDriver wd) {
  super(wd);
}

public void finishAddNewEntity() {
  click(By.xpath("(//input[@name='submit'])[2]"));
}

public void fillNickname(String fieldValue) {
  fillTextField("nickname", fieldValue);
}

public void fillTitle(String fieldValue) {
  fillTextField("title", fieldValue);
}

public void fillCompany(String fieldValue) {
  fillTextField("company", fieldValue);
}

public void fillAddess(String fieldValue) {
  fillTextField("address", fieldValue);
}

public void fillNames(String firstname, String lastname) {
  fillTextField("firstname", firstname);
  fillTextField("lastname", lastname);
}

public void fillEmails(Emails emails) {
  fillTextField("email", emails.getEmail1());
  fillTextField("email2", emails.getEmail2());
  fillTextField("email3", emails.getEmail3());
}

public void fillTelephoneNumber(TelephoneNumbers telephoneNumbers) {
  fillTextField("home", telephoneNumbers.getHome());
  fillTextField("mobile", telephoneNumbers.getMobile());
  fillTextField("work", telephoneNumbers.getWork());
  fillTextField("fax", telephoneNumbers.getFax());
}
}
