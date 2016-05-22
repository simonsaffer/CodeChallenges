import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SkyScrapers {

  public static final String integerPattern = "[0-9]{1,10}";
  public static final Pattern buildingPattern = Pattern.compile("\\((" + integerPattern + "),(" + integerPattern + ")," +
    "(" + integerPattern + ")\\);");

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

    String line = null;
    while ((line = br.readLine()) != null) {

      List<Building> buildings = new ArrayList<>();

      Matcher matcher = buildingPattern.matcher(line);

      int farRight = Integer.MIN_VALUE;
      int farLeft = Integer.MAX_VALUE;

      while (matcher.find()) {
        int L = Integer.parseInt(matcher.group(1));
        int H = Integer.parseInt(matcher.group(2));
        int R = Integer.parseInt(matcher.group(3));

        if (L < farLeft) farLeft = L;
        if (R > farRight) farRight = R;

        buildings.add(new Building(L,H,R));
      }

      drawSkyLine(buildings, farLeft, farRight);

    }
  }

  private static void drawSkyLine(List<Building> buildings, int farLeft, int farRight) {

    List<Building> leftSorted = new ArrayList<>(buildings);
    Collections.sort(leftSorted, new Comparator<Building>() {
      @Override
      public int compare(Building o1, Building o2) {
        return Integer.compare(o1.L, o2.L);
      }
    });

    List<Building> rightSorted = new ArrayList<>(buildings);
    Collections.sort(rightSorted, new Comparator<Building>() {
      @Override
      public int compare(Building o1, Building o2) {
        return Integer.compare(o1.R, o2.R);
      }
    });

    PriorityQueue<Building> currentBuildings = new PriorityQueue<>(new Comparator<Building>(){

      @Override
      public int compare(Building o1, Building o2) {
        return Integer.compare(o1.H, o2.H);
      }
    });

    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < buildings.size()) {



    }

  }


}


class Building {

  public int L,H,R;

  Building(int l, int h, int r) {
    L = l;
    H = h;
    R = r;
  }

  @Override
  public boolean equals(Object obj) {
    Building other = (Building) obj;

    return L == other.L && H == other.H && R == other.R;
  }

  @Override
  public int hashCode() {
    return Objects.hash(L,H,R);
  }
}
