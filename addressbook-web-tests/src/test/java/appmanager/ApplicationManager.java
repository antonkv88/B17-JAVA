package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
private ContactHelper contactHelper;
private GroupHelper groupHelper;
private NavigationHelper navigationHelper;
private SessionHelper sessionHelper;
WebDriver wd;

public void init() {
  wd = new ChromeDriver();
  groupHelper = new GroupHelper(wd);
  contactHelper = new ContactHelper(wd);
  navigationHelper = new NavigationHelper(wd);
  sessionHelper = new SessionHelper(wd);
  wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  wd.get("http://localhost/addressbook/");
  getSessionHelper().login("admin", "secret");
}

public void stop() {
  getSessionHelper().logout();
  wd.quit();
}

public void closeAlert(){
  wd.switchTo().alert().accept();
}

public GroupHelper getGroupHelper() {
  return groupHelper;
}

public ContactHelper getContactHelper() {
  return contactHelper;
}

public NavigationHelper getNavigationHelper() {
  return navigationHelper;
}

public SessionHelper getSessionHelper() {
  return sessionHelper;
}

}
