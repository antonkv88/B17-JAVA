package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModifyGroupTest extends TestBase{

  @Test
public void testModifyGroup(){
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModify();
    app.getGroupHelper().fillGroupCreation(new GroupData("modify1", "modify2", "modify3"));
    app.getGroupHelper().submitGroupModify();
    app.getNavigationHelper().returnGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }

}
