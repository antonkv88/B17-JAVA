package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper {
private WebDriver wd;

public GroupHelper(WebDriver wd) {
  this.wd = wd;
}

public void submitGroupCreation() {
  wd.findElement(By.name("submit")).click();
}

public void initGroupCreation() {
  wd.findElement(By.name("new")).click();
}

private void fillTextField(String fieldName, String fieldValue) {
  wd.findElement(By.name(fieldName)).click();
  wd.findElement(By.name(fieldName)).clear();
  wd.findElement(By.name(fieldName)).sendKeys(fieldValue);
}

public void fillGroupCreation(GroupData groupData) {
  fillTextField("group_name", groupData.getName());
  fillTextField("group_header", groupData.getHeader());
  fillTextField("group_footer", groupData.getFooter());
}

public void returnGroupPage() {
  wd.findElement(By.linkText("group page")).click();
}

public void deleteSelectedGroup() {
  wd.findElement(By.name("delete")).click();
}

public void selectGroup() {
  wd.findElement(By.name("selected[]")).click();
}


}
