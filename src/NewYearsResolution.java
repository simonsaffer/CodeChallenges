import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 *  Alex's New Year's resolution for 2015 is to eat healthier foods. He's done some research and has found out that calories come
 *  from three main sources, called macronutrients: protein, carbohydrates, and fat. Alex wants to get the right balance of
 *  protein, carbohydrates, and fat to have a balanced diet. For each available food, Alex can only choose to eat it or not eat it.
 *  He can't eat a certain food more than once, and he can't eat a fractional amount of a food.

 Input

 Input beings with an integer T, the number of test cases. For each test case, the first line consists of three space-separated
 integers: GP, GC, and GF, which represent the amount of protein, carbohydrates, and fat that Alex wants to eat.
 The next line has the number of foods for that test case, an integer N. The next N lines each consist of three space-separated
 integers: P, C, and F, which represent the amount of protein, carbohydrates, and fat in that food, respectively.

 Output

 For each test case i, print a line containing "Case #i: " followed by either "yes" if it is possible for Alex to eat the exact
 amount of each macronutrient, or "no" if it is not possible.
 Constraints

 1 ≤ T ≤ 20
 1 ≤ N ≤ 20
 10 ≤ GP, GC, GF ≤ 1000
 10 ≤ P, C, F ≤ 1000


 INPUT

 5
 100 100 100
 1
 100 100 100
 100 100 100
 3
 10 10 40
 10 30 10
 10 60 50
 100 100 100
 5
 40 70 30
 30 10 40
 20 20 50
 10 50 90
 40 10 20
 292 264 512
 20
 909 302 261
 705 597 823
 291 51 126
 28 697 57
 593 31 826
 311 256 57
 292 14 47
 29 730 716
 12 529 146
 768 16 439
 37 472 15
 350 192 34
 163 468 238
 69 173 10
 203 72 690
 424 875 213
 223 593 292
 151 46 10
 88 90 16
 773 653 711
 991 827 352
 20
 29 560 929
 139 681 102
 144 853 10
 84 729 80
 218 20 67
 140 80 901
 428 20 500
 520 970 128
 422 419 30
 413 101 192
 467 448 501
 32 939 684
 34 20 38
 251 317 132
 588 437 10
 648 21 79
 391 25 14
 499 22 24
 854 77 361
 405 25 20

 OUPUT

 Case #1: yes
 Case #2: no
 Case #3: yes
 Case #4: no
 Case #5: yes

 */
public class NewYearsResolution {

  private final FoodTripple GOAL;

  private final FoodTripple[] foods;

  public NewYearsResolution(FoodTripple GOAL, FoodTripple[] foods) {
    this.GOAL = GOAL;
    this.foods = foods;
  }

  private boolean isMatch(int index, FoodTripple aggregate) {

    if (aggregate.isZero()) {
      return true;
    }

    if (index == 0) {
      return FoodTripple.isEqualValue(foods[0], aggregate);
    }

    if (aggregate.hasNegativeComponent()) {
      return false;
    }

    return isMatch(index-1, aggregate.sub(foods[index])) ||
      isMatch(index-1, aggregate);

  }

  public boolean canEat() {

    return isMatch(foods.length-1, GOAL);

  }

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new File(args[0]));

    int T = sc.nextInt();

    for (int i = 1; i <= T; i++) {

      final int GP = sc.nextInt();
      final int GC = sc.nextInt();
      final int GF = sc.nextInt();

      final FoodTripple GOAL = new FoodTripple(GP, GC, GF);

      final int N = sc.nextInt();

      final FoodTripple[] foods = new FoodTripple[N];

      for (int j = 0; j < N; j++) {

        foods[j] = new FoodTripple(sc.nextInt(), sc.nextInt(), sc.nextInt());

      }


      NewYearsResolution newYearsResolution = new NewYearsResolution(GOAL, foods);


      System.out.println("Case #" + i + ": " + (newYearsResolution.canEat() ? "yes" : "no"));
    }

  }
}

class FoodTripple {

  private int P, C, F;

  public FoodTripple(int p, int c, int f) {
    P = p;
    C = c;
    F = f;
  }

  public boolean isZero() {
    return P == 0 && C == 0 && F == 0;
  }

  public FoodTripple sub(final FoodTripple other) {
    return new FoodTripple(this.P - other.P, this.C - other.C, this.F - other.F);
  }

  public static boolean isEqualValue(final FoodTripple ft1, final FoodTripple ft2) {
    return ft1.P == ft2.P && ft1.C == ft2.C && ft1.F == ft2.F;
  }

  @Override
  public String toString() {
    return P + ", " + C + ", " + F;
  }

  public boolean hasNegativeComponent() {
    return P < 0 || C < 0 || F < 0;
  }
}
