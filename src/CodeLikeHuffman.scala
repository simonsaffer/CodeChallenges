class Node(var left: Option[Node], var right: Option[Node], val freq: Int) extends Ordered[Node] {
  def getEncoding(c: Char, current: String): Option[String] = {
    val leftResult: Option[String] = left.map(_.getEncoding(c, current + "0")).getOrElse(None)
    val rightResult: Option[String] = right.map(_.getEncoding(c, current + "1")).getOrElse(None)
    leftResult.orElse(rightResult)
  }

  def add(node: Node): Unit = {

    def isLessNode(a: Node, b: Node): Boolean = {
      a.compare(b) <= 0
    }

    val isLess = (node.freq == freq && isLessNode(node, this)) || node.freq <= freq

    if (isLess) {
      left match {
        case None => left = Some(node)
        case _ => left.foreach(l => l.add(node))
      }
    } else {
      right match {
        case None => right = Some(node)
        case _ => right.foreach(r => r.add(node))
      }
    }
  }

  override def compare(that: Node): Int = {
    (this, that) match {
      case (x, y) if(x.freq != y.freq) => x.freq - y.freq
      case (x: Node, y: Leaf) => -1
      case (x: Leaf, y: Leaf) => x.data - y.data
      case _ => 1
    }
  }

  override def toString = s"{$freq $left $right}"
}
class Leaf(val data: Char, l: Option[Node], r: Option[Node], f: Int) extends Node(l, r, f) {
  override def getEncoding(c: Char, current: String): Option[String] = {
    if (c == data) Some(current)
    else None
  }
  override def toString = s"{$data : $freq $left $right}"
}

object Main extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)

  def createTree(nodeList: Seq[Node]): Node = {
    if (nodeList.size <= 1) nodeList(0)
    else {
      val twoLowestFreqNodes = nodeList take 2
      val (left, right) = (twoLowestFreqNodes(0), twoLowestFreqNodes(1))
      val parent = new Node(Some(left), Some(right), left.freq + right.freq)
      val newNodeList = ((nodeList drop 2) :+ parent).sorted
      createTree(newNodeList)
    }
  }

  for (l <- lines) {

    /*val nodes = l.groupBy(c => c).toSeq
      .map(group => (group._1, group._2.size))
      .map(p => new Leaf(p._1,None,None,p._2))
      .sorted

    val root = createTree(nodes)

      println(l.distinct.sorted.map(c => {
        val encoding: Any = root.getEncoding(c, "").mkString
        s"$c: $encoding;"
      }).mkString(" "))*/

  }
}
