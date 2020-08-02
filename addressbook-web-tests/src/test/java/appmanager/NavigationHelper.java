package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

public NavigationHelper(WebDriver wd) {
  super(wd);
}

public void gotoGroupPage() {
  click(By.linkText("groups"));
}
public void gotoAddNewContact() {
  click(By.linkText("add new"));
}
public void returnGroupPage() {
  click(By.linkText("group page"));
}
public void returnHomePage() {
  click(By.linkText("home page"));
}
}
