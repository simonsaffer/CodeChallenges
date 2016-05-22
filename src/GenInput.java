import java.util.Random;

/**
 * Created by simonsaffer on 15-01-09.
 */
public class GenInput {

  public static void main(String[] args) {

    System.out.println(20);
    Random random = new Random();

    for (int i = 0; i < 20; i++) {

      System.out.println(845 + " " + 900 + " " + 600);
      System.out.println(20);

      for (int j = 0; j < 20; j++) {
        System.out.println(genNbr(random) + " " + genNbr(random) + " " + genNbr(random));
      }

    }

  }

  private static int genNbr(Random random) {
    return random.nextInt(100) + 10;
  }

}
