import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by simonsaffer on 2015-04-10.
 */
public class ByteBlocks {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    while (sc.hasNextInt()) {

      int N = sc.nextInt();

      List<String> blocks = new ArrayList<>(N);
      for (int i = 0; i < N; i++) {
        blocks.add(sc.next());
      }

      boolean[][] possibleMatches = new boolean[N][N];

      for (int i = 0; i < blocks.size(); i++) {
        for (int j = 0; j < blocks.size(); j++) {
          if (i != j && isPossibleMatch(blocks.get(i), blocks.get(j))) {
            possibleMatches[i][j] = true;
          } else {
            possibleMatches[i][j] = false;
          }
        }
      }



    }
  }

  /*bool bpm(bool bpGraph[M][N], int u, bool seen[], int matchR[])
  {
    // Try every job one by one
    for (int v = 0; v < N; v++)
    {
      // If applicant u is interested in job v and v is
      // not visited
      if (bpGraph[u][v] && !seen[v])
      {
        seen[v] = true; // Mark v as visited

        // If job 'v' is not assigned to an applicant OR
        // previously assigned applicant for job v (which is matchR[v])
        // has an alternate job available.
        // Since v is marked as visited in the above line, matchR[v]
        // in the following recursive call will not get job 'v' again
        if (matchR[v] < 0 || bpm(bpGraph, matchR[v], seen, matchR))
        {
          matchR[v] = u;
          return true;
        }
      }
    }
    return false;
  }

  // Returns maximum number of matching from M to N
  int maxBPM(bool bpGraph[M][N])
  {
    // An array to keep track of the applicants assigned to
    // jobs. The value of matchR[i] is the applicant number
    // assigned to job i, the value -1 indicates nobody is
    // assigned.
    int matchR[N];

    // Initially all jobs are available
    memset(matchR, -1, sizeof(matchR));

    int result = 0; // Count of jobs assigned to applicants
    for (int u = 0; u < M; u++)
    {
      // Mark all jobs as not seen for next applicant.
      bool seen[N];
      memset(seen, 0, sizeof(seen));

      // Find if the applicant 'u' can get a job
      if (bpm(bpGraph, u, seen, matchR))
        result++;
    }
    return result;
  }*/
  int calcNbrOfTransmissions(final int nbrOfBlocks, final boolean[][] possibleMatches) {

    // http://www.geeksforgeeks.org/maximum-bipartite-matching/
    HashMap<Integer, Integer> pairs = new HashMap<>(nbrOfBlocks);

    int nbrOfPairs;
    for (int i = 0; i < nbrOfBlocks; i++) {

      boolean[] triedPairs = new boolean[nbrOfBlocks];


      if (findMatch(possibleMatches, i, triedPairs, pairs)) {

      }
    }
    return Integer.MIN_VALUE;
  }

  private boolean findMatch(boolean[][] possibleMatches, int i, boolean[] triedPairs, HashMap<Integer, Integer> pairs) {
    return false;
  }

  private static boolean isPossibleMatch(String block1, String block2) {
    String combo = block1+block2;

    int left = 0;
    int right = combo.length()-1;

    while (left < right) {
      if (combo.charAt(left) != combo.charAt(right)) {
        return false;
      }
    }
    return true;
  }

}
