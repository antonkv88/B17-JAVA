package tests;

import model.GroupData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HbConnectionTest {
private SessionFactory sessionFactory;

  @Test
public void hbConnectionTest(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from model.GroupData").list();
    for (GroupData group : result) {
      //System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();
  }

  @BeforeClass
protected void setUp() throws Exception {
  final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
          .configure() // configures settings from hibernate.cfg.xml
          .build();
  try {
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }
  catch (Exception e) {
    e.printStackTrace();
    StandardServiceRegistryBuilder.destroy( registry );
  }
}
}
