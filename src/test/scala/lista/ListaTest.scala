package test.scala.lista

import main.scala.lista.{Empty, Node, Lista}
import org.scalatest.FunSuite

/**
 * Created by tosini on 06/03/15.
 */


class ListaTest extends FunSuite {


  /*  The list consists of nodes. Each node has a string value,along with whatever housekeeping the list itself needs.
  New nodes are added to the end of the list.
  You can ask the list if it contains a given string. If it does, it returns the node containing that string.
  You can delete a node from the list.
  You can ask the list to return an array of all its values.*/


  test("alla lista posso aggiugere un nodo") {

    val lista = new Lista()
    lista.add("first")
    lista.add("second")
    lista.add("third")
    val firtsNode: Node = lista.find("first")
    assert(firtsNode.value == "first")
    val secondNode: Node = lista.find("second")
    assert(secondNode.value == "second")
    val thirdNode: Node = lista.find("third")
    assert(thirdNode.value == "third")
    assert(lista.find("four").isEmpty)
    lista.remove("first")
    assert(lista.find("first").isEmpty)
    assert(lista.find("second").value == "second")
    lista.remove("third")
    println(lista)
    assert(lista.find("third").isEmpty)






  }


}
