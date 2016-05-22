import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by simonsaffer on 2015-04-11.
 */
public class InfiniteHouseOfPancakes {

  private int minTime;

  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(new File(args[0]));

    int T = sc.nextInt();

    PrintWriter writer = new PrintWriter("pancakes.txt", "UTF-8");

    for (int i = 1; i <= T; i++) {

      int D = sc.nextInt();

      List<Integer> nbrOfPancakes = new ArrayList<>(D);

      for (int j = 0; j < D; j++) {
        nbrOfPancakes.add(sc.nextInt());
      }

      InfiniteHouseOfPancakes infiniteHouseOfPancakes = new InfiniteHouseOfPancakes();

      int nbrOfMinutes = infiniteHouseOfPancakes.calcNbrOfMinutes(nbrOfPancakes, 0);


      writer.println("Case #" + i + ": " + nbrOfMinutes);
    }

    writer.close();
  }

  private int calcNbrOfMinutes(List<Integer> nbrOfPancakes, int nbrOfMinutes) {

    for (int i = 0; i < nbrOfPancakes.size(); i++) {

    }

    List<Integer> cpy = new ArrayList<>();

    for (int i = 0; i < nbrOfPancakes.size(); i++) {
      cpy.add(nbrOfPancakes.get(i) - 1);
    }

    calcNbrOfMinutes(cpy, nbrOfMinutes+1);
    return 0;
  }
}
