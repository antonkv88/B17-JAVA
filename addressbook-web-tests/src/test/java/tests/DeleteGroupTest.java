package tests;

import model.GroupData;
import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase{

@Test
public void testDeleteGroup() throws Exception {
  app.getNavigationHelper().gotoGroupPage();
  if (! app.getGroupHelper().isThereAGroup()) {
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
  }
  app.getGroupHelper().selectGroup();
  app.getGroupHelper().deleteSelectedGroup();
  app.getNavigationHelper().returnGroupPage();
}

}

