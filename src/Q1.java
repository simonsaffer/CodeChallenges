import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by simonsaffer on 2016-02-10.
 */
public class Q1 {

  private static boolean isSquare(int A, int B, int C, int D) {
    return A == B && B == C && C == D;
  }

  private static boolean isRectangle(int A, int B, int C, int D) {
    return A == C && B == D;
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long squares = 0;
    long rectangles = 0;
    long other = 0;

    String line;
    while ((line = br.readLine()) != null) {

      List<Integer> sides = Arrays.stream(line.split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());

      int A = sides.get(0);
      int B = sides.get(1);
      int C = sides.get(2);
      int D = sides.get(3);

      if (A < 0 || B < 0 || C < 0 || D < 0) {
        ++other;
      } else if (isSquare(A,B,C,D)) {
        ++squares;
      } else if (isRectangle(A,B,C,D)) {
        ++rectangles;
      } else {
        ++other;
      }

    }

    System.out.println(squares + " " + rectangles + " " + other);

  }
}
