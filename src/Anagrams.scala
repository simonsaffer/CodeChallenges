import java.util.Scanner

import scala.collection.immutable.Iterable

/**
  * Created by simonsaffer on 2016-02-10.
  */
object Anagrams {

  def main(args: Array[String]) {

    val sc = new Scanner(System.in)

    val words = (for( ln <- io.Source.stdin.getLines) yield (ln, ln.replace(" ", "").sorted)).toList

    val anagramGroups: Map[String, List[(String, String)]] = words.groupBy(_._2)

    val anagramLists = anagramGroups.map(_._2.map(_._1).sorted).toList.sortBy(_.mkString(""))

    println(anagramLists.map(_.mkString(",")).mkString("\n"))
  }

}
