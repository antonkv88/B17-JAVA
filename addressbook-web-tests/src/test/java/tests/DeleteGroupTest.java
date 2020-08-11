package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase{

@Test
public void testDeleteGroup() throws Exception {
  app.getNavigationHelper().gotoGroupPage();
  int before = app.getGroupHelper().getGroupCount();
  if (! app.getGroupHelper().isThereAGroup()) {
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
  }
  app.getGroupHelper().selectGroup(before - 1);
  app.getGroupHelper().deleteSelectedGroup();
  app.getNavigationHelper().returnGroupPage();
  int after = app.getGroupHelper().getGroupCount();
  Assert.assertEquals(after, before - 1);
}

}

