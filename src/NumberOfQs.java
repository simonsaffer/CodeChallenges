import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class NumberOfQs {

  private static int MAX_RADIUS = 1000000;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    List<Integer> radii = new ArrayList<Integer>(N);
    for (int i = 0; i < N; i++) {
      int radius = sc.nextInt();
      radii.add(radius);
    }

    Collections.sort(radii, Collections.reverseOrder());

    int M = sc.nextInt();
    List<Line> lines = new ArrayList<Line>(M);
    for (int i = 0; i < M; i++) {

      int x1 = sc.nextInt();
      int y1 = sc.nextInt();

      double d1 = Math.sqrt(x1*x1+y1*y1);

      int x2 = sc.nextInt();
      int y2 = sc.nextInt();

      double d2 = Math.sqrt(x2*x2+y2*y2);

      double startDist = Math.min(d1, d2);
      double endDist = Math.max(d1, d2);

      lines.add(new Line(startDist, endDist));

    }



    Collections.sort(lines, new Comparator<Line>() {
      @Override
      public int compare(Line o1, Line o2) {
        return Double.compare(o1.startDistFromOrigin, o2.startDistFromOrigin);
      }
    });


    int nbrOfQs = 0;
    int lineIndex = lines.size()-1;
    for (int radius : radii) {

        while (lineIndex >= 0 && lines.get(lineIndex).startDistFromOrigin > radius) {
          --lineIndex;
        }

        for (int idx = lineIndex; idx >= 0; --idx) {

          if (lineCrossesCircle(lines.get(idx), radius)) {
            ++nbrOfQs;
          }

        }

    }


    System.out.println(nbrOfQs);
  }

  public static boolean lineCrossesCircle(Line line, int circleRadius) {

    return line.startDistFromOrigin < circleRadius &&
      line.endDistFromOrigin > circleRadius;

  }

}

class Line {
  public double startDistFromOrigin, endDistFromOrigin;

  Line(double startDistFromOrigin, double endDistFromOrigin) {
    this.startDistFromOrigin = startDistFromOrigin;
    this.endDistFromOrigin = endDistFromOrigin;
  }
}
