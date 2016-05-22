import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by simonsaffer on 2016-02-10.
 */
public class Pairs {

  private static boolean hasPairs(List<Integer> numbers, int N) {
    LinkedHashSet<Long> vals = new LinkedHashSet<Long>();

    Collections.sort(numbers);

    for(Integer i : numbers) {
      if(i*2 != N && vals.contains(N-i)) {
        return true;
      }
      vals.add((long) i);
    }

    return false;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    List<Integer> numbers = new ArrayList<>(M);
    for (int i = 0; i < M; i++) {
      numbers.add(sc.nextInt());
    }

    System.out.println(hasPairs(numbers, N) ? 1 : 0);

  }

}
