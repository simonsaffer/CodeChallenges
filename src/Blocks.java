import java.util.Scanner;

class Blocks {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int rowNum = sc.nextInt();            //number of rows
    int columnNum = sc.nextInt();         //number of columns

    int blocks = 0;
    char[][] matrix = new char[rowNum][columnNum];


    int nbrOfBlocks = 0;
    for (int a = 0; a < rowNum; a++) {
      matrix[a] = sc.next().toCharArray();

      int index = 0;
      while (index < matrix[a].length) {

        if (matrix[a][index] == '1') {
          ++nbrOfBlocks;
          while (index < matrix[a].length && matrix[a][index] == '1') {
            ++index;
          }
        }

        ++index;
      }
    }

    System.out.println(nbrOfBlocks);



    /*for (char[] chars : matrix) {
      for (char aChar : chars) {
        System.out.print(aChar);
      }
      System.out.println();
    }*/
  }
}
