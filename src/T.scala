/**
  * Created by simonsaffer on 2016-02-25.
  */
trait T[A,B] {
  def f(x: A): B
}

class Impl1 extends T[Int, Unit] {
  override def f(x: Int): Unit = println(x)
}

class Impl2 extends T[Unit, Int] {
  override def f(x: Unit): Int = 10
}

object TryT {
  def main(args: Array[String]) {

    val t1 = new Impl1
    val t2 = new Impl2

    t1.f(123)
    println(t2.f())
  }
}
