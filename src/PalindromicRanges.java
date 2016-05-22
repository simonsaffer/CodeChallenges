import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A positive integer is a palindrome if its decimal representation (without leading zeros) is a palindromic string
 * (a string that reads the same forwards and backwards). For example, the numbers 5, 77, 363, 4884, 11111, 12121 and 349943 are palindromes.

 A range of integers is interesting if it contains an even number of palindromes. The range [L, R], with L <= R,
 is defined as the sequence of integers from L to R (inclusive): (L, L+1, L+2, ..., R-1, R). L and R are the range's first and last numbers.

 The range [L1,R1] is a subrange of [L,R] if L <= L1 <= R1 <= R. Your job is to determine how many interesting subranges of [L,R] there are.

 INPUT SAMPLE:

 Your program should accept as its first argument a path to a filename. Each line in this file is one test case.
 Each test case will contain two positive integers, L and R (in that order), separated by a space. eg.
 1 2
 1 7
 87 88
 OUTPUT SAMPLE:

 For each line of input, print out the number of interesting subranges of [L,R] eg.
 1
 12
 1
 For the curious: In the third example, the subranges are: [87](0 palindromes), [87,88](1 palindrome),[88](1 palindrome).
 Hence the number of interesting palindromic ranges is 1
 */
public class PalindromicRanges {

  //private static

  public static void main(String[] args) throws FileNotFoundException {

    Scanner sc = new Scanner(new File(args[0]));

    while (sc.hasNext()) {

      int L = sc.nextInt();
      int R = sc.nextInt();

      int result = findInterestingSubRanges(L,R);

    }

  }

  private static int findInterestingSubRanges(int l, int r) {

    int nbrOfInterestingSubRanges = 0;

    for (int i = l; i <= r; i++) {
      if (isPalindrome(i)) {
        //nbrOfInterestingSubRanges
      }
    }

    return nbrOfInterestingSubRanges;
  }

  private static boolean isPalindrome(int nbr) {

    List<Integer> digits = new ArrayList<>();
    while (nbr != 0) {
      int digit = nbr % 10;
      digits.add(digit);
      nbr /= 10;
    }

    int left = 0;
    int right = digits.size()-1;
    while (left < right) {

      if (digits.get(left) != digits.get(right)) {
        return false;
      }

      ++left;
      --right;
    }

    return true;
  }
}
