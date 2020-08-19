package appmanager;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
public void selectGroup(int index) {
  wd.findElements(By.name("selected[]")).get(index).click();
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
}
public void modify(int index, GroupData group) {
  selectGroup(index);
  initGroupModify();
  fillGroupCreation(group);
  submitGroupModify();
  returnGroupPage();
}
public void delete(int index) {
  selectGroup(index);
  deleteSelectedGroup();
  returnGroupPage();
}
public List<GroupData> list() {
  List <GroupData> groups = new ArrayList<GroupData>();
  List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
  for (WebElement element : elements){
    String name = element.getText();
    int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
    groups.add(new GroupData().withId(id).withName(name));
  }
  return groups;
}
public void returnGroupPage() {
  click(By.linkText("group page"));
}
public boolean isThereAGroup() {
  return isElementPresent(By.name("selected[]"));
}
public int getGroupCount() {
  return wd.findElements(By.name("selected[]")).size();
}

}
