import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WordSearch {

  static HashMap<String, Boolean> m = new HashMap<String, Boolean>();

  static ArrayList<Character> r1 = new ArrayList<Character>(){{add('A'); add('B'); add('C'); add('E');}};
  static ArrayList<Character> r2 = new ArrayList<Character>(){{add('S'); add('F'); add('C'); add('S'); }};
  static ArrayList<Character> r3 = new ArrayList<Character>(){{add('A'); add('D'); add('E'); add('E'); }};
  static ArrayList<ArrayList<Character> > grid = new ArrayList<ArrayList<Character>>(){{add(r1);add(r2);add(r3);}};

  static void tryToGenerateWord(boolean[][] visited, int row, int col, ArrayList<Character> seq){
    if(row >= 0 && row <= 2 && col >= 0 && col <= 3 && !visited[row][col]){

      visited[row][col] = true;
      genWords(visited,row,col,seq);
      visited[row][col] = false;
    }
  }

  static void genWords(boolean[][] visited, int row, int col, ArrayList<Character> seq){

    seq.add(grid.get(row).get(col));

    tryToGenerateWord(visited, row-1, col, seq);
    tryToGenerateWord(visited, row+1, col, seq);
    tryToGenerateWord(visited, row, col-1, seq);
    tryToGenerateWord(visited, row, col+1, seq);

    String word = getString(seq);
    m.put(word, true);

    seq.remove(seq.size() - 1);
  }

  static void addWords(){

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        boolean[][] visited = new boolean[3][4];
        ArrayList<Character> s = new ArrayList<Character>();
        genWords(visited, i,j, s);
      }
    }

  }

  static boolean hasWord(String word){
    return m.containsKey(word);
  }

  public static void main(String[] args) throws IOException {

    addWords();


    BufferedReader br = new BufferedReader(new FileReader(args[0]));

    String lineBuffer = null;
    while ((lineBuffer = br.readLine()) != null)
    {
      if (lineBuffer.length() == 0)
        continue; //ignore all empty lines
      else
      {
        if(hasWord(lineBuffer)){
          System.out.println("True");
        } else {
          System.out.println("False");
        }
      }
    }

  }

    private static String getString(ArrayList<Character> seq) {
      StringBuilder sb = new StringBuilder(seq.size());
      for(Character ch: seq)
      {
        sb.append(ch);
      }
      return sb.toString();
    }


}
