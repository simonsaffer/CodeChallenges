import java.util.HashMap;

/**
 * Created by simonsaffer on 2016-02-02.
 */
public class ChangePounds {

  int[] coins = new int[] {1, 2, 5, 10, 20, 50, 100, 200};

  public HashMap<Integer, Integer> hm = new HashMap<>();

  public int Execute(int x) {

    hm.put(0, 1);

    for (int i = 1; i <= x; i++) {

      int nbrOfWaysToChangeAmount = 0;
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          nbrOfWaysToChangeAmount += hm.get(i-coins[j]);
        }
      }

      hm.put(i, nbrOfWaysToChangeAmount);

    }

    return hm.get(x);

  }

  public static void main(String[] args) {
    final ChangePounds changePounds = new ChangePounds();

    int fiftyPence = 50;
    int tenPounds = 1000;

    System.out.println(changePounds.Execute(fiftyPence));
    System.out.println(changePounds.Execute(tenPounds));
  }

}
