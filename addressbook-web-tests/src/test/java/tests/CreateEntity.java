package tests;

import org.testng.annotations.Test;

public class CreateEntity extends TestBase {

  @Test
  public void CreateEntityTest() throws Exception {
    startAddNewEntity();
    fillNames("anton", "kozlov");
    fillNickname("nick");
    fillTitle( "title");
    fillCompany("company");
    fillAddess("address");
    fillTelephoneNumber(new TelephoneNumbers("222666", "8999999333222", "666222", "2332"));
    fillEmails(new Emails("test1@mail.ru", "test2@gmail.com", "test3@test.ru"));
    finishAddNewEntity();
  }

}
