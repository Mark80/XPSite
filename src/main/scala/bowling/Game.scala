package main.scala.bowling

/**
 * Created by tosini on 01/02/15.
 */
class Game {


  def score():Int ={
    var result =0
    for( i <- 1 to  10){
      result += punteggioFrameNumero(i)
    }
  result
  }


  private var frames: Vector[Frame] = Vector.empty[Frame]

  def addFrame(frame: Frame*): Unit = {
    if (frames.size < 10)
      frames = frames.++(frame)
    else
    if (lastIsASpare || lastIsAStrike)
      frames = frames.:+(frame.head)
  }

  private def lastIsASpare: Boolean = {
    frames.size == 10 && getFrame(10).isSpare
  }

  private  def lastIsAStrike: Boolean = {
    frames.size == 10 && getFrame(10).isStrike
  }

  def getFrame(num: Int): Frame = frames(num - 1)

  def numOfFrames: Int = frames.size

  def punteggioFrameNumero(num: Int): Int = {
    val frame: Frame = frames(num - 1)
    var punteggio: Int = frame.numeroBirilliAbbttuti()
    if (frame.isSpare) {
      punteggio += frames(num).tiro1
    }
    if (frame.isStrike) {
      punteggio += frames(num).tiro1 + frames(num).tiro2
    }
    punteggio
  }

}

class Frame(val tiro1: Int, val tiro2: Int) {

  def numeroBirilliAbbttuti(): Int = tiro1 + tiro2

  if (tiro1 + tiro2 > 10) throw new IllegalArgumentException("numero di birilli maggiore di 10")

  def numeroDiTiri: Int = 2

  lazy val isSpare: Boolean = numeroBirilliAbbttuti() == 10 && tiro1 < 10
  lazy val isStrike: Boolean = tiro1 == 10
}
