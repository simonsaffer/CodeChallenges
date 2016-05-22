import java.io.FileInputStream
import java.util.Scanner

/**
  * The night sky can be modeled as an infinite 2D plane. There are N stars at distinct positions on this plane, the ith of
  * which is at coordinates (Xi, Yi).

A boomerang constellation is a pair of distinct equal-length line segments which share a single endpoint, such that both
endpoints of each segment coincide with a star's location.

Two boomerang constellations are distinct if they're not made up of the same unordered pair of line segments. How many distinct
boomerang constellations can you spot?

Input
Input begins with an integer T, the number of nights on which you look out at the sky. For each night, there is first a line
containing the integer N. Then, N lines follow, the ith of which contains the space-separated integers Xi and Yi.

Output
For the ith night, print a line containing "Case #i: " followed by the number of boomerang constellations in the night sky.

Constraints
1 ≤ T ≤ 50
1 ≤ N ≤ 2,000
-10,000 ≤ Xi, Yi ≤ 10,000
Explanation of Sample
On the first night, every pair of stars is a unique distance apart, so there are no boomerang constellations. On the second
night, there are 4 boomerang constellations. One of them consists of the line segments (0,0)-(0,2) and (0,2)-(0,4).

Example input · DownloadExample output · Download
5
3
0 0
0 1
0 3
5
0 0
0 1
0 2
0 3
0 4
4
0 0
0 100
100 0
100 100
4
0 0
-3 4
0 5
-5 0
6
5 6
6 5
7 6
6 7
7 8
8 7


Case #1: 0
Case #2: 4
Case #3: 4
Case #4: 3
Case #5: 12
  */
object BoomerangConstellations {

  type Point = (Int, Int)

  def squaredDist(p1: Point, p2: Point) = {
    val xDiff: Int = p2._1 - p1._1
    val yDiff: Int = p2._2 - p1._2

    xDiff * xDiff + yDiff * yDiff
  }

  def main(args: Array[String]) {

    val start = java.time.Instant.now()

    val sc = new Scanner(new FileInputStream(args(0)))

    val writer = new java.io.PrintWriter(args(0).replace(".txt", "_output.txt"))

    val T = sc.nextInt()

    for (t <- 1 to T) {

      val N = sc.nextInt()

      val stars: Seq[Point] = for (n <- 1 to N) yield (sc.nextInt(), sc.nextInt())

      val groups: Map[Int, Seq[((Int, Int), (Int, Int), Int)]] =
        (for (i <- 0 until stars.length; j <- 0 until stars.length; if (i < j))
        yield {
          val s1: (Int, Int) = stars(i)
          val s2: (Int, Int) = stars(j)
          (s1, s2, squaredDist(s1, s2))
        }).groupBy(_._3)

      val result = groups.map(group => {

        val lines = group._2

        val sum: Int = (for (l1 <- 0 until lines.size; l2 <- 0 until lines.size; if (l1 < l2)) yield {
          if (isPointShared(lines(l1), lines(l2))) 1 else 0
        }).sum

        sum
      }).sum

      writer.write(s"Case #$t: $result\n")
    }

    writer.close()

    val end = java.time.Instant.now()

    val time = java.time.temporal.ChronoUnit.MINUTES.between(start, end)

    println(time)

  }

  def isPointShared(line1: ((Int, Int), (Int, Int), Int), line2: ((Int, Int), (Int, Int), Int)): Boolean = {
    line1._1 == line2._1 || line1._2 == line2._2 || line1._1 == line2._2 || line1._2 == line2._1
  }
}
