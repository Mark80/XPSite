package main.scala.karateChop

/**
 * Created by tosini on 31/01/15.
 */
object Chopper {

  def chop(target: Int, array: Array[Int]): Int = {
      var index = 0
      while (array.size > index && array(index) != target) {
        index += 1
      }
      if (index == array.size) -1 else index
  }


}
