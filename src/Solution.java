import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    List<WeightedPoint> points = new ArrayList<>(N);
    for (int i = 0; i < N; i++) {
      WeightedPoint point = new WeightedPoint(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }



  }
}

class WeightedPoint {

  public int x, y, w;

  WeightedPoint(int x, int y, int w) {
    this.x = x;
    this.y = y;
    this.w = w;
  }
}
