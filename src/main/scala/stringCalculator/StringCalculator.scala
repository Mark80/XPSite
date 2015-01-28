package main.scala.stringCalculator

/**
 * Created by tosini on 28/01/15.
 */
class StringCalculator {


  private val delimitatori: String = ",|\\n"


  def add(s: String): Int = numbersFrom(s).foldLeft(0)(op = (acc, x) => if (!x.isEmpty) acc + getAddend(x) else 0)


  private def numbersFrom(s: String): Array[String] = s.split(delimitatori)


  private def getAddend(x: String): Int = Integer.parseInt(x) match {
      case value if (value > 1000) => 0
      case value if (value < 0) => throw new IllegalArgumentException("i numeri possono solo essere maggiori di zero")
      case value => value
    }

}


