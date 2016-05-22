import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TextToNumber {

  public static final String MILLION = "million";
  public static final String THOUSAND = "thousand";
  public static final String HUNDRED = "hundred";
  private static HashMap<String, Integer> smap;
  private static HashMap<String, Integer> map;

  public static void main(String[] args) throws IOException {

    smap = new HashMap<>();
    smap.put("million", 1000000);
    smap.put("thousand", 1000);
    smap.put("hundred", 100);

    map = new HashMap<String, Integer>();
    map.put("zero", 0);
    map.put("one", 1);
    map.put("two", 2);
    map.put("three", 3);
    map.put("four", 4);
    map.put("five", 5);
    map.put("six", 6);
    map.put("seven", 7);
    map.put("eight", 8);
    map.put("nine", 9);
    map.put("ten", 10);
    map.put("eleven", 11);
    map.put("twelve", 12);
    map.put("thirteen", 13);
    map.put("fourteen", 14);
    map.put("fifteen", 15);
    map.put("sixteen", 16);
    map.put("seventeen", 17);
    map.put("eighteen", 18);
    map.put("nineteen", 19);
    map.put("twenty", 20);
    map.put("thirty", 30);
    map.put("forty", 40);
    map.put("fifty", 50);
    map.put("sixty", 60);
    map.put("seventy", 70);
    map.put("eighty", 80);
    map.put("ninety", 90);

    BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));

    String line = null;
    while ((line = br.readLine()) != null) {

      String[] words = line.split(" ");

      int index = 0;
      boolean negative = false;
      if (words[0].equals("negative")){
        negative = true;
        index = 1;
      }

      List<String> numbers = new ArrayList<>(words.length);
      for (int i = index; i < words.length; i++) {
        numbers.add(words[i]);
      }

      int total = calcVal(numbers);
      if (negative) {
        total *= -1;
      }
      System.out.println(total);

    }

  }

  private static int calcVal(List<String> words) {

    int millionIndex = words.indexOf(MILLION);


    if (millionIndex != -1) {
      return doCalcVal(words, millionIndex, MILLION);
    }

    int thousandIndex = words.indexOf(THOUSAND);
    if (thousandIndex != -1) {
      return doCalcVal(words, thousandIndex, THOUSAND);
    }

    int hundredIndex = words.indexOf(HUNDRED);
    if (hundredIndex != -1) {
      return doCalcVal(words, hundredIndex, HUNDRED);
    }

    int result = 0;
    for (String number : words) {
      result += map.get(number);
    }

    return result;

  }

  private static int doCalcVal(List<String> words, int index, String number) {
    int result = calcVal(words.subList(0, index))*smap.get(number);
    if (index < words.size()-1) {
      result += calcVal(words.subList(index +1, words.size()));
    }
    return result;
  }

}
