package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

public SessionHelper(WebDriver wd) {
  super(wd);
}
protected void login(String username, String password) {
  fillTextField("user", username);
  fillTextField("pass", password);
  click(By.xpath("//input[@value='Login']"));
}
protected void logout() {
  click(By.linkText("Logout"));
}
}
