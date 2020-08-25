package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
protected WebDriver wd;

public HelperBase(WebDriver wd) {
  this.wd = wd;
}
protected void click(By name) {
  wd.findElement(name).click();
}
protected void fillTextField(String fieldName, String fieldValue) {
  click(By.name(fieldName));
  if (fieldValue != null) {
    String text = wd.findElement(By.name(fieldName)).getAttribute("value");
    if (!fieldValue.equals(text)){
      wd.findElement(By.name(fieldName)).clear();
      wd.findElement(By.name(fieldName)).sendKeys(fieldValue);
    }
  }
}

protected String getTextField(String fieldName) {
  if (fieldName.equals("address")) return wd.findElement(By.name(fieldName)).getText();
  else return wd.findElement(By.name(fieldName)).getAttribute("value");
}

public boolean isElementPresent(By by) {
  try {
    wd.findElement(by);
    return true;
  } catch (NoSuchElementException e) {
    return false;
  }
}
public boolean isAlertPresent() {
  try {
    wd.switchTo().alert();
    return true;
  } catch (NoAlertPresentException e) {
    return false;
  }
}

}
