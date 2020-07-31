package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

public GroupHelper(WebDriver wd) {
  super(wd);
}

public void submitGroupCreation() {
  click(By.name("submit"));
}

public void initGroupCreation() {
  click(By.name("new"));
}

public void fillGroupCreation(GroupData groupData) {
  fillTextField("group_name", groupData.getName());
  fillTextField("group_header", groupData.getHeader());
  fillTextField("group_footer", groupData.getFooter());
}

public void returnGroupPage() {
  click(By.linkText("group page"));
}

public void deleteSelectedGroup() {
  click(By.name("delete"));
}

public void selectGroup() {
  click(By.name("selected[]"));
}


public void initGroupModify() {
  click(By.name("edit"));
}

public void submitGroupModify() {
  click(By.name("update"));
}
}
