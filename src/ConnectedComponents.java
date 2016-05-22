import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ConnectedComponents {

  private static int sizeOfComponent(Node root) {

    Stack<Node> s = new Stack<>();
    s.add(root);
    root.visited = true;

    int size = 0;
    while(!s.isEmpty()) {
      Node n = s.pop();
      ++size;

      for(Node cn : n.adjList) {
        if(!cn.visited) {
          s.add(cn);
          cn.visited = true;
        }
      }
    }

    return size;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    List<Node> nodes = new ArrayList<>(N);
    for(int i = 0; i < 2*N; i++) nodes.add(new Node());

    for(int i = 0; i < N; i++) {
      int a = sc.nextInt()-1;
      int b = sc.nextInt()-1;

      nodes.get(a).adjList.add(nodes.get(b));
      nodes.get(b).adjList.add(nodes.get(a));
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(Node n : nodes) {
      if (!n.visited) {
        int size = sizeOfComponent(n);
        if (size > 1) {
          min = Math.min(min, size);
          max = Math.max(max, size);
        }
      }
    }

    System.out.println(min + " " + max);
  }
}

class Node {
  public List<Node> adjList = new ArrayList<>();
  public boolean visited = false;
}
