package tests;

import model.GroupData;
import model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ModifyGroupTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testModifyGroup(){
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId()).
            withName("modify1").withFooter("modify2").withHeader("modify3");
    app.group().modify(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
  }

}
