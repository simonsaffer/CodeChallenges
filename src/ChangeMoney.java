import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by simonsaffer on 2015-04-29.
 */
public class ChangeMoney {

  private Set<List<Integer>> solutions = new HashSet<>();
  private ArrayList<Integer> coins;
  private HashMap<Integer, Long> dp = new HashMap<>();

  public ChangeMoney(ArrayList<Integer> coins) {
    this.coins = coins;
  }

  private long getUniqueSolutions(int x, List<Integer> usedCoins) {

    if (dp.containsKey(x)) {
      return dp.get(x);
    } else if (x < 0) {
      return 0;
    } else if (x == 0) {
      if (!solutions.contains(usedCoins)) {
        solutions.add(usedCoins);
        return 1;
      } else {
        return 0;
      }
    } else {
      long nbrOfWays = coins.stream()
        .filter(i -> i <= x)
        .mapToLong(i -> getUniqueSolutions(x-i, add(i, usedCoins)))
        .sum();
      dp.put(x, nbrOfWays);
      return nbrOfWays;
    }

  }

  private List<Integer> add(Integer i, List<Integer> set) {
    List<Integer> newSet = new ArrayList<>(set.size()+1);
    newSet.addAll(set);
    newSet.add(i);
    return newSet;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    ArrayList<Integer> coins = new ArrayList<>(M);
    for (int i = 0; i < M; i++) {
      coins.add(sc.nextInt());
    }
    Collections.sort(coins);

    ChangeMoney cm = new ChangeMoney(coins);
    long l = cm.getUniqueSolutions(N, new ArrayList<>());

    System.out.println(cm.solutions.size());
    //System.out.println(l);

  }

}
