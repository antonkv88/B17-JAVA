package tests;

import org.testng.annotations.Test;

public class CreateEntity extends TestBase {

  @Test
  public void CreateEntityTest() throws Exception {
    app.startAddNewEntity();
    app.fillNames("anton", "kozlov");
    app.fillNickname("nick");
    app.fillTitle( "title");
    app.fillCompany("company");
    app.fillAddess("address");
    app.fillTelephoneNumber(new TelephoneNumbers("222666", "8999999333222", "666222", "2332"));
    app.fillEmails(new Emails("test1@mail.ru", "test2@gmail.com", "test3@test.ru"));
    app.finishAddNewEntity();
  }

}
