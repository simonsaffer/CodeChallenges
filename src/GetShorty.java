import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetShorty {

  private Map<Integer, Double> largestSizePerNode = new HashMap<>();
  private final DecimalFormat decimalFormat;
  private List<Node> nodes;

  public GetShorty() {
    decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
    decimalFormat.setMinimumFractionDigits(4);
    decimalFormat.setMaximumFractionDigits(4);
  }

  public void solve() {

    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {

      final int n = sc.nextInt();
      final int m = sc.nextInt();

      if (n == 0 && m == 0) break;

      nodes = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        nodes.add(new Node(i));
      }

      for (int i = 0; i < m; i++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        double f = Double.parseDouble(sc.next());

        Node.addEdge(nodes.get(x), nodes.get(y), f);
      }

      double size = findLargestSize(n-1);
      System.out.println(decimalFormat.format(size));

    }

  }

  public static void main(String[] args) {

    GetShorty getShorty = new GetShorty();
    getShorty.solve();

  }

  private double findLargestSize(Integer nodeId) {

    if (nodeId == 0) {

      return 1;

    } else if (largestSizePerNode.containsKey(nodeId)) {

      return largestSizePerNode.get(nodeId);

    } else {

      Node node = nodes.get(nodeId);


      Optional<Double> max = node.adjList.stream()
        .filter(edge -> !edge.node.visited)
        .map(edge -> findLargestSize(edge.node.id) * edge.f)
        .max(Double::compare);

      node.visited = true;

      Double result = max.get();

      largestSizePerNode.put(nodeId, result);

      return result;

    }


  }

  private static void genProblem() {
    int n = 100;
    int m = n*n;

    System.out.println(n + " " + m);

    Random random = new Random();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        double v = random.nextDouble();
        while(v < 0.0001) {
          v = random.nextDouble();
        }
        System.out.println(i + " " + j + " " + v);
      }
    }
  }

  private static class Node implements Comparable<Node> {

    final int id;
    final List<Edge> adjList = new ArrayList<>();
    double size = 0;
    boolean visited;

    public Node(int id) {
      this.id = id;
    }

    public static void addEdge(Node n1, Node n2, double f) {
      n1.adjList.add(new Edge(n2, f));
      n2.adjList.add(new Edge(n1, f));
    }

    @Override
    public int compareTo(Node o) {
      return Double.compare(o.size, size);
    }

    @Override
    public String toString() {
      return "Id: " + id + " size: " + size +  " adjList: " +
        adjList.stream().map(e -> String.valueOf(e.node.id)).collect(Collectors.joining(","));
    }

    private static class Edge {
      final Node node;
      final double f;

      public Edge(Node node, double f) {
        this.node = node;
        this.f = f;
      }

      @Override
      public String toString() {
        return "Edge: Node(" + node.id + ") - f(" + f + ")";
      }
    }
  }

}
