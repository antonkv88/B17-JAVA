package tests;

import model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Comparator;
import java.util.List;

public class CreatGroupTest extends TestBase {

@Test
  public void testGroupCreation() throws Exception {
  app.goTo().groupPage();
  List<GroupData> before = app.group().list();
  GroupData group = new GroupData().withName("test2");
  app.group().create(group);
  app.group().returnGroupPage();
  List<GroupData> after = app.group().list();
  Assert.assertEquals(after.size(), before.size() + 1);

  before.add(group);
  Comparator<? super GroupData> ById = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
  before.sort(ById);
  after.sort(ById);
  Assert.assertEquals(before, after);
}

}
