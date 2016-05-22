import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubMatrixSums {
  public static void main(String args[] ) throws Exception {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    List<Integer> vals = new ArrayList<>(N);

    for(int n = 0; n < N; n++) {
      vals.add(sc.nextInt());
    }

    List<List<Integer>> matrix = new ArrayList<>(N);

    for(int i = 0; i < N; i++) {
      List<Integer> row = new ArrayList<>(N);
      for(int j = 0; j < N; j++) {
        row.add(vals.get(i)*vals.get(j));
        //System.out.print(row.get(j) + " ");
      }
      //System.out.println();
      matrix.add(row);
    }

    List<List<Integer>> integralImage = new ArrayList<>(N);

    {
      List<Integer> firstRow = new ArrayList<>(N);
      firstRow.add(matrix.get(0).get(0));
      for (int i = 1; i < N; i++) {
        firstRow.add(matrix.get(0).get(i) + firstRow.get(i - 1));
      }
      integralImage.add(firstRow);
    }

    for(int i = 1; i < N; i++) {
      List<Integer> row = new ArrayList<>(N);
      row.add(matrix.get(i).get(0) + integralImage.get(i-1).get(0));
      for(int j = 1; j < N; j++) {
        row.add(row.get(j-1) + integralImage.get(i-1).get(j) + integralImage.get(i-1).get(j-1));
      }
      integralImage.add(row);
    }

    /*for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(integralImage.get(i).get(j) + " ");
      }
      System.out.println();
    }*/

    int nbrOfSumMatrices = 0;

    for (int startX = 0; startX < N; startX++){

      for (int endX = startX; endX < N; endX++) {

        for (int startY = 0; startY < N; startY++) {

          for (int endY = startY; endY < N; endY++) {

            long sum = integralImage.get(endX).get(endY) - integralImage.get(endX).get(startY) -
              integralImage.get(startX).get(endY) + integralImage.get(startX).get(startY);

            if (sum == K) {
              ++nbrOfSumMatrices;
            }

          }

        }

      }

    }

    System.out.println(nbrOfSumMatrices);

  }
}
