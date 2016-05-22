import java.util.Scanner

import scala.collection.immutable.IndexedSeq
import scala.collection.immutable.Stream.Empty
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Problem Statement

Hermione Granger is lost in the Forbidden Forest while collecting some herbs for a magical potion. The forest is magical and
has only one exit point, which magically transports her back to the Hogwarts School of Witchcraft and Wizardry.
The forest can be considered as a grid of N×M size. Each cell in the forest is either empty (represented by '.') or has a tree
(represented by 'X'). Hermione can move through empty cells, but not through cells with a tree in it. She can only travel LEFT,
RIGHT, UP, and DOWN. Her position in the forest is indicated by the marker 'M' and the location of the exit point is indicated
by '*'. Top-left corner is indexed (0, 0).

.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
In the above forest, Hermione is located at index (2, 7) and the exit is at (1, 2). Each cell is indexed according to Matrix Convention

She starts her commute back to the exit, and every time she encounters more than one option to move, she waves her wand and the
correct path is illuminated and she proceeds in that way. It is guaranteed that there is only one path to each reachable cell
from the starting cell. Can you tell us if she waved her wand exactly K times or not? Ron will be impressed if she is able to do so.

Input Format
The first line contains an integer T; T test cases follow.
Each test case starts with two space-separated integers, N and M.
The next N lines contain a string, each having a length of M, which represents the forest.
The last line of each single test case contains integer K.

Output Format
For each test case, if she could impress Ron then print Impressed, otherwise print Oops!.

Constraints
1≤T≤10
1≤N,M≤100
0≤K≤10000
There is exactly one 'M' and one '*' in the graph.
Exactly one path exists between 'M' and '*.'

Sample Input

3
2 3
  *.M
.X.
1
4 11
.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
3
4 11
.X.X......X
.X*.X.XXX.X
.XX.X.XM...
......XXXX.
4
Sample Output

Impressed
Impressed
Oops!
Explanation

Case 1: Hermione waves her wand at (0,2), hence #Wand waved = K = 1.
Case 2: Hermione waves her wand at (2,9) (0,5), and (3,3), hence #Wand waved = K = 3.
Case 3: Same as above. But here K = 4, which doesn't match the number of times her wand is waved.
  */

object CountLuck {

  private abstract class Type

  private class Harmonie extends Type
  private class Empty extends Type
  private class Exit extends Type
  private class Tree extends Type

  private class Node(val cellType: Type, val r: Int, val c: Int) extends Ordered[Node] {

    val adjList = new ListBuffer[Node]

    var dist = Int.MaxValue

    var visited = false

    override def compare(that: Node): Int = that.dist compareTo this.dist

    override def toString = s"${cellType.getClass.getName} - $dist - ($r,$c)"
  }

  private def getType(grid: Seq[Seq[Char]], i: Int, j: Int): Type = grid(i)(j) match {
    case '.' => new Empty
    case 'M' => new Harmonie
    case '*' => new Exit
    case _ => new Tree
  }

  private def buildGraph(grid: Seq[Seq[Char]]) = {

    var root: Node = null
    var exit: Node = null

    val graph = for ((row, i) <- grid.zipWithIndex) yield
      for ((cell, j) <- row.zipWithIndex) yield {
        val cellType: Type = getType(grid, i, j)
        val node: Node = new Node(cellType, i, j)
        if (cellType.isInstanceOf[Harmonie]) {
          root = node
        }
        if (cellType.isInstanceOf[Exit]) {
          exit = node
        }
        node
      }

    def visit(i: Int, j: Int, node: Node): Unit = {

      node.visited = true

      for ((x, y) <- Seq((i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)) if (x >= 0 && x < grid.length && y >= 0 && y < grid(0).length)) {

        val neighbour = graph(x)(y)

        if ((node eq neighbour) == false && !neighbour.visited) {

          neighbour.cellType match {

            case n: Tree => {}
            case _ => {
              visit(x,y,neighbour)
              node.adjList.append(neighbour)
              neighbour.adjList.append(node)
            }
          }
        }
      }

    }
    for (i <- 0 until grid.length; j <- 0 until grid(0).length) {

      val node = graph(i)(j)

      if (!node.visited && !node.cellType.isInstanceOf[Tree]) {

        visit(i, j, node)
      }
    }

    val nonTreeNodes: Seq[Node] = graph.flatMap(ns => ns.filter(_.cellType match { case an: Tree => false; case _ => true}))

    (root, exit, nonTreeNodes)
  }

  /*def countW(node: Node, numberOfWaives: Int): Int = {
    node.adjList
  }*/


  def dfs(harmonie: Node, exit: Node) = {
    0
  }

  def main(args: Array[String]) {

    val sc = new Scanner(System.in)

    val T = sc.nextInt()

    for (t <- 1 to T) {

      val N = sc.nextInt()
      val M = sc.nextInt()

      val grid: Seq[Seq[Char]] = for (n <- (1 to N)) yield sc.next.toSeq

      val (harmonie, exit, nodes) = buildGraph(grid)

      val dist = dfs(harmonie, exit)

      val K = sc.nextInt()

      val result = dist match {
        case K => "Impressed"
        case _ => "Oops!"
      }

      println(dist)


    }

  }

}
