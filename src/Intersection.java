import java.math.BigDecimal;

public class Intersection {

  private double area(int r) {
    return Math.PI * r * r;
  }

  public double solution(int x1, int y1, int r1, int x2, int y2, int r2) {

    int xDiff = x1-x2;
    int yDiff = y1-y2;

    BigDecimal distSquared = new BigDecimal(xDiff*xDiff + yDiff*yDiff);

    if (x1 == x2 && y1 == y2) return area(Math.min(r1, r2));

    /*BigDecimal dist = new BigDecimal(Math.sqrt(distSquared));

    BigDecimal r2Squared = new BigDecimal(r2*r2);
    BigDecimal r1Squared = new BigDecimal(r1*r1);
    double result = (r2Squared * Math.acos((distSquared.add(r2Squared).add(r1Squared.negate()).divide (new BigDecimal(2) * dist
      * r2))) +
      (r1Squared * Math.acos((distSquared + r1Squared - r2Squared) / (2 * dist * r1))) -
        (0.5 * Math.sqrt((-dist+r2+r1)*(dist+r2-r1)*(dist-r2+r1)*(dist+r2+r1)));

    return result;*/

    return 0;
  }

  public static void main(String[] args) {

    Intersection i = new Intersection();

    System.out.println(i.solution(-200000, -200000, 200000, 200000, 200000, 200000));

  }

}
