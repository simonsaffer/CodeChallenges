import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Mines {

  private static final int MINE = -1;
  private static final int CLEAR = 0;
  private static int[][] grid;
  private static int nbrOfCols;
  private static int nbrOfRows;

  public static void main(String[] args){

    try {
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));

      String line = null;

      while ((line = reader.readLine()) != null) {

        String[] parts = line.split(";");

        String gridStr = parts[1];

        String[] rcStrs = parts[0].split(",");
        nbrOfRows = Integer.parseInt(rcStrs[0]);
        nbrOfCols = Integer.parseInt(rcStrs[1]);

        grid = new int[nbrOfRows][nbrOfCols];

        int index = 0;
        for (int i = 0; i < nbrOfRows; i++) {
          for (int j = 0; j < nbrOfCols; j++){
            grid[i][j] = gridStr.charAt(index) == '*' ? MINE : CLEAR;
            ++index;
          }
        }

        String[][] outputGrid = new String[nbrOfRows][nbrOfCols];

        for (int i = 0; i < nbrOfRows; i++) {
          for (int j = 0; j < nbrOfCols; j++){
            if (grid[i][j] == MINE){
              outputGrid[i][j] = "*";
            } else {
              outputGrid[i][j] = Integer.toString(calcNbrOfMines(i, j));
            }
          }
        }

        index = 0;
        for (int i = 0; i < nbrOfRows; i++) {
          for (int j = 0; j < nbrOfCols; j++){
            if (grid[i][j] == MINE){
              System.out.print('*');
            } else {
              System.out.print(outputGrid[i][j]);
            }
            ++index;
          }
        }

        System.out.println();
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static int calcNbrOfMines(int x, int y) {

    int nbrOfMines = 0;
    for (int i = -1; i <= 1; i++){
      for (int j = -1; j <= 1; j++){
        if (hasMine(x+i,y+j)) ++nbrOfMines;
      }
    }

    return nbrOfMines;
  }

  private static boolean hasMine(int i, int j) {
    return 0 <= i && i < nbrOfRows && 0 <= j && j < nbrOfCols && grid[i][j] == MINE;
  }

}
