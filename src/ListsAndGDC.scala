import scala.collection.immutable.IndexedSeq

/**
  * Created by simonsaffer on 2016-01-14.
  */
object ListsAndGDC {

  def primeFactorGDC(A: Seq[(Int, Int)], B: Seq[(Int, Int)]): Seq[(Int, Int)] = {
    def merge(A: Seq[(Int, Int)], B: Seq[(Int, Int)], result: Seq[(Int, Int)]): Seq[(Int, Int)] = {
      if (A.length == 0 || B.length == 0) result
      else if (A(0)._1 == B(0)._1) merge(A.drop(1), B.drop(1), result :+ (A(0)._1, Math.min(A(0)._2, B(0)._2)) )
      else if (A(0)._1 < B(0)._1) merge(A.drop(1), B, result)
      else merge(A, B.drop(1), result)
    }

    merge(A, B, Seq())
  }

  def listGDC(lst: Seq[Seq[(Int, Int)]]): Seq[(Int, Int)] = {
    if (lst.length == 2) primeFactorGDC(lst(0), lst(1))
    else primeFactorGDC(lst(0), listGDC(lst.slice(1, lst.length)))
  }

  def createTupleSeq(strings: Array[String], result: Seq[(Int, Int)]): Seq[(Int, Int)] = {
    if (strings.isEmpty) result
    else createTupleSeq(strings.drop(2), result :+ (strings(0).toInt, strings(1).toInt))
  }

  def main(args: Array[String]) {

    val sc = new java.util.Scanner(System.in);

    val Q = sc.nextLine().toInt;

    val lists: Seq[Seq[(Int, Int)]] = for (q <- 1 to Q) yield createTupleSeq(sc.nextLine().split(" "), Seq())

    val pf = listGDC(lists)

    println(pf.map(t => t._1 + " " + t._2).mkString(" "))
  }

}
