package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatGroupTest extends TestBase {

@Test
  public void testGroupCreation() throws Exception {
  app.getNavigationHelper().gotoGroupPage();
  int before = app.getGroupHelper().getGroupCount();
  app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
  app.getNavigationHelper().returnGroupPage();
  int after = app.getGroupHelper().getGroupCount();
  Assert.assertEquals(after, before + 1);
}

}
