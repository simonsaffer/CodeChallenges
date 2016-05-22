import java.io.FileInputStream
import java.util.Scanner

/**
  * You've managed to become a contestant on the hottest new game show, The Price is Correct!

After asking you to come on down to the stage, the show's host presents you with a row of N closed boxes, numbered from 1 to N
in order, each containing a secret positive integer. A curtain opens to reveal a shiny, new tricycle — you recognize it as an
expensive, top-of-the-line model.

The host then proceeds to explain the rules: you must select a contiguous sequence of the boxes (boxes a..b, for some 1 ≤ a ≤ b
≤ N). Your chosen boxes will then be opened, and if the sum of the numbers inside is no greater than the price of the tricycle,
you win it!

You'd sure like to win that tricycle. Fortunately, not only are you aware that its price is exactly P, but you've paid off the
host to let you in on the contents of the boxes! You know that each box i contains the number Bi.

How many different sequences of boxes can you choose such that you win the tricycle? Each sequence is defined by its starting
and ending box indices (a and b).

Input
Input begins with an integer T, the number of times you appear on The Price is Correct. For each show, there is first a line
containing the space-separated integers N and P. The next line contains N space-separated integers, B1 through BN in order.

Output
For the ith show, print a line containing "Case #i: " followed by the number of box sequences that will win you the tricycle.

Constraints
1 ≤ T ≤ 40
1 ≤ N ≤ 100,000
1 ≤ P ≤ 1,000,000,000
1 ≤ Bi ≤ 1,000,000,000
Explanation of Sample
In the first case no sequence adds up to more than 50, so all 10 sequences are winners. In the fourth case, you can select any
single box, or the sequences (1, 2), (1, 3), and (2, 3), for 9 total winning sequences.

Example input · DownloadExample output · Download
5
4 50
10 10 10 10
4 50
51 51 51 51
3 1000000000
1000000000 1000000000 1000000000
6 6
1 2 3 4 5 6
10 77
12 3 52 25 9 83 45 21 33 3
Case #1: 10
Case #2: 0
Case #3: 3
Case #4: 9
Case #5: 18
  */
object PriceIsCorrect {

  def main(args: Array[String]) {

    val start = java.time.Instant.now()

    val sc = new Scanner(new FileInputStream(args(0)))

    val writer = new java.io.PrintWriter(args(0) + "output")

    val T = sc.nextInt()

    for (t <- 1 to T) {

      val N = sc.nextInt()

      val P = sc.nextInt()

      val values = for (n <- 1 to N) yield sc.nextInt()

      // for (start <- 0 until N) yield (for (end <- 0 until N; if (start <= end)) yield )

      var result: BigInt = 0

      var rowResult: BigInt = 0

      for (start <- 0 until N) {
        for (end <- 0 until N; if (start <= end)) {
          rowResult = if (start == end) {
            values(start)
          }
          else {
            rowResult + values(end)
          }

          if (rowResult <= P) result += 1
        }
      }

      //println(DP.map(_.mkString(" ")).mkString("\n"))

      println(result)

    }

  }

}
