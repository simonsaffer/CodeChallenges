import java.util.Scanner

import scala.collection.mutable

/**
  * Created by simonsaffer on 2016-01-20.
  */

class DifferentWays {

  val dp = mutable.HashMap[(Int, Int), BigInt]();

  def binomial(N: Int, K: Int): BigInt = {

    def calcAndAdd(N: Int, K: Int): BigInt = {
      val result: BigInt = (N, K) match {
        case (0, _) => 1
        case (_, 0) => 1
        case _ => ((N+1-K)*binomial(N, K-1)/K)
      }
      dp += ((N, K) -> result)
      result
    }

    dp.getOrElse((N, K), calcAndAdd(N, K))
  }

}

object DifferentWays {

  def main(args: Array[String]) {

    val sc = new Scanner(System.in)

    val T = sc.nextInt()

    val dw = new DifferentWays

    for (t <- 1 to T) {

      val N = sc.nextInt()
      val K = sc.nextInt()

      println(dw.binomial(N, K) % 100000007)

    }

  }

}
