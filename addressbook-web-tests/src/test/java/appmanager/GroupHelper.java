package appmanager;

import model.GroupData;
import model.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupHelper extends HelperBase {
  private Groups groupCache = null;
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
public void create(GroupData group) {
  initGroupCreation();
  fillGroupCreation(group);
  submitGroupCreation();
  groupCache = null;
}
public void modify(GroupData group) {
  selectGroupById(group.getId());
  initGroupModify();
  fillGroupCreation(group);
  submitGroupModify();
  groupCache = null;
  returnGroupPage();
}
public void delete(GroupData group) {
  selectGroupById(group.getId());
  deleteSelectedGroup();
  groupCache = null;
  returnGroupPage();
}
private void selectGroupById(Integer id) {
  wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
}

public Groups all() {
  if (groupCache != null) {
    return new Groups(groupCache);
  }
  groupCache = new Groups();
  List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
  for (WebElement element : elements){
    String name = element.getText();
    int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
    groupCache.add(new GroupData().withId(id).withName(name));
  }
  return new Groups(groupCache);
}

public void returnGroupPage() {
  click(By.linkText("group page"));
}


}
