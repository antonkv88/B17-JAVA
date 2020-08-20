package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class CreatGroupTest extends TestBase {

@Test
  public void testGroupCreation() throws Exception {
  app.goTo().groupPage();
  Set<GroupData> before = app.group().all();
  GroupData group = new GroupData().withName("test2");
  app.group().create(group);
  app.group().returnGroupPage();
  Set<GroupData> after = app.group().all();
  Assert.assertEquals(after.size(), before.size() + 1);

  group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
  before.add(group);
  Assert.assertEquals(before, after);
}

}
