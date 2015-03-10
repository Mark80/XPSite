package main.scala.bowling

/**
 * Created by tosini on 01/02/15.
 */
class Game {

  private[this] var frames: Vector[Frame] = Vector.empty[Frame]

  def score(): Int = {
    var result = 0
    for (i <- 1 to 10) {
      result += punteggioFrameNumero(i)
    }
    result
  }

  def punteggioFrameNumero(implicit num: Int): Int = {
    var punteggio: Int =  frameCorrente.numeroBirilliAbbattuti()
    if (frameCorrente.isSpare) {
      punteggio += frameSuccessivo.primoTiro
    }
    if (frameCorrente.isStrike) {
      punteggio += frameSuccessivo.primoTiro + frameSuccessivo.secondoTiro
    }
    punteggio
  }


  private[this] def frameSuccessivo(implicit num: Int): Frame = {
    frames(num)
  }

  private[this] def frameCorrente(implicit num: Int): Frame = {
    frames(num - 1)
  }

  def addFrame(frame: Frame*): Unit = {
    if (frames.size < 10)
      frames = frames.++(frame)
    else
    if (lastIsASpare || lastIsAStrike)
      frames = frames.:+(frame.head)
  }

  private[this] def lastIsASpare: Boolean = {
    frames.size == 10 && getLastFrame(10).isSpare
  }

  private[this] def lastIsAStrike: Boolean = {
    frames.size == 10 && getLastFrame(10).isStrike
  }

  def getLastFrame(num: Int): Frame = frames(num - 1)

  def numOfFramesCompleted: Int = frames.size


}

class Frame(val primoTiro: Int, val secondoTiro: Int) {

  private[this] val tuttiBirilli = 10

  if (primoTiro + secondoTiro > tuttiBirilli) throw new IllegalArgumentException("numero di birilli maggiore di 10")

  def numeroBirilliAbbattuti(): Int = primoTiro + secondoTiro

  lazy val isSpare: Boolean = numeroBirilliAbbattuti() == tuttiBirilli && primoTiro < tuttiBirilli
  lazy val isStrike: Boolean = primoTiro == 10
}
