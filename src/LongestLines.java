import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by simonsaffer on 14-10-27.
 */
public class LongestLines {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader(args[0]));

    int nbrOfLines = Integer.parseInt(br.readLine());

    ArrayList<String> lines = new ArrayList<>();

    String line = null;
    while ((line = br.readLine()) != null){

      lines.add(line);

    }

    Collections.sort(lines, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
      }
    });

    for (int i = 0; i < nbrOfLines; i++){
      System.out.println(lines.get(i));
    }

  }
}
