package test.scala.karateChop

import main.scala.karateChop.Chopper.chop
import org.scalatest.FunSuite

/**
 * Created by tosini on 31/01/15.
 */
class TestKarateChop extends FunSuite{

 test("se cerco un numerino in  un array ritorna l'indice del numero  nell'array altrimenti -1") {

   assertResult(-1)(chop(3,Array()))
   assertResult(0)(chop(1,Array(1)))
   assertResult(-1)(chop(3,Array(1,2)))
   assertResult(1)(chop(2,Array(1,2)))
   assertResult(2)(chop(4,Array(1,2,4)))
   assertResult(4)(chop(8,Array(1,2,4,5,8)))



 }









}
