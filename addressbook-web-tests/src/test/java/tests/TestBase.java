package tests;

import appmanager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

protected final ApplicationManager app = new ApplicationManager();

@BeforeMethod(alwaysRun = true)
protected void setUp() throws Exception {
  app.init();
}

@AfterMethod(alwaysRun = true)
protected void tearDown() throws Exception {
  app.stop();
}

}
