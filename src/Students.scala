class Students {

}

import scala.collection.JavaConversions._

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {
  def solution(A: Array[Int]): Int = {

    val sorted = A.sorted

    val comp = A zip(sorted)

    var start = 0
    while (start < A.size && comp(start)._1 == comp(start)._2) {
      start += 1
    }
    //println(start)

    var end = A.size-1
    while (end > 0 && comp(end)._1 == comp(end)._2) {
      end -= 1
    }
    //println(end)

    end - start + 1
  }

  def main(args: Array[String]) {

    solution(Array(10))

  }
}
