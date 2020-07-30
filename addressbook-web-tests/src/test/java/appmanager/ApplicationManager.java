package appmanager;

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
  getSessionHelper().login("admin", "secret");
}

public void stop() {
  getSessionHelper().logout();
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

}
