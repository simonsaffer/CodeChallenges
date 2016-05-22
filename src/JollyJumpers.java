import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class JollyJumpers {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader(args[0]));

    String line = null;
    while ((line = br.readLine()) != null){

      Scanner sc = new Scanner(line);

      int N = sc.nextInt();

      List<Integer> diffList = new ArrayList<>(N);

      int lastNbr = sc.nextInt();

      boolean isJollyJumper = true;
      for (int i = 1; i < N; i++){

        int nbr = sc.nextInt();

        int diff = Math.abs(lastNbr-nbr);

        diffList.add(diff);

        lastNbr = nbr;

      }

      Collections.sort(diffList);
      for (int i = 1; i < N; i++) {

        if (diffList.get(i-1) != i) {
          isJollyJumper = false;
          break;
        }
      }

      if (isJollyJumper){
        System.out.print(N + " - ");
        for (int i : diffList){
          System.out.print(i + " ");
        }
      }

      System.out.println((isJollyJumper ? "Jolly" : "Not Jolly"));

    }

  }
}
