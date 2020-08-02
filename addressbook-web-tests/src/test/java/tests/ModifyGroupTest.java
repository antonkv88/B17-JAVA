package tests;

import model.GroupData;
import org.testng.annotations.Test;

public class ModifyGroupTest extends TestBase{

  @Test
public void testModifyGroup(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModify();
    app.getGroupHelper().fillGroupCreation(new GroupData("modify1", "modify2", "modify3"));
    app.getGroupHelper().submitGroupModify();
    app.getNavigationHelper().returnGroupPage();
  }

}
