package tests;

import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase{

@Test
public void testDeleteGroup() throws Exception {
  app.getNavigationHelper().gotoGroupPage();
  app.getGroupHelper().selectGroup();
  app.getGroupHelper().deleteSelectedGroup();
  app.getGroupHelper().returnGroupPage();
}

}

