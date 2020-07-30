package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
private EntityHelper entityHelper;
private GroupHelper groupHelper;
private NavigationHelper navigationHelper;
private SessionHelper sessionHelper;
WebDriver wd;

public void init() {
  wd = new ChromeDriver();
  groupHelper = new GroupHelper(wd);
  entityHelper = new EntityHelper(wd);
  navigationHelper = new NavigationHelper(wd);
  sessionHelper = new SessionHelper(wd);
  wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  wd.get("http://localhost/addressbook/");
  sessionHelper.login("admin", "secret");
}

public void stop() {
  sessionHelper.logout();
  wd.quit();
}

public GroupHelper getGroupHelper() {
  return groupHelper;
}

public EntityHelper getEntityHelper() {
  return entityHelper;
}

public NavigationHelper getNavigationHelper() {
  return navigationHelper;
}

public SessionHelper getSessionHelper() {
  return sessionHelper;
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

}
