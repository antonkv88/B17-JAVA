package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteGroupTest extends TestBase{

@Test
public void testDeleteGroup() throws Exception {
  app.getNavigationHelper().gotoGroupPage();
  if (! app.getGroupHelper().isThereAGroup()) {
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
  }
  List<GroupData> before = app.getGroupHelper().getGroupList();
  app.getGroupHelper().selectGroup(before.size() - 1);
  app.getGroupHelper().deleteSelectedGroup();
  app.getNavigationHelper().returnGroupPage();
  List<GroupData> after = app.getGroupHelper().getGroupList();
  Assert.assertEquals(after.size(), before.size() - 1);

  before.remove(before.size() - 1);
  Assert.assertEquals(before, after);
}

}

