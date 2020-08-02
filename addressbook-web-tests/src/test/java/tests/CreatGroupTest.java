package tests;

import model.GroupData;
import org.testng.annotations.Test;

public class CreatGroupTest extends TestBase {

@Test
  public void testGroupCreation() throws Exception {
  app.getNavigationHelper().gotoGroupPage();
  app.getGroupHelper().initGroupCreation();
  app.getGroupHelper().fillGroupCreation(new GroupData("test1", "test2", "test3"));
  app.getGroupHelper().submitGroupCreation();
}

}
