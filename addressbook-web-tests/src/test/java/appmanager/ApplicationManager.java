package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.Emails;
import model.GroupData;
import tests.TelephoneNumbers;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
protected WebDriver wd;

public void init() {
  wd = new ChromeDriver();
  wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  wd.get("http://localhost/addressbook/");
  login("admin", "secret");
}

protected void login(String username, String password) {
  fillTextField("user", username);
  fillTextField("pass", password);
  wd.findElement(By.xpath("//input[@value='Login']")).click();
}

protected void logout() {
  wd.findElement(By.linkText("Logout")).click();
}

public void submitGroupCreation() {
  wd.findElement(By.name("submit")).click();
}

public void initGroupCreation() {
  wd.findElement(By.name("new")).click();
}

public void fillGroupCreation(GroupData groupData) {
  fillTextField("group_name", groupData.getName());
  fillTextField("group_header", groupData.getHeader());
  fillTextField("group_footer", groupData.getFooter());
}

public void gotoGroupPage() {
  wd.findElement(By.linkText("groups")).click();
}

public void stop() {
  logout();
  wd.quit();
}

private void fillTextField(String fieldName, String fieldValue){
  wd.findElement(By.name(fieldName)).click();
  wd.findElement(By.name(fieldName)).clear();
  wd.findElement(By.name(fieldName)).sendKeys(fieldValue);
}

public void startAddNewEntity(){
  wd.findElement(By.linkText("add new")).click();
}

public void finishAddNewEntity(){
  wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
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
  fillTextField("firstname", lastname);
  fillTextField("lastname", lastname);
}

public void fillEmails(Emails emails) {
  fillTextField("email" , emails.getEmail1());
  fillTextField("email2", emails.getEmail2());
  fillTextField("email3", emails.getEmail3());
}

public void fillTelephoneNumber(TelephoneNumbers telephoneNumbers) {
  fillTextField("home", telephoneNumbers.getHome());
  fillTextField("mobile", telephoneNumbers.getMobile());
  fillTextField("work", telephoneNumbers.getWork());
  fillTextField("fax", telephoneNumbers.getFax());
}

public boolean isAlertPresent() {
  try {
    wd.switchTo().alert();
    return true;
  } catch (NoAlertPresentException e) {
    return false;
  }
}

public boolean isElementPresent(By by) {
  try {
    wd.findElement(by);
    return true;
  } catch (NoSuchElementException e) {
    return false;
  }
}

public void returnGroupPage() {
  wd.findElement(By.linkText("group page")).click();
}

public void deleteSelectedGroup() {
  wd.findElement(By.name("delete")).click();
}

public void selectGroup() {
  wd.findElement(By.name("selected[]")).click();
}

public void gotoGroupsPage() {
  wd.findElement(By.linkText("groups")).click();
}
}
