package task02;

public class Point {
  int x = 0;
  int y = 0;

  public Point(int x, int y) {this.x = x; this.y = y;}
  public double distance( Point point) {
    return Math.sqrt( Math.pow((this.x - point.x),2) + Math.pow((this.y - point.y),2));
  }
}
