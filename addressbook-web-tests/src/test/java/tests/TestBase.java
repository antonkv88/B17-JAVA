package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
protected WebDriver wd;

@BeforeMethod(alwaysRun = true)
protected void setUp() throws Exception {
  wd = new ChromeDriver();
  wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  wd.get("http://localhost/addressbook/");
  login("admin", "secret");
}

private void login(String username, String password) {
  fillTextField("user", username);
  fillTextField("pass", password);
  wd.findElement(By.xpath("//input[@value='Login']")).click();
}

private void logout() {
  wd.findElement(By.linkText("Logout")).click();
}

protected void submitGroupCreation() {
  wd.findElement(By.name("submit")).click();
}

protected void initGroupCreation() {
  wd.findElement(By.name("new")).click();
}

protected void fillGroupCreation(GroupData groupData) {
  fillTextField("group_name", groupData.getName());
  fillTextField("group_header", groupData.getHeader());
  fillTextField("group_footer", groupData.getFooter());
}

protected void gotoGroupPage() {
  wd.findElement(By.linkText("groups")).click();
}

@AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    logout();
    wd.quit();
  }

private void fillTextField(String fieldName, String fieldValue){
  wd.findElement(By.name(fieldName)).click();
  wd.findElement(By.name(fieldName)).clear();
  wd.findElement(By.name(fieldName)).sendKeys(fieldValue);
}

protected void startAddNewEntity(){
  wd.findElement(By.linkText("add new")).click();
}

protected void finishAddNewEntity(){
  wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
}

protected void fillNickname(String fieldValue) {
  fillTextField("nickname", fieldValue);
}

protected void fillTitle(String fieldValue) {
  fillTextField("title", fieldValue);
}

protected void fillCompany(String fieldValue) {
  fillTextField("company", fieldValue);
}

protected void fillAddess(String fieldValue) {
  fillTextField("address", fieldValue);
}

protected void fillNames(String firstname, String lastname) {
  fillTextField("firstname", lastname);
  fillTextField("lastname", lastname);
}

protected void fillEmails(Emails emails) {
  fillTextField("email" , emails.getEmail1());
  fillTextField("email2", emails.getEmail2());
  fillTextField("email3", emails.getEmail3());
}

protected void fillTelephoneNumber(TelephoneNumbers telephoneNumbers) {
  fillTextField("home", telephoneNumbers.getHome());
  fillTextField("mobile", telephoneNumbers.getMobile());
  fillTextField("work", telephoneNumbers.getWork());
  fillTextField("fax", telephoneNumbers.getFax());
}

protected boolean isAlertPresent() {
  try {
    wd.switchTo().alert();
    return true;
  } catch (NoAlertPresentException e) {
    return false;
  }
}

protected boolean isElementPresent(By by) {
  try {
    wd.findElement(by);
    return true;
  } catch (NoSuchElementException e) {
    return false;
  }
}

protected void returnGroupPage() {
  wd.findElement(By.linkText("group page")).click();
}

protected void deleteSelectedGroup() {
  wd.findElement(By.name("delete")).click();
}

protected void selectGroup() {
  wd.findElement(By.name("selected[]")).click();
}

protected void gotoGroupsPage() {
  wd.findElement(By.linkText("groups")).click();
}
}
