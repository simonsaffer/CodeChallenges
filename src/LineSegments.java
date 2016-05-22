import java.math.BigInteger;
import java.util.Scanner;

public class LineSegments {

  public static BigInteger calcLineSegments(int N){
    BigInteger sum = BigInteger.valueOf(0L);

    for (int i = 1; i < N+1; i++){

      sum = sum.add(BigInteger.valueOf(2L).pow(i));
    }

    return sum.add(BigInteger.valueOf(4L)).mod(BigInteger.valueOf(1000000007L));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int i = 0; i < T; i++){
      int N = sc.nextInt();
      System.out.println(calcLineSegments(N).toString());
    }
  }
}
