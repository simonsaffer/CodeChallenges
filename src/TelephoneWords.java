import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*

Given a 7 digit telephone number, print out all the possible sequences of letters that can represent the given telephone number.
Note that in a standard 12 key pad, 0 and 1 do not have any letters associated with them.
They are to be treated as such, i.e. a 0/1 in the telephone number will be retained in the final word as well.
You may use the following mapping between numbers and characters:

0 => 0
1 => 1
2 => abc
3 => def
4 => ghi
5 => jkl
6 => mno
7 => pqrs
8 => tuv
9 => wxyz
INPUT SAMPLE:

Your program should accept as its first argument a path to a filename.The input file contains 7 digit telephone numbers, one per line.*/
public class TelephoneWords {

  private static final int WORD_LENGTH = 7;
  private int[] nbrs;
  private HashMap<Integer, List<Character>> m;
  StringBuffer sb = new StringBuffer();

  public static void main(String[] args){

    List<Integer> a = new ArrayList<Integer>();
    List<Integer> b = null;

    try {
      Scanner sc = new Scanner(new File(args[0]));
      while(sc.hasNext()) {
        TelephoneWords tw = new TelephoneWords();
        tw.run(sc.next());
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void run(String numbers){

    m = new HashMap<Integer, List<Character>>();
    List<Character> l = new ArrayList<Character>() {{add('0');}};

    m.put(0, l);
    l = new ArrayList<Character>(){{add('1');}};
    m.put(1,l);
    l = new ArrayList<Character>(){{add('a');add('b');add('c');}};
    m.put(2,l);
    l = new ArrayList<Character>(){{add('d');add('e');add('f');}};
    m.put(3,l);
    l = new ArrayList<Character>(){{add('g');add('h');add('i');}};
    m.put(4,l);
    l = new ArrayList<Character>(){{add('j');add('k');add('l');}};
    m.put(5,l);
    l = new ArrayList<Character>(){{add('m');add('n');add('o');}};
    m.put(6,l);
    l = new ArrayList<Character>(){{add('p');add('q');add('r');add('s');}};
    m.put(7,l);
    l = new ArrayList<Character>(){{add('t');add('u');add('v');}};
    m.put(8,l);
    l = new ArrayList<Character>(){{add('w');add('x');add('y');add('z');}};
    m.put(9,l);

    nbrs = new int[7];
    for(int i = 0; i < numbers.length(); i++){
      nbrs[i] = Character.getNumericValue(numbers.charAt(i));
    }

    List<Character> result = new ArrayList<Character>();

    genWord(result, 0);

    sb.setLength(sb.length() - 1);

    System.out.println(sb.toString());
  }

  private void genWord(List<Character> result, int idx) {

    if (result.size() == WORD_LENGTH){
      appendString(result);
      return;
    }

    List<Character> chars = m.get(nbrs[idx]);
    for(char c : chars){
      result.add(c);
      genWord(result,idx+1);
      result.remove(idx);
    }


  }

  private void appendString(List<Character> result) {

    for(char c : result){
      sb.append(c);
    }
    sb.append(",");

  }

}
