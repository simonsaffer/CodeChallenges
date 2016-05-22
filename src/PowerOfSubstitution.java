import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class PowerOfSubstitution {

  public static void main(String[] args) {

    //genProblem();

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    Instant start = Instant.now();

    for (int n = 0; n < N; n++) {

      int L = sc.nextInt();

      Integer[] message = new Integer[L];
      Integer[] cryptoText = new Integer[L];
      for (int i = 0; i < L; i++) {
        message[i] = sc.nextInt();
      }
      for (int i = 0; i < L; i++) {
        cryptoText[i] = sc.nextInt();
      }

      List<Integer> substitutionTable = new ArrayList<>(100);
      substitutionTable.add(null);
      for (int i = 0; i < 100; i++) {
        substitutionTable.add(sc.nextInt());
      }

      int k = 0;
      while (!equal(message, cryptoText)) {
        for (int i = 0; i < L; i++) {
          assert(substitutionTable.get(message[i]) <= 100);
          message[i] = substitutionTable.get(message[i]);
        }
        ++k;
      }

      System.out.println(k);
    }

    Instant end = Instant.now();

    System.out.println("Time: " + Duration.between(start, end).toMillis());

  }

  private static void genProblem() {
    int N = 3;
    int L = 200;
    System.out.println(N);
    for (int i = 0; i < N; i++) {

      System.out.println(L);

      List<Integer> alphabet = new ArrayList<>(100);
      for (int j = 1; j <= 100; j++) {
        alphabet.add(j);
      }
      Collections.shuffle(alphabet);
      List<Integer> substitutionTable = new ArrayList<>(101);
      substitutionTable.add(null);
      substitutionTable.addAll(alphabet);


      int k = 1000000000-1;

      int[] m = new int[L];
      int[] c = new int[L];

      for (int j = 0; j < L; j++) {
        m[j] = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        c[j] = m[j];
        assert(m[j] >= 1 && m[j] <= 100);
      }

      for (int j = 0; j < k; j++) {
        for (int l = 0; l < c.length; l++) {
          c[l] = substitutionTable.get(c[l]);
        }
      }

      System.out.println(Arrays.stream(m).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
      System.out.println(Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
      System.out.println(substitutionTable.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
  }

  private static boolean equal(Integer[] message, Integer[] cryptoText) {
    for (int i = 0; i < message.length; i++) {
      if (message[i] != cryptoText[i]) return false;
    }
    return true;
  }

}
