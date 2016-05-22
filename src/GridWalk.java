import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a monkey which can walk around on a planar grid. The monkey can move one space at a time left, right, up or down.
 * That is, from (x, y) the monkey can go to (x+1, y), (x-1, y), (x, y+1), and (x, y-1).
 * Points where the sum of the digits of the absolute value of the x coordinate plus the sum of the digits of the absolute
 * value of the y coordinate are lesser than or equal to 19 are accessible to the monkey. For example, the point (59, 79) is
 * inaccessible because 5 + 9 + 7 + 9 = 30, which is greater than 19. Another example: the point (-5, -7) is accessible
 * because abs(-5) + abs(-7) = 5 + 7 = 12, which is less than 19. How many points can the monkey access if it starts at (0, 0),
 * including (0, 0) itself?

 INPUT SAMPLE:

 There is no input for this program.

 OUTPUT SAMPLE:

 Print the number of points the monkey can access.
 It should be printed as an integer — for example, if the number of points is 10, print "10", not "10.0" or "10.00", etc.


 */
public class GridWalk {

  private static HashSet<Point> visitedPoints;

  public static void main(String[] args) {

    visitedPoints = new HashSet<Point>();

    long accessiblePoints = nbrOfAccessiblePoints();

    System.out.println(accessiblePoints);

  }

  private static long nbrOfAccessiblePoints() {



    Point start = new Point(0,0);

    Queue<Point> q = new LinkedList<>();
    q.add(start);

    long sum = 0;

    while (!q.isEmpty()) {

      Point here = q.poll();
      ++sum;
      System.out.println(visitedPoints.size() + ", " + q.size());

      visitedPoints.add(here);



      Point p = new Point(here.x + 1, here.y);
      if (!visitedPoints.contains(p) && isAccessible(p))
        q.add(p);

      p = new Point(here.x - 1, here.y);
      if (!visitedPoints.contains(p) && isAccessible(p))
        q.add(p);

      p = new Point(here.x, here.y + 1);
      if (!visitedPoints.contains(p) && isAccessible(p))
        q.add(p);

      p = new Point(here.x, here.y - 1);
      if (!visitedPoints.contains(p) && isAccessible(p))
        q.add(p);
    }

    return sum;
  }

  public static boolean isAccessible(Point p) {
    return sumOfDigits((int) Math.abs(p.x)) + sumOfDigits((int) Math.abs(p.y)) <= 19;
  }

  private static long sumOfDigits(int nbr) {
    int sum = 0;
    while (nbr != 0) {
      sum += nbr % 10;
      nbr /= 10;
    }
    return sum;
  }

}

class Point{

  public int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object obj) {
    Point p = (Point) obj;
    return x == p.x && y == p.y;
  }

  @Override
  public int hashCode() {
    int hash = 23;
    hash = hash * 31 + Integer.hashCode(x);
    hash = hash * 31 + Integer.hashCode(y);
    return hash;
  }

  @Override
  public String toString() {
    return x + "," + y;
  }

  public boolean isAccessible() {
    return sumOfDigits((int) Math.abs(x)) + sumOfDigits((int) Math.abs(y)) <= 19;
  }

  private static long sumOfDigits(int nbr) {
    int sum = 0;
    while (nbr != 0) {
      sum += nbr % 10;
      nbr /= 10;
    }
    return sum;
  }

}
