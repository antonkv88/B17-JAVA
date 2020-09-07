package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

Logger logger = LoggerFactory.getLogger(TestBase.class);

protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

@BeforeSuite
protected void setUp() throws Exception {
  app.init();
}

@AfterSuite
protected void tearDown() throws Exception {
  app.stop();
}

@BeforeMethod
protected void logTestStart(Method m){
  logger.info("Start test testGroupCreation" + m.getName());
}

@AfterMethod(alwaysRun = true)
protected void logTestStop(Method m){
  logger.info("Stop test testGroupCreation" + m.getName());
}

}
