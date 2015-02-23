package main.scala.digitalSimulator

/**
 * Created by tosini on 23/02/15.
 */
class Wire {

  private var signal = false

  def setSignal(b: Boolean): Unit = {signal = b}
  def getSignal():Boolean = signal


}
