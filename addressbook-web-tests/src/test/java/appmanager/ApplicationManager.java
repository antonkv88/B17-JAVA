package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
private ContactHelper contactHelper;
private GroupHelper groupHelper;
private NavigationHelper navigationHelper;
private SessionHelper sessionHelper;
private String browser;
WebDriver wd;

public ApplicationManager(String browser) {
  this.browser = browser;
}

public void init() {
  if (browser.equals(BrowserType.CHROME)) {
    wd = new ChromeDriver();
  }
  else if (browser.equals(BrowserType.FIREFOX)){
    wd = new FirefoxDriver();
  }
  else if (browser.equals(BrowserType.IE)){
    wd = new InternetExplorerDriver();
  }

  groupHelper = new GroupHelper(wd);
  contactHelper = new ContactHelper(wd);
  navigationHelper = new NavigationHelper(wd);
  sessionHelper = new SessionHelper(wd);
  wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
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
