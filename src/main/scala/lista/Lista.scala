package main.scala.lista

/**
 * Created by tosini on 09/03/15.
 */
class Lista {


  private var nodes: Node = Empty

  def find(s: String): Node = nodes.contains(s)

  def add(s: String): Unit = nodes =nodes.add(s)

  def remove(value: String): Unit =
    if (nodes.value == value)
      nodes = nodes.next
    else nodes.remove(value)

  override def toString(): String = if (nodes != null) nodes.toString else ""


}

 trait Node {

  def contains(s: String): Node
  def add(value: String): Node
  def remove(s: String): Unit
  def value: String
  def next: Node
  def isEmpty:Boolean


}

private[lista] object Empty extends Node{

  def contains(s: String): Node = null
  def value: String = null
  def next: Node = Empty
  def isEmpty:Boolean = true
  def add(value: String): Node = new NotEmpty(value, Empty)
  override def remove(s: String): Unit = throw  new NoSuchElementException
  override def toString() = "Empty"

}

private[lista] class NotEmpty(var value: String,  var next: Node) extends Node {

  def contains(s: String): Node = {
    if (value == s) this
    else if (next != Empty) next.contains(s)
    else Empty
  }


  override def add(value: String): Node = {
    if (next == Empty) this.next = new NotEmpty(value, Empty)
    else next.add(value)
    this
  }

  override def remove(s: String): Unit = {
    if (next.value == s) next = next.next
    else next.remove(s)
  }

  def isEmpty:Boolean = false


  override def toString() = "(" + value + "," + " " + next.toString + ")"

}


