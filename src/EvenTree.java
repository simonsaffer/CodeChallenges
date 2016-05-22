import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Problem Statement

 You are given a tree (a simple connected graph with no cycles). You have to remove as many edges from the tree as possible to
 obtain a forest with the condition that : Each connected component of the forest should contain an even number of vertices.

 To accomplish this, you will remove some edges from the tree. Find out the number of removed edges.

 Input Format
 The first line of input contains two integers N and M. N is the number of vertices and M is the number of edges.
 The next M lines contain two integers ui and vi which specifies an edge of the tree. (1-based index)

 Output Format
 Print the answer, a single integer.

 Constraints
 2 <= N <= 100.

 Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes.

 Sample Input

 10 9
 2 1
 3 1
 4 3
 5 2
 6 1
 7 2
 8 6
 9 8
 10 8
 Sample Output

 2
 Explanation
 On removing edges (1, 3) and (1, 6), we can get the desired result.
 */
public class EvenTree {

  public static int nbrOfRemovedEdges = 0;
  private static HashSet<Tree> visited;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    List<Tree> nodes = new ArrayList<>(N);
    for (int i = 0; i < N; i++) {
      nodes.add(new Tree(i));
    }

    for (int i = 0; i < M; i++) {
      int a = sc.nextInt()-1;
      int b = sc.nextInt()-1;

      nodes.get(a).addEdge(nodes.get(b));
      nodes.get(b).addEdge(nodes.get(a));
    }

    visited = new HashSet<>();

    nodes.get(0).setSizes();

    nodes.get(0).cutEdges();

    System.out.println(nbrOfRemovedEdges);

  }

  private static class Tree {

    public int id;
    private int size;

    Tree(int id) {
      this.id = id;
    }

    public Tree cutEdges() {

      visited.add(this);

      for (int i = 0; i < adjList.size(); i++) {
        final Tree tree = adjList.get(i);
        int treeSize = tree.size;
        if (!visited.contains(tree)) {

          Tree newTree = tree.cutEdges();
          if (newTree == null) {
            this.size -= treeSize;
          }

          adjList.set(i, newTree);
        }
      }

      if (size % 2 == 0) {
        ++nbrOfRemovedEdges;
        return null;
      } else {
        return this;
      }

    }

    public int setSizes() {

      visited.add(this);

      int total = 1;
      for (Tree tree : adjList) {
        if (!visited.contains(tree)) {
          total += tree.setSizes();
        }
      }

      this.size = total;

      return total;
    }

    ArrayList<Tree> adjList = new ArrayList<>();

    public void addEdge(Tree to) {
      adjList.add(to);
    }

    @Override
    public boolean equals(Object obj) {
      Tree other = (Tree) obj;
      return other.id == id;
    }

    @Override
    public int hashCode() {
      return id;
    }
  }

}
