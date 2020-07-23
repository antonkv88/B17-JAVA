package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import task02.Point;

public class Tests {

  @Test
  public void distanceOK01 () {
    Point point = new Point(10,20);
    Assert.assertEquals(point.distance(new Point (0,0)),22.360679774997898);
  }
  @Test
  public void distanceOK02 () {
    Point point = new Point(0,0);
    Assert.assertEquals(point.distance(new Point (10,20)),22.360679774997898);
  }

  @Test
  public void distanceFAIL01 () {
    Point point = new Point(10,20);
    Assert.assertEquals(point.distance(new Point (0,0)),22.36);
  }

  @Test
  public void distanceFAIL02 () {
    Point point = new Point(0,0);
    Assert.assertEquals(point.distance(new Point (0,0)),0.1);
  }
}
