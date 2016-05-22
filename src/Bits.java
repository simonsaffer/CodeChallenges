import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by simonsaffer on 2016-03-09.
 */
public class Bits {

  public static long nbrOfSetBits(BitSet bits) {
    long value = 0L;
    for (int i = 0; i < bits.length(); ++i) {
      value += bits.get(i) ? 1L : 0L;
    }
    return value;
  }


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    BitSet bitSet1 = new BitSet(N);
    BitSet bitSet2 = new BitSet(N);

    BitSet[] b = new BitSet[] {null, bitSet1, bitSet2};

    Set<String> bi = new HashSet<>(Arrays.asList("AND", "OR", "XOR"));

    for (int i = 0; i < M; i++) {

      String operation = sc.next();
      int op1 = sc.nextInt();
      int op2 = sc.nextInt();

      BitSet b1 = b[op1];
      BitSet b2 = null;

      if (bi.contains(operation)) {
        b2 = b[op2];
      }

      switch (operation) {
        case "AND":
          b1.and(b2);
          break;
        case "XOR":
          b1.xor(b2);
          break;
        case "OR":
          b1.or(b2);
          break;
        case "FLIP":
          b1.flip(op2);
          break;
        case "SET":
          b1.set(op2);
          break;
      }

      System.out.println(nbrOfSetBits(b[1]) + " " + nbrOfSetBits(b[2]));


    }

  }
}
