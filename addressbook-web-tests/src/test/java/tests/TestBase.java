package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

@BeforeSuite
protected void setUp() throws Exception {
  app.init();
}

@AfterSuite
protected void tearDown() throws Exception {
  app.stop();
}

}
