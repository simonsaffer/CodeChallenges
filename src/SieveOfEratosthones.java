import java.util.ArrayList;
import java.util.List;

/**
 * Created by simonsaffer on 15-01-19.
 */
public class SieveOfEratosthones {

  public static List<Integer> findPrimes(int N) {

    List<Integer> primes = new ArrayList<>();

    boolean[] markedNumbers = new boolean[N];

    int p = 2;

    while (p < markedNumbers.length) {

      primes.add(p);

      for (int i = p*p; i < markedNumbers.length; i+=p) {

        markedNumbers[i] = true;

      }

      ++p;
      while (p < markedNumbers.length && markedNumbers[p]) {
        ++p;
      }

    }

    return primes;
  }

}
