import java.util.Scanner

/**
  * Created by simonsaffer on 2016-01-29.
  */
object Mars {

  def main(args: Array[String]) {

    val sc = new Scanner(System.in)

    val S = sc.next()

    val result = S.grouped(3).map(getNbrOfDiffs).sum

    println(result)

  }

  def getNbrOfDiffs(s: String): Int = {
    s.zip("SOS").map(t => if (t._1 != t._2) 1 else 0).sum
  }
}
