package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

protected ApplicationManager app = new ApplicationManager(BrowserType.IE);

@BeforeMethod(alwaysRun = true)
protected void setUp() throws Exception {
  app.init();
}

@AfterMethod(alwaysRun = true)
protected void tearDown() throws Exception {
  app.stop();
}

}
