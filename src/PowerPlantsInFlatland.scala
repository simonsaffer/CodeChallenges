/**
  * Created by simonsaffer on 2016-01-29.
  */
object PowerPlantsInFlatland {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var c = new Array[Int](m);
    for(c_i <- 0 to m-1) {
      c(c_i) = sc.nextInt();
    }

    val sortedStations = c.sorted

    val pi = sortedStations.iterator
    val ni = sortedStations.iterator

    var pv = pi.next()
    var nv = ni.next()
    if (ni.hasNext) nv = ni.next()

    var maxDistTot = 0

    var current = 0
    while (current < n) {

      val maxDist = Math.min(Math.abs(current-pv), Math.abs(nv-current))
      if (maxDist > maxDistTot) {
        maxDistTot = maxDist
      }

      if (current == nv) {
        if(pi.hasNext) pv = pi.next()
        if(ni.hasNext) nv = ni.next()
      }

      current += 1

    }

    println(maxDistTot)

  }

}
