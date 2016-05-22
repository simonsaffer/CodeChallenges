/**
  * Created by simonsaffer on 2015-11-25.
  */
class CoinChange2(val coins: Seq[Int]) {

  //var solutions: Set[Map[Int,Int]] = Set()

  def change(n: Int, usedCoins: Map[Int, Int]): Set[Map[Int, Int]] = n match {
    case 0 => {
      Set(usedCoins)
    }
    case _ => coins.filter(c => c <= n).map(c => change(n - c, addToMap(usedCoins, c))).reduce(_ ++ _)
  }

  def addToMap(coinsUsed: Map[Int, Int], c: Int): Map[Int, Int] = {
    val value: Int = coinsUsed.getOrElse(c, 0)
    coinsUsed + (c -> (value + 1))
  }

}

object Solution2 {

  def main(args: Array[String]) {

    val sc = new java.util.Scanner(System.in);

    val N: Int = sc.nextInt();
    val M: Int = sc.nextInt();

    var coins: Seq[Int] = Seq()
    for (i <- 1 to M) {
      coins = coins :+ sc.nextInt();
    }

    val ch = new CoinChange2(coins.sorted)

    ch.change(N, Map())

    //println(ch.size)
  }
}
