import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by simonsaffer on 15-01-17.
 *
 *
 *  In the game of Sports, the object is have more points than the other team after a certain amount of time has elapsed.
 *  Scores are denoted by two hyphen-separated integers. For example, scores may include 3-2, 4-1, or 10-0.
 *  The first number is how many points you've scored, and the second is the number of points scored by the opposing team.
 *  You're very good at Sports, and consequently you always win. However, you don't always achieve victory the same way every time.

 The two most extreme kinds of victory are called stress-free and stressful.
 In a stress-free victory, you score the first point and from then on you always have more points than your opponent.
 In a stressful victory, you never have more points than your opponent until after their score is equal to their final score.

 Given the final score of a game of Sports, how many ways could you arrange the order in which the points are scored such that
 you secure a stress-free or stressful win?

 Input

 Input begins with an integer T, the number of games you'll play. For each game, there is one line containing the final score
 of the game in the format described above.
 Output

 For the ith game, print a line containing "Case #i: " followed by two space-separated integers, the number of ways you can achieve a stress-free or stressful win, respectively. Since these numbers may be very large, output them modulo 1,000,000,007.
 Constraints

 1 ≤ T ≤ 100

 Since you always win, the first number in any final score will always be larger than the second. Both scores will be
 non-negative integers not exceeding 2000.
 Explanation of Sample

 In the third test case, you can get a stress-free win by scoring points 1, 2, and 4, or points 1, 2, and 3. You can get a stressful win by scoring points 2, 4, and 5, or points 3, 4, and 5.

 5
 2-1
 3-1
 3-2
 10-5
 1000-500

 Case #1: 1 1
 Case #2: 2 1
 Case #3: 2 2
 Case #4: 1001 42
 Case #5: 70047606 591137401



 */
public class GameOfSports {

  private static final int MAX_SCORE = 2000;
  private static Long[][] stressTable;
  private static Long[][] stressFreeTable;
  private static int finalScore1;
  private static int finalScore2;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new File(args[0]));

    int T = sc.nextInt();

    for (int i = 1; i <= T; i++) {

      stressTable = new Long[MAX_SCORE+1][MAX_SCORE+1];
      stressTable[0][0] = 0L;

      stressFreeTable = new Long[MAX_SCORE+1][MAX_SCORE+1];

      String score = sc.next();

      String[] parts = score.split("-");

      finalScore1 = Integer.parseInt(parts[0]);
      finalScore2 = Integer.parseInt(parts[1]);

      long nbrOfWaysToReachStressful = stressful(finalScore1, finalScore2);
      long nbrOfWaysToReachStressFree = stressFree(finalScore1, finalScore2);
      System.out.println("Case #" + i + ": " + nbrOfWaysToReachStressFree + " " + nbrOfWaysToReachStressful);

    }

  }

  private static long stressFree(int score1, int score2) {

    if (score1 == score2) {
      return 0;
    }

    if (stressFreeTable[score1][score2] != null) {
      return stressFreeTable[score1][score2];
    }

    long result = 0;
    if (score1-score2 > 1) {
      result += stressFree(score1, score2-1) + 1;
    }
    result += stressFree(score1-1, score2) + 1;

    stressFreeTable[score1][score2] = result;

    return result;

  }

  private static long stressful(int score1, int score2) {
    return 0;
  }

}
