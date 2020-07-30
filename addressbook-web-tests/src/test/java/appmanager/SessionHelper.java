package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
private WebDriver wd;

public SessionHelper(WebDriver wd) {
  this.wd = wd;
}

private void fillTextField(String fieldName, String fieldValue) {
  wd.findElement(By.name(fieldName)).click();
  wd.findElement(By.name(fieldName)).clear();
  wd.findElement(By.name(fieldName)).sendKeys(fieldValue);
}

protected void login(String username, String password) {
  fillTextField("user", username);
  fillTextField("pass", password);
  wd.findElement(By.xpath("//input[@value='Login']")).click();
}

protected void logout() {
  wd.findElement(By.linkText("Logout")).click();
}
}
