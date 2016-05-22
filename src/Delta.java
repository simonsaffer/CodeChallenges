import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by simonsaffer on 2016-02-10.
 */
public class Delta {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String all = sc.nextLine();

    List<Integer> numbers = Arrays.stream(all.split(" ")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());

    System.out.print(numbers.get(0));

    for (int i = 1; i < numbers.size(); i++) {

      int diff = numbers.get(i) - numbers.get(i-1);

      if (Math.abs(diff) > 127) {
        System.out.print(128);
      }

      System.out.print(diff);

    }
  }

}
