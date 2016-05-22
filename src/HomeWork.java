import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by simonsaffer on 15-01-17.
 */
public class HomeWork {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new File(args[0]));

    int T = sc.nextInt();

    for (int i = 1; i <= T; i++) {

      int A = sc.nextInt();
      int B = sc.nextInt();
      int K = sc.nextInt();

      int primality = 0;



      System.out.println("Case #" + i + ": " + primality);

    }

  }

}
