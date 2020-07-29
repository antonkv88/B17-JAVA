package tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

@Test
  public void testGroupCreation() throws Exception {
  gotoGroupPage();
  initGroupCreation();
  fillGroupCreation(new GroupData("test1", "test2", "test3"));
  submitGroupCreation();
}

}
