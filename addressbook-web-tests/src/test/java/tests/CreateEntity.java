package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateEntity {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  @Test
  public void CreateEntityTest() throws Exception {
    startAddNewEntity();
    fillNames("anton", "kozlov");
    fillNickname("nick");
    fillTitle( "title");
    fillCompany("company");
    fillAddess("address");
    fillTelephoneNumber(new TelephoneNumbers("222666", "8999999333222", "666222", "2332"));
    fillEmails(new Emails("test1@mail.ru", "test2@gmail.com", "test3@test.ru"));
    finishAddNewEntity();
  }

@AfterMethod(alwaysRun = true)
public void tearDown() throws Exception {
  logout();
  wd.quit();
}

private void login(String username, String password) {
  wd.findElement(By.name("user")).click();
  wd.findElement(By.name("user")).clear();
  wd.findElement(By.name("user")).sendKeys(username);
  wd.findElement(By.name("pass")).clear();
  wd.findElement(By.name("pass")).sendKeys(password);
  wd.findElement(By.xpath("//input[@value='Login']")).click();
}

private void logout() {
  wd.findElement(By.linkText("Logout")).click();
}

private void fillTextField(String fieldName, String fieldValue){
  wd.findElement(By.name(fieldName)).click();
  wd.findElement(By.name(fieldName)).clear();
  wd.findElement(By.name(fieldName)).sendKeys(fieldValue);
};

private void startAddNewEntity(){
  wd.findElement(By.linkText("add new")).click();
}

private void finishAddNewEntity(){
  wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
}

private void fillNickname(String fieldValue) {
  fillTextField("nickname", fieldValue);
}

private void fillTitle(String fieldValue) {
  fillTextField("title", fieldValue);
}

private void fillCompany(String fieldValue) {
  fillTextField("company", fieldValue);
}

private void fillAddess(String fieldValue) {
  fillTextField("address", fieldValue);
}

private void fillNames(String firstname,String lastname) {
  fillTextField("firstname", lastname);
  fillTextField("lastname", lastname);
}

private void fillEmails(Emails emails) {
  fillTextField("email" , emails.getEmail1());
  fillTextField("email2", emails.getEmail2());
  fillTextField("email3", emails.getEmail3());
}

private void fillTelephoneNumber(TelephoneNumbers telephoneNumbers) {
  fillTextField("home", telephoneNumbers.getHome());
  fillTextField("mobile", telephoneNumbers.getMobile());
  fillTextField("work", telephoneNumbers.getWork());
  fillTextField("fax", telephoneNumbers.getFax());
}

private boolean isElementPresent(By by) {
  try {
    wd.findElement(by);
    return true;
  } catch (NoSuchElementException e) {
    return false;
  }
}

private boolean isAlertPresent() {
  try {
    wd.switchTo().alert();
    return true;
  } catch (NoAlertPresentException e) {
    return false;
  }
}

}
