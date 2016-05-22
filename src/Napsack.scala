import scala.collection.mutable.ListBuffer

class Napsack(val items: Seq[Int], maxWeight: Int) {

  var dp = Array.ofDim[BigInt](items.size, maxWeight)
  for (i <- 0 to maxWeight) {
    dp(0)(i) = 0
  }


  def napSack = {}

}

object Napsack {

}
