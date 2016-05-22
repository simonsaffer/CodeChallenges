/**
  * Created by simonsaffer on 2015-11-20.
  */

/*class Memo[T, V, U] {
  private var dp: Map[T, U] = Map()

  def getOrCalculateValue(n: T, usedCoins: V, f: (T, V) => U): U = {
    if (dp contains n) {
      println(s"memo $n")
      dp(n)
    }
    else {
      val result: U = f(n, usedCoins)
      dp = dp + (n -> result)
      result
    }
  }
}*/

class CoinChange(val coins: Seq[Int]) {

  type Result = (BigInt, Set[Map[Int, Int]])
  //val memo = new Memo[Int, Map[Int, Int], Result]
  var usedSolutions: Set[Map[Int, Int]] = Set()

  def change(amount: Int, coinsUsed: Map[Int, Int]): Result = amount match {
    case 0 => (1, Set(coinsUsed))
    case _ => {
      def calculateResult(n: Int, usedCoins: Map[Int, Int]): Result = {
        val childrensResults = coins.filter(c => c <= n).map(c => change(n - c, addToMap(coinsUsed, c)))
        val result: (BigInt, Set[Map[Int, Int]]) = childrensResults.reduce((a: Result, b: Result) => (a._1+b._1, a._2 ++ b._2))
        result
      }
      //memo.getOrCalculateValue(amount, coinsUsed, calculateResult)
      (0, Set())
    }
  }

  def addToMap(coinsUsed: Map[Int, Int], c: Int): Map[Int, Int] = {
    val value: Int = coinsUsed.getOrElse(c, 0)
    coinsUsed + (c -> (value + 1))
  }
}

object SolutionZZ {

  def main(args: Array[String]) {

    val sc = new java.util.Scanner(System.in);

    val N: Int = sc.nextInt();
    val M: Int = sc.nextInt();

    var coins: Seq[Int] = Seq()
    for (i <- 1 to M) {
      coins = coins :+ sc.nextInt();
    }

    val ch = new CoinChange(coins.sorted)

    println(ch.change(N, Map())._1)
  }
}
