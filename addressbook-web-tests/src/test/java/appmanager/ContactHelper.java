package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{

public ContactHelper(WebDriver wd) {
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
public void fillContacts(ContactData contactData) {
  fillTextField("home", contactData.getHome());
  fillTextField("mobile", contactData.getMobile());
  fillTextField("work", contactData.getWork());
  fillTextField("fax", contactData.getFax());
  fillTextField("email", contactData.getEmail1());
  fillTextField("email2", contactData.getEmail2());
  fillTextField("email3", contactData.getEmail3());
}

}
