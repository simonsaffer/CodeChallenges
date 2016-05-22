import java.util.Arrays;

/**
 * Created by simonsaffer on 2015-09-05.
 */
public class HIndex {

  public static int hIndex(int[] citations) {

    if(citations.length == 0) return 0;

    Arrays.sort(citations);
    int index = -1;
    int hValue = Integer.MAX_VALUE;
    while(index < citations.length-1 && hValue > index+1) {
      ++index;
      hValue = citations[citations.length-1 - index];
    }
    return Math.min(hValue, index+1);
  }

  public static void main(String[] args) throws Exception {

    assertEquals(1, hIndex(new int[]{1}));
    assertEquals(0, hIndex(new int[]{0}));
    assertEquals(1, hIndex(new int[]{100}));
    assertEquals(3, hIndex(new int[]{3, 0, 6, 1, 5}));
  }

  private static void assertEquals(int a, int b) throws Exception {
    if (a != b) throw new Exception(a + "!=" + b);
  }
}
