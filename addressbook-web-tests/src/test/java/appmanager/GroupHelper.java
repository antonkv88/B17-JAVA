package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

public GroupHelper(WebDriver wd) {
  super(wd);
}

public void fillGroupCreation(GroupData groupData) {
  fillTextField("group_name", groupData.getName());
  fillTextField("group_header", groupData.getHeader());
  fillTextField("group_footer", groupData.getFooter());
}

public void deleteSelectedGroup() {
  click(By.name("delete"));
}
public void selectGroup() {
  click(By.name("selected[]"));
}
public void submitGroupCreation() {
  click(By.name("submit"));
}
public void initGroupCreation() {
  click(By.name("new"));
}
public void initGroupModify() {
  click(By.name("edit"));
}
public void submitGroupModify() {
  click(By.name("update"));
}

public boolean isThereAGroup() {
  return isElementPresent(By.name("selected[]"));
}

public void createGroup(GroupData group) {
  initGroupCreation();
  fillGroupCreation(group);
  submitGroupCreation();
}

public int getGroupCount() {
  return wd.findElements(By.name("selected[]")).size();
}

}
