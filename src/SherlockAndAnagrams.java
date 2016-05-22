import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by simonsaffer on 15-01-06.
 */
public class SherlockAndAnagrams {

  private static HashSet<SubString> subStrings;
  private static HashSet<String> strings;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for (int i = 0; i < T; i++) {

      subStrings = new HashSet<>();
      strings = new HashSet<>();

      String s = sc.next();

      calcNbrOfAnagramPairs(s);

    }

  }

  private static void calcNbrOfAnagramPairs(String s) {


    genSubStrings(0, s.length()-1, s);

    int nbrOfAnagramPairs = 0;
    for (SubString subString : subStrings) {

      String needed;
      if (subString.size() % 2 == 0) {

        needed = new StringBuilder(s.substring(subString.startIndex, subString.endIndex+1)).reverse().toString();


      } else {

       needed = new StringBuilder(s.substring(subString.startIndex, subString.endIndex)).reverse().toString();

      }

      if (strings.contains(needed)) {
        ++nbrOfAnagramPairs;
      }

    }

    System.out.println(nbrOfAnagramPairs);

  }

  private static void genSubStrings(final int start, final int end, final String string) {

    SubString subString = new SubString(start, end);
    if (subStrings.contains(subString) || (end - start < 0)) {

      return;

    } else {

      subStrings.add(subString);
      strings.add(string.substring(subString.startIndex, subString.endIndex +1));

      genSubStrings(start + 1, end, string);
      genSubStrings(start, end-1, string);
    }

  }

}

class SubString {

  public int startIndex, endIndex;

  SubString(int startIndex, int endIndex) {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }

  @Override
  public int hashCode() {
    return Objects.hash(startIndex, endIndex);
  }

  @Override
  public boolean equals(Object obj) {
    SubString other = (SubString) obj;
    return startIndex == other.startIndex && endIndex == other.endIndex;
  }

  public int size() {
    return endIndex - startIndex + 1;
  }
}
