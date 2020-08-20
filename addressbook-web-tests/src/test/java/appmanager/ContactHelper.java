package appmanager;

import model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

public ContactHelper(WebDriver wd) {
  super(wd);
}
public void finishAddNewEntity() {
  click(By.xpath("(//input[@name='submit'])[2]"));
}
public void select(int index) {
  wd.findElements(By.name("selected[]")).get(index).click();
}
public void deleteSelected(){
  click(By.xpath("//input[@value='Delete']"));
}
public void modifySelected(){
  click(By.xpath("//img[@alt='Edit']"));
}
public void modify(int index, ContactData contact) {
  select(index);
  modifySelected();
  fill(contact, false);
  submit();
  homePage();
}
public void delete(int index) {
  select(index);
  deleteSelected();
}
public void homePage() {
  if (isElementPresent(By.id("maintable"))){
    return;
  } else {
    click(By.linkText("home page"));
  }
}
public void submit(){
  click(By.xpath("(//input[@name='update'])[2]"));
}
public void fill(ContactData contactData, boolean creation) {
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

  if (creation){
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
  } else {
    Assert.assertFalse(isElementPresent(By.name("new_group")));
  }
}
public void create(ContactData contact) {
  fill(contact,true);
  finishAddNewEntity();
}
public List<ContactData> list() {
  String lastname;
  String firstname;
  List<ContactData> contacts = new ArrayList<ContactData>();
  List<WebElement> rows = wd.findElements(By.cssSelector("table tr"));
  for (WebElement row : rows){
    List<WebElement> columns = row.findElements(By.tagName("td"));
    if (columns.size() == 0) continue; //пропускаю заголовок
    int id = Integer.parseInt(columns.get(0).findElement(By.tagName("input")).getAttribute("value"));
    lastname = columns.get(1).getText();
    firstname = columns.get(2).getText();
    ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname);
    contacts.add(contact);
    }
  return contacts;
}

}
