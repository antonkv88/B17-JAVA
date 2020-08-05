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

public void selectFirstContact() {
  click(By.name("selected[]"));
}

public void delSelectedContract(){
  click(By.xpath("//input[@value='Delete']"));
}
public void modifyFirstContract(){
  click(By.xpath("//img[@alt='Edit']"));
}
public void submitModifyContact(){
  click(By.xpath("(//input[@name='update'])[2]"));
}

public void fillContacts(ContactData contactData) {
  fillTextField("firstname", contactData.getFirstname());
  fillTextField("lastname", contactData.getLastname());
  fillTextField("nickname", contactData.getNickname());

  fillTextField("title", contactData.getTitle());
  fillTextField("company", contactData.getCompany());
  fillTextField("address", contactData.getAddress());

  fillTextField("home", contactData.getHome());
  fillTextField("mobile", contactData.getMobile());
  fillTextField("work", contactData.getWork());
  fillTextField("fax", contactData.getFax());

  fillTextField("email", contactData.getEmail1());
  fillTextField("email2", contactData.getEmail2());
  fillTextField("email3", contactData.getEmail3());
}

}
