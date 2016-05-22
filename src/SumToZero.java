import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumToZero {

  private static boolean[] usedTerms;
  private static int nbrOfWays;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader(args[0]));

    String line = null;
    while ((line = br.readLine()) != null) {

      nbrOfWays = 0;

      String[] parts = line.split(",");
      int[] terms = new int[parts.length];
      for (int i = 0; i < terms.length; i++){
        terms[i] = Integer.parseInt(parts[i]);
      }
      usedTerms = new boolean[parts.length];

      calcNbrOfWays(terms, 0, 0 ,0);

      System.out.println(nbrOfWays);

    }

  }

  private static void calcNbrOfWays(int[] terms, int index, int sum, int nbrOfUsedElements) {

    if (index == terms.length){
      if (sum == 0 && nbrOfUsedElements == 4){
        ++nbrOfWays;
      }
      return;
    }

    calcNbrOfWays(terms, index+1, sum, nbrOfUsedElements);

    usedTerms[index] = true;
    calcNbrOfWays(terms, index+1, sum+terms[index], nbrOfUsedElements+1);
    usedTerms[index] = false;

  }

}
