package task02;

public class Point {
  int x = 0;
  int y = 0;

  Point(int x, int y) {this.x = x; this.y = y;}
  public static double distance(Point p1, Point p2) {
    return Math.sqrt( Math.pow((p1.x - p2.x),2) + Math.pow((p1.y - p2.y),2));
  }
}
