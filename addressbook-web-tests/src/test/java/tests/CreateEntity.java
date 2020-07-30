package tests;

import appmanager.Emails;
import appmanager.TelephoneNumbers;
import org.testng.annotations.Test;

public class CreateEntity extends TestBase {

  @Test
  public void CreateEntityTest() throws Exception {
    app.getNavigationHelper().gotoAddNewEntity();
    app.getEntityHelper().fillNames("anton", "kozlov");
    app.getEntityHelper().fillNickname("nick");
    app.getEntityHelper().fillTitle( "title");
    app.getEntityHelper().fillCompany("company");
    app.getEntityHelper().fillAddess("address");
    app.getEntityHelper().fillTelephoneNumber(new TelephoneNumbers("222666", "8999999333222", "666222", "2332"));
    app.getEntityHelper().fillEmails(new Emails("test1@mail.ru", "test2@gmail.com", "test3@test.ru"));
    app.getEntityHelper().finishAddNewEntity();
  }

}
