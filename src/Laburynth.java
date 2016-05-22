import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Laburynth {

  private static class Node {
    int x, y;
    int dist;
    Node p;
    List<Node> adjList;

    Node(int ix, int iy){
      x = ix;
      y = iy;
      dist = Integer.MAX_VALUE;
      p = null;
      adjList = new ArrayList<Node>();
    }

    @Override
    public String toString() {
      return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
      if(obj instanceof  Node){
        Node o = (Node) obj;
        return o.x == x && o.y == y;
      }
      return false;
    }
  }

  static int L_SIZE = 101;
  static short SPACE = 0;
  static short WALL = 1;
  static short PATH = 2;
  static short[][] laburynth = new short[L_SIZE][L_SIZE];
  static boolean[][] visited = new boolean[L_SIZE][L_SIZE];
  static List<Node> nodes = new ArrayList<Node>();

  static void markPath(final Node start, final Node end){
    int startX = Math.min(start.x, end.x);
    int endX = Math.max(start.x, end.x);
    int startY = Math.min(start.y, end.y);
    int endY = Math.max(start.y, end.y);

    for(int i = startX; i <= endX; i++){
      laburynth[i][startY] = PATH;
    }

    for(int i = startY; i <= endY; i++){
      laburynth[endX][i] = PATH;
    }
  }

  static boolean isJunction(int x, int y){
    boolean hasXNeighbours = false;
    boolean hasYNeighbours = false;

    if(y == 0 || y == L_SIZE-1){
      return true;
    }

    int startX = Math.max(0, x-1);
    int endX = Math.min(L_SIZE-1, x+1);
    int startY = Math.max(0, y-1);
    int endY = Math.min(L_SIZE-1, y+1);

    for(int i = startX; i <= endX; i++) {
      if(i != x && laburynth[i][y] != WALL) hasXNeighbours = true;
    }

    for (int j = startY; j <= endY; j++) {
      if(j != y && laburynth[x][j] != WALL) hasYNeighbours = true;
    }

    return hasXNeighbours && hasYNeighbours;
  }

  static void findJunctions(int x, int y, Node pLastNode){

    if(visited[x][y]){
      return;
    } else {
      visited[x][y] = true;
    }

    if(isJunction(x,y)) {
      Node pNode = new Node(x, y);
      nodes.add(pNode);
      pLastNode.adjList.add(pNode);
      pNode.adjList.add(pLastNode);
      pLastNode = pNode;
    }

    int startX = Math.max(0, x-1);
    int endX = Math.min(L_SIZE-1, x+1);
    int startY = Math.max(0, y-1);
    int endY = Math.min(L_SIZE-1, y+1);

    for(int i = startX; i <= endX; i++){
      for(int j = startY; j <= endY; j++){
        if(laburynth[i][j] != WALL){
            findJunctions(i,j,pLastNode);
          }
      }
    }

  }

  static int calcDist(final Node n1, final Node n2){
    return Math.abs(n1.x-n2.x) + Math.abs(n1.y-n2.y);
  }

  /*public static void main(String[] args) throws Exception {

    String fileName = "input.txt";// = args[0];

    BufferedReader br = new BufferedReader(new FileReader(fileName));

    int row = 0;
    String lineBuffer = null;
    while ((lineBuffer = br.readLine()) != null)
    {

      if (lineBuffer.length() == 0)
        continue; //ignore all empty lines
      else
      {
        for(int col = 0; col < L_SIZE; col++){
          if(lineBuffer.charAt(col) == '*'){
            laburynth[col][row] = WALL;
          }
        }
      }

      ++row;
    }

    Node pRoot = null;
    for(int i = 0; i < L_SIZE; i++){
      if(laburynth[i][0] == SPACE){
        pRoot = new Node(i,0);
        pRoot.dist = 0;
        findJunctions(i,0,pRoot);
        break;
      }
    }

    int maxY = Integer.MIN_VALUE;
    Node pEnd = null;
    for(Node pNode : nodes){
      if(pNode.y > maxY) maxY = pNode.y;
      if(pNode.y == L_SIZE-1){
        pEnd = pNode;
        break;
      }
    }
    System.out.println("MaxY: " + maxY);

    PriorityQueue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return Integer.compare(o1.dist,o2.dist);
      }
    });

    q.addAll(nodes);

    while(q.size()>0){

      Node node = q.poll();
      //System.out.println(node.x + "," + node.y);

      for(Node pNeighbour : node.adjList){
        int dist = node.dist + calcDist(node, pNeighbour);
        if(dist < pNeighbour.dist){
          pNeighbour.dist = dist;
          pNeighbour.p = node;
        }
      }

    }

    //cout << 165 << endl;

    Node n = pEnd;
    while(n.p != null){
      markPath(n, n.p);
      n = n.p;
    }

// Print result
    for(int i = 0; i < L_SIZE; i++){
      for(int j = 0; j < L_SIZE; j++){
        if(laburynth[i][j] == WALL){
          System.out.print("*");
        } else if(laburynth[i][j] == PATH){
          System.out.print("+");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }

  }*/
}
