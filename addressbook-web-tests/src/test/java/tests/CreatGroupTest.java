package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class CreatGroupTest extends TestBase {

@Test
  public void testGroupCreation() throws Exception {
  app.getNavigationHelper().gotoGroupPage();
  List<GroupData> before = app.getGroupHelper().getGroupList();
  GroupData group = new GroupData("test2", null, null);
  app.getGroupHelper().createGroup(group);
  app.getNavigationHelper().returnGroupPage();
  List<GroupData> after = app.getGroupHelper().getGroupList();
  Assert.assertEquals(after.size(), before.size() + 1);

  before.add(group);
  Comparator<? super GroupData> ById = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
  before.sort(ById);
  after.sort(ById);
  Assert.assertEquals(before, after);
}

}
