import java.lang.*;

public class RobotMovement {

  private static final int GRID_SIZE = 2;

  private static int[][] dp = new int[GRID_SIZE][GRID_SIZE];
  private static boolean[][] visited = new boolean[GRID_SIZE][GRID_SIZE];
  private static int nbrOfWays = 0;

  private static void tryPath(int x, int y){
    if(!(x == GRID_SIZE || y == GRID_SIZE || x < 0 || y < 0 || visited[x][y])){
      backTrack(x, y);
    }
  }

  private static void backTrack(int x, int y){

    if(x == GRID_SIZE-1 && y == GRID_SIZE-1){
      ++nbrOfWays;
    } else {

      visited[x][y] = true;

      int result = 0;

      tryPath(x + 1, y);
      tryPath(x - 1, y);
      tryPath(x, y + 1);
      tryPath(x, y - 1);

      visited[x][y] = false;
    }
  }

  /*public static void main (String[] args) {

    backTrack(0, 0);
    System.out.println(nbrOfWays);

  }*/
}
