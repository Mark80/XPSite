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

  def punteggioFrameNumero(num: Int): Int = {
    val frameCorrente: Frame = getFrameCorrente(num)
    var punteggio: Int = frameCorrente.numeroBirilliAbbattuti()
    if (frameCorrente.isSpare) {
      punteggio += getFrameSuccessivo(num).primoTiro
    }
    if (frameCorrente.isStrike) {
      punteggio += getFrameSuccessivo(num).primoTiro + getFrameSuccessivo(num).secondoTiro
    }
    punteggio
  }


  private[this] def getFrameSuccessivo(num: Int): Frame = {
    frames(num)
  }

  private[this] def getFrameCorrente(num: Int): Frame = {
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

  if (primoTiro + secondoTiro > 10) throw new IllegalArgumentException("numero di birilli maggiore di 10")

  def numeroBirilliAbbattuti(): Int = primoTiro + secondoTiro


  def numeroDiTiri: Int = 2

  lazy val isSpare: Boolean = numeroBirilliAbbattuti() == 10 && primoTiro < 10
  lazy val isStrike: Boolean = primoTiro == 10
}
