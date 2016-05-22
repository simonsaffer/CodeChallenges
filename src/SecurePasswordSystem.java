import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by simonsaffer on 2015-04-09.
 */
public class SecurePasswordSystem {

  public static BigInteger million = BigInteger.valueOf(1000000);

  public static BigInteger factorial(int n){
    if (n==1) return BigInteger.ONE;
    else return factorial(n-1);
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    for (int i = 0; i < N; i++) {

      int minLength = sc.nextInt();
      int maxLength = sc.nextInt();

      BigInteger nbrOfPossibilities = BigInteger.ZERO;


      boolean isSecure = false;
      for (int j = minLength; j <= maxLength; j++) {
        nbrOfPossibilities = nbrOfPossibilities.add(BigInteger.TEN.pow(j));
        if (nbrOfPossibilities.compareTo(million) > 0) {
          isSecure = true;
          break;
        }
      }

      if (isSecure) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }


    }

  }
}
