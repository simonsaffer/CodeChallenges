import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by simonsaffer on 15-01-05.
 */
public class Tatum {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {

      BigInteger B = sc.nextBigInteger();
      BigInteger W = sc.nextBigInteger();

      BigInteger costOfBlack = sc.nextBigInteger();
      BigInteger costOfWhite = sc.nextBigInteger();
      BigInteger costOfConversion = sc.nextBigInteger();

      BigInteger minCostQuantity, minCost, maxCostQuantity, maxCost;
      if (costOfBlack.compareTo(costOfWhite) < 0) {
        minCostQuantity = B;
        minCost = costOfBlack;
        maxCostQuantity = W;
        maxCost = costOfWhite;
      } else {
        minCostQuantity = W;
        minCost = costOfWhite;
        maxCostQuantity = B;
        maxCost = costOfBlack;
      }

      final BigInteger totalCostOfConversion = minCost.add(costOfConversion);
      BigInteger result = minCostQuantity.multiply(minCost).add(maxCostQuantity.multiply(maxCost.compareTo(totalCostOfConversion) < 0 ?
        maxCost :
        totalCostOfConversion));

      System.out.println(result);

    }

  }
}
