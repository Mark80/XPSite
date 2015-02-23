package main.scala.digitalSimulator

import javax.swing.event.{ChangeEvent, ChangeListener}

/**
 * Created by tosini on 23/02/15.
 */
class Inverter(in:Wire,out:Wire) extends ChangeListener{

  out.setSignal(!in.getSignal())

   def stateChange():Unit ={
     out.setSignal(!in.getSignal())
   }

  override def stateChanged(e: ChangeEvent): Unit = ???
}
