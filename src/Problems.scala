/**
 * Created by simonsaffer on 2015-09-01.
 */
object Problems {

  // 1. Find the last element of a list
  def last1[T](xs: List[T]) = xs.last

  def last2[T](xs: List[T]): T = xs match {
    case Nil | List() => throw new java.util.NoSuchElementException()
    case List(x: T) :: Nil => x
    case xs :: ys => last2(ys)
  }

  // 2. Find the last but one element of a list
  def penultimate1[T](xs: List[T]): T = xs match {
    case xs: List[T] if(xs.length) < 2 => throw new java.util.NoSuchElementException()
    case _: List[T] => xs(xs.length-2)
  }
  def penultimate2[T](xs: List[T]): T = xs match {
    case List(a,b) => a
    case xs :: ys => penultimate2(ys)
  }

  // 3. Find the Kth element of a list
  /*def nth[T](idx: Int, xs: List[T]): T = {
    val i = 0
    def kth[T](index: Int, target: Int, ys: List[T]): T = {

    }
  }*/

  def nth2[T](idx: Int, xs: List[T]) = xs.drop(idx-1).take(1)

  // 4. Find the number of elements of a list
  def length[T](xs: List[T]) = xs.length


}
