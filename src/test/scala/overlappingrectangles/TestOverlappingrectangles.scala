package test.scala.overlappingrectangles

import main.scala.overlappingrectangles.Rectangle
import org.scalatest.FunSuite

/**
 * Created by tosini on 29/01/15.
 *
 * Design a rectangle abstraction that supports the following operations:
Constructed by parameters xmin, ymin, xmax and ymax
(what happens if xmin is larger or equal to xmax? You decide what feels most natural..)
Computing the Area and Circumference of the rectangle
Checking if a rectangle overlaps another rectangles
(does that mean they share points on the outline or inside? TDD is about design - so you decide!)
(does that mean they share points on the outline or inside? TDD is about design - so you decide!)
 *
 */
class TestOverlappingrectangles extends FunSuite {

  test("test") {
    assert(true)
  }

  test("posso creare un rettangolo con le coordinate") {
    val rect = new Rectangle(0.0, 0.0, 0.0, 0.0)
    assert(rect != null)
  }

  test("non posso creare un rettangolo dove xmin > xmax") {

    try {
      val rect = new Rectangle(5.0, 4.0, 0.0, 0.0)
      assert(false)
    } catch {
      case ex: IllegalArgumentException => assert(true)
    }

  }

  test("non posso creare un rettangolo dove ymin > ymax") {

    try {
      val rect = new Rectangle(0.0, 0.0, 5.0, 4.0)
      assert(false)
    } catch {
      case ex: IllegalArgumentException => assert(true)
    }

  }

  test("se calcolo l'area di un rettangolo con la dimensione dei lati zero l'area è = zero") {

    val rect = new Rectangle(0.0, 0.0, 0.0, 0.0)
    val area = rect.calcolaArea()
    assert(area == 0)

  }

  test("se calcolo l'area di un rettangolo questa è uguale alla base per l'altezza") {

    val rect = new Rectangle(0.0, 5.0, 0.0, 5.0)
    val area = rect.calcolaArea()
    assert(area == 5 * 5)
    val rect2 = new Rectangle(1.0, 5.0, 2.0, 5.0)
    assert(rect2.calcolaArea() == 4 * 3)

  }


  test("se due rettangoli anno le stesse coordinate  allora si sovrappongono") {

    val rect1 = new Rectangle(0.0, 5.0, 0.0, 5.0)
    val rect2 = new Rectangle(0.0, 5.0, 0.0, 5.0)
    assert(rect1 intersect rect2)
  }

  test("due rettangoli con y uguali si sovrappongon se si sovrappongono le basi") {
    val rect1 = new Rectangle(1.0, 5.0, 0.0, 5.0)
    val rect2 = new Rectangle(2.0, 5.0, 0.0, 5.0)
    val rect3 = new Rectangle(6.0, 9.0, 0.0, 5.0)
    val rect4 = new Rectangle(0.0, 0.5, 0.0, 5.0)
    val rect5 = new Rectangle(1.5, 3.5, 0.0, 5.0)
    assert(rect1 intersect rect2)
    assert(rect2 intersect rect1)
    assert(!(rect1 intersect rect3))
    assert(!(rect3 intersect rect1))
    assert(!(rect1 intersect rect4))
    assert(!(rect4 intersect rect1))
    assert(rect1 intersect rect5)
    assert(rect5 intersect rect1)
  }

  test("due rettangoli con x uguali si sovrappongon se si sovrappongono le altezze") {
    val rect1 = new Rectangle(0.0, 5.0,1.0, 5.0)
    val rect2 = new Rectangle(0.0, 5.0,6.0, 9.0)
    val rect3 = new Rectangle(0.0, 5.0,4.0, 9.0)
    val rect4 = new Rectangle(0.0, 5.0,2.0, 4.0)

    assert(!(rect1 intersect rect2))
    assert(!(rect2 intersect rect1))
    assert(rect1 intersect rect3)
    assert(rect1 intersect rect4)
    assert(rect4 intersect rect1)


  }


}