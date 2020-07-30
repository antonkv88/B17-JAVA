package tests;

import org.testng.annotations.Test;

public class DeleteGroupTest extends TestBase{

@Test
public void testDeleteGroup() throws Exception {
  app.gotoGroupsPage();
  app.selectGroup();
  app.deleteSelectedGroup();
  app.returnGroupPage();
}

}

