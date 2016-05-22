import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Created by simonsaffer on 2016-01-21.
 */
public class PairsK {

  static int NumberOfPairs(int[] a, long k) {

    LinkedHashSet<Long> vals = new LinkedHashSet<Long>();

    Arrays.sort(a);

    int nbrOfPairs = 0;
    for(int i : a) {
      if(i*2 != k && vals.contains(k-i)) {
        ++nbrOfPairs;
      }
      vals.add((long) i);
    }

    return nbrOfPairs;
  }

  public static void main(String[] args) {

    System.out.println(NumberOfPairs(new int[]{6,6,3,9,3,5,1}, 12));

  }
}
