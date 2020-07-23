package task02;

public class Main {
  public static void main(String[] args) {
    System.out.println("Расстояние между 2-мя точками (отдельная функция): " + distance(new Point(10,20), new Point (0,0)));

    Point point = new Point(10,20);
    System.out.println("Расстояние между 2-мя точками (метод класса point): " + point.distance( new Point (0,0)));
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt( Math.pow((p1.x - p2.x),2) + Math.pow((p1.y - p2.y),2));
  }

}
