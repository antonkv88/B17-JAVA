package tests;

import com.thoughtworks.xstream.XStream;
import model.GroupData;
import model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreatGroupTest extends TestBase {

@DataProvider
public Iterator<Object[]> validGroups() throws IOException {
  BufferedReader reader = new BufferedReader (new FileReader(new File("src/test/resources/group.xml")));
  String xml = "";
  String line = reader.readLine();
  while (line != null) {
    xml += line;
    line = reader.readLine();
  }
  XStream stream = new XStream();
  stream.processAnnotations(GroupData.class);
  List<GroupData> groups = (List<GroupData>)stream.fromXML(xml);
  return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
}

@Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) throws Exception {
  app.goTo().groupPage();
  Groups before = app.group().all();;
  app.group().create(group);
  app.group().returnGroupPage();
  Groups after = app.group().all();
  assertThat(after.size(), equalTo(before.size() + 1));
  assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
}

}
