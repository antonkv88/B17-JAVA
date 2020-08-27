package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {
  @Parameter(names = "-c", description = "Group count")
  public int count;
  @Parameter(names = "-f", description = "Target file")
  public String file;
  @Parameter(names = "-d", description = "Data Format")
  public String format;

  public static void main (String[] args) throws IOException {
    GroupDataGenerator groupGenerator = new GroupDataGenerator();
    JCommander commander =new JCommander(groupGenerator);
    try{
      commander.parse(args);
    }
    catch(ParameterException ex){
      commander.usage();
      return;
    }
    groupGenerator.run();
  }

private void run() throws IOException {
  List<GroupData> groups = generateGroups(count);
  if (format.equals("csv")) {
    saveAsCSV(groups, new File(file));
  } else if (format.equals("xml")) {
    saveAsXML(groups, new File(file));
  } else System.out.print("Unrecognized format " + format);

}

private void saveAsXML(List<GroupData> groups, File file) throws IOException {
  XStream stream = new XStream();
  stream.processAnnotations(GroupData.class);
  String xml = stream.toXML(groups);
  FileWriter writer = new FileWriter(file);
  writer.write(xml);
  writer.close();
}

private void saveAsCSV(List<GroupData> groups, File file) throws IOException {
  FileWriter writer = new FileWriter(file);
  for (GroupData group : groups){
    writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
  }
  writer.close();
}

private List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for (int i = 0; i<count; i++) {
      groups.add(new GroupData().withName(String.format("test %s", i)).withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
    }
    return groups;
}
}