object BooleanTable {

  def gen(n: Int, res: Seq[Boolean]): Unit = {

    if (n==0) {
      println(res.mkString(","))
    } else {
      gen(n-1, res :+ false)
      gen(n-1, res :+ true)
    }

  }

  def main(args: Array[String]) {

    //gen(4, Seq());

    val xs = Seq(1,2,3,-4,6,-3,9,11)

    //xs.fold((Int.MaxValue, Int.MinValue))(t: (Int, (Int, Int)) => (math.Min(t._1, ))

  }
}
