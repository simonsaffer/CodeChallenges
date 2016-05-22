/**
 * Created by simonsaffer on 2016-02-23.
 */
public class Mat {
  private static Long[][] results;
  private static int M;
  private static int N;

  static Long getNbrOfRoutes(int[][] a, int x, int y) {

    if (x == N-1 || y == M-1) return 0L;

    Long res = 0L;

    if (a[x+1][y] == 1) {
      res += 1 + getNbrOfRoutes(a, x+1, y);
    }
    if (a[x][y+1] == 1) {
      res += 1 + getNbrOfRoutes(a, x, y+1);
    }

    return res;
  }

  static int numberOfRoutes(int [][]a,int mi,int ni) {
    M = mi;
    N = ni;
    results = new Long[N][M];
    results[0][0] = 1L;
    return (int)(getNbrOfRoutes(a,0,0) % 1000000007);
  }

  public static void main(String[] args) {

    int[][] m = {
      {1, 1, 1, 1},
      {1, 1, 1, 1},
      {1, 1, 1, 1},
      {1, 1, 1, 1}
    };

    System.out.println(numberOfRoutes(m, 2, 3));

  }
}
