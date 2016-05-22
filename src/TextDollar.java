import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TextDollar {

  public static HashMap<Integer,String> map;

  public static void main(String[] args) throws FileNotFoundException {

    Scanner sc = new Scanner(new File(args[0]));

    map = new HashMap<Integer,String>();
    map.put(1,"One");
    map.put(2,"Two");
    map.put(3,"Three");
    map.put(4,"Four");
    map.put(5,"Five");
    map.put(6,"Six");
    map.put(7,"Seven");
    map.put(8,"Eight");
    map.put(9,"Nine");
    map.put(10,"Ten");
    map.put(11,"Eleven");
    map.put(12,"Twelve");
    map.put(13,"Thirteen");
    map.put(14,"Fourteen");
    map.put(15,"Fifteen");
    map.put(16,"Sixteen");
    map.put(17,"Seventeen");
    map.put(18,"Eighteen");
    map.put(19,"Nineteen");
    map.put(20,"Twenty");
    map.put(30,"Thirty");
    map.put(40,"Forty");
    map.put(50,"Fifty");
    map.put(60,"Sixty");
    map.put(70,"Seventy");
    map.put(80,"Eighty");
    map.put(90,"Ninety");

    while (sc.hasNext()){

      List<String> parts = new ArrayList<String>();
      String str = sc.next();
      parts.add("Dollars");

      if (str.equals("0")){
        System.out.println("ZeroDollars");
        continue;
      }

      convertToWords(str, parts);

      for (int i = parts.size()-1; i >= 0; --i) {
        System.out.print(parts.get(i));
      }
      System.out.println();
    }

  }

  private static void convertToWords(String str, List<String> parts) {

    if (str.length() == 1) {

      int nbr = Integer.parseInt(str);
      appendNbr(parts, nbr);

    } else if (str.length() == 2){

      int nbr = Integer.parseInt(str.substring(0,2));

      if (nbr > 10 && nbr < 20) {
        appendNbr(parts, nbr);
      } else {

        nbr = Integer.parseInt(str.substring(0,1))*10;
        convertToWords(str.substring(1), parts);

        appendNbr(parts, nbr);

      }

    } else if (str.length() == 3) {

      convertToWords(str.substring(1), parts);

      int nbr = Integer.parseInt(str.substring(0,1));
      if (nbr > 0) {
        parts.add("Hundred");
      }
      appendNbr(parts, nbr);

    } else if (str.length() > 6) {

      convertToWords(str.substring(str.length()-6), parts);

      parts.add("Million");
      convertToWords(str.substring(0, str.length() - 6), parts);

    } else if (str.length() > 3) {

      convertToWords(str.substring(str.length()-3), parts);

      if (!str.substring(0,3).equals("000")) {
        parts.add("Thousand");
      }
      convertToWords(str.substring(0,str.length()-3), parts);
    }

  }

  private static void appendNbr(List<String> parts, int nbr) {
    if (nbr > 0) {
      parts.add(map.get(nbr));
    }
  }

}
