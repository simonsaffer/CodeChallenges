import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MarsNetworks {

  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader(args[0]));

    String line = null;
    while ((line = reader.readLine()) != null) {

      String[] probeStrPairs = line.split(" ");

      HashSet<Probe> probes = new HashSet<Probe>();
      for (String pair : probeStrPairs) {

        String[] components = pair.split(",");
        int x = Integer.parseInt(components[0]);
        int y = Integer.parseInt(components[1]);

        Probe probe = new Probe(x,y);

        probes.add(probe);
      }

      List<Probe> MSTProbes = new ArrayList<Probe>();

      // Prim
      PriorityQueue<Probe> q = new PriorityQueue<Probe>(new ProbeComparator());
      q.addAll(probes);

      Probe root = q.poll();
      root.minDist = 0.0;
      q.add(root);

      double totalDist = 0;
      while (q.size() > 0) {

        Probe probe = q.poll();
        probes.remove(probe);
        MSTProbes.add(probe);
        Iterator<Probe> it = probes.iterator();
        while (it.hasNext()){
          Probe neighbour = it.next();
          double dist = calcDist(probe, neighbour);
          if (dist < neighbour.minDist){
            q.remove(neighbour);
            neighbour.minDist = dist;
            neighbour.parent = probe;
            q.add(neighbour);
          }
        }
      }

      double totDist = 0.0;
      for (Probe probe : MSTProbes){
        totalDist += probe.minDist;
      }

      System.out.println((int) Math.ceil(totalDist));

    }

  }

  private static double calcDist(Probe p, Probe neighbour) {
    int xDist = p.x - neighbour.x;
    int yDist = p.y - neighbour.y;
    return Math.sqrt(xDist*xDist + yDist*yDist);
  }

}

class ProbeComparator implements Comparator<Probe> {

  @Override
  public int compare(Probe o1, Probe o2) {
    return Double.compare(o1.minDist, o2.minDist);
  }
}

class Probe {
  public int x,y;
  public Probe parent;
  public double minDist;

  Probe(int x, int y) {
    this.x = x;
    this.y = y;
    this.minDist = Double.MAX_VALUE;
  }

  @Override
  public boolean equals(Object obj) {
    Probe probe = (Probe) obj;
    return super.equals(obj) && x == probe.x && y == probe.y;
  }

  @Override
  public int hashCode() {
    return (x+"&"+y).hashCode();
  }
}
