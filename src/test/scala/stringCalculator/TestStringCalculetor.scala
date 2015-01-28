package test.scala.stringCalculator

import main.scala.strinCalculetor.StringCalculator
import org.scalatest.FunSuite

/**
 * Created by tosini on 28/01/15.
 */
class TestStringCalculetor extends FunSuite {

  private val calculetor = new StringCalculator()

  test("Creo StringCalculetor") {
    val result: Int = somma("")
    assert(calculetor != null)
  }

  test("se passo una stringa vuota il risultato è 0") {
    val result: Int = somma("")
    assert(result ==0)
  }

  test("se passo una stringa con un numero  il risultato è il numero") {
    val result1: Int = somma("1")
    assert(result1 ==1)
    val result2: Int = somma("2")
    assert(result2 == 2)
    val result6: Int = somma("6")
    assert(result6 == 6)
  }

  private def somma(str : String): Int = {
    calculetor.add(str)
  }

  test("se passo una stringa con due  numeri  il risultato è la somma dei  numeri") {

    var result = somma("1,2")
    assert(result == 3)
    result = somma("2,2")
    assert(result == 4)
    result = somma("2,7")
    assert(result == 9)
  }

  test("se passo una stringa con tre  numeri  il risultato è la somma dei  numeri") {

    var result = somma("1,2,3")
    assert(result == 6)
    result = somma("2,2,2")
    assert(result == 6)
    result = somma("2,7,6")
    assert(result == 15)
  }

  test("se passo una stringa con N  numeri  il risultato è la somma dei  numeri") {

    var result = somma("1,2,3,7,4,2")
    assert(result == 19)
    result = somma("2,2,2,2")
    assert(result == 8)
    result = somma("2,7,6,5,5")
    assert(result == 25)
  }

  test("posso usare anche la new line come delimitatore ") {

    var result = somma("1\n2")
    assert(result == 3)
    result = somma("2\n2")
    assert(result == 4)
    result = somma("2\n7")
    assert(result == 9)
    result = somma("2\n7,1")
    assert(result == 10)

  }

  test("non si possono inserire numeri negativi") {

    try {
      var result = somma("-2")
      assert(false)
    } catch {
      case ex:IllegalArgumentException => assert(true)
    }

  }

  test("un numero più grande di 1000 deve essere ignorato nella somma"){
    var result = somma("1001")
    assert(result == 0)
    result = somma("2,1001")
    assert(result == 2)


  }

}
