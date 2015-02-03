package test.scala.bowlig

/**
 * Created by tosini on 31/01/15.
 */

import main.scala.bowling.{Frame, Game}
import org.scalatest.FunSuite


/*
Una partita di bowling è composta da 10 frame (frazioni) per ognuna delle quali si hanno a disposizione 2 tiri per cercare di abbattere tutti i birilli.
 Il punteggio viene annotato in una apposita scheda con 10 caselle principali, una per ogni turno di gioco e normalmente si possono incontrare queste situazioni:

1º caso - è il più semplice: se non vengono abbattuti tutti i birilli nei due tiri a disposizione, si procede semplicemente alla somma aritmetica dei birilli
abbattuti nei due turni del frame e si continua.
2º caso si sono abbattuti tutti e 10 i birilli al secondo tiro, cioè si è fatto uno spare (indicato solitamente con il segno "/").
 In questo caso il punteggio del frame è di 10 punti più il numero dei birilli abbattuti con il tiro successivo (cioè il primo del frame seguente).
Ad esempio, se nel primo frame si esegue uno spare, e col primo tiro del frame seguente si abbattono 6 birilli,
 i punti da segnare nella casella del primo frame saranno 16 (10+6). Il punteggio massimo ottenibile con uno spare è quindi 20,
nel caso in cui vengano abbattuti tutti e 10 i birilli nel tiro successivo.

3º caso
si sono abbattuti tutti i birilli al primo tiro, ovvero si è fatto uno strike (indicato solitamente con il segno "X").
Lo strike vale 10 punti più il numero di birilli abbattuti con i due tiri successivi. In questo caso non viene effettuato il secondo tiro (di riserva).
Ad esempio, se nel primo frame si fa strike, e nei due tiri seguenti vengono abbattuti rispettivamente 7 e 2 birilli, il punteggio del primo frame sarà 19 (10+7+2).
Il punteggio massimo ottenibile con uno strike è quindi 30, nel caso vengano abbattuti 10 birilli anche nei 2 tiri successivi (cioè si siano fatti 3 strike di fila,
 il cosiddetto "turkey").

Se nell'ultimo frame della partita viene effettuato uno spare o uno strike,
si effettuano uno o due tiri addizionali per permettere il calcolo del punteggio del frame, dato che, come si è visto,
 il punteggio in questi casi deve tener conto dei tiri successivi. Nel caso si sia fatto strike, i tiri addizionali saranno due
 , mentre per lo spare si effettuerà solo un altro tiro.
*/
class TestScoreBowling extends FunSuite {


  test("Per ogni frame ci sono due tiri ") {
    val frame = new Frame(3, 4)
    val numeroDiTiri = frame.numeroDiTiri
    assert(numeroDiTiri == 2)
  }

  test("Non posso aggiungere più di 10 frame ad una partita") {
    val game = new Game();
    aggiungoDieciFrameTo(game)
    assert(game.numOfFrames == 10)
    game.addFrame(new Frame(2, 5))
    assert(game.numOfFrames == 10)
  }



  test("in un frame si possono abbattare al massimo 10 birilli") {
    try {
      val frame = new Frame(tiro1 = 4, tiro2 = 8)
      assert(false)
    } catch {
      case ex: IllegalArgumentException => assert(true)
    }
  }
  test("Se non si abbattono tutti i birilli nei due turni il punteggio è dei birilli buttati giù") {
    val frame = new Frame(3, 4)
    assert(frame.numeroBirilliAbbttuti() == 7)

    val frame2 = new Frame(5, 4)
    assert(frame2.numeroBirilliAbbttuti() == 9)
  }

  test("l'inserimento mantiene l'orine di inserimento dei frame") {
    val game = new Game();
    val frame1 = new Frame(3, 7)
    val frame2 = new Frame(3, 4)
    game.addFrame(frame1, frame2)
    assert(game.getFrame(1) == frame1)
    assert(game.getFrame(2) == frame2)
  }


  test("Se abbatto tutti i birilli nei due tiri di un frame(Spare) allora il punteggio è 10 + i birilli abbattuti nel tiro successivo") {
    val game = new Game();
    val frame1 = new Frame(3, 7)
    val frame2 = new Frame(3, 4)
    game.addFrame(frame1, frame2)
    val punteggioPrimoFrame = game.punteggioFrameNumero(1)
    assert(punteggioPrimoFrame == 13)
  }

  test("Se abbatto tutti i birilli al primo  tiro  unn frame(Strike) allora il punteggio è 10 + i birilli abbattuti nei due tiri successivi") {
    val game = new Game();
    val frame1 = new Frame(10, 0)
    val frame2 = new Frame(3, 4)
    game.addFrame(frame1, frame2)
    val punteggioPrimoFrame = game.punteggioFrameNumero(1)
    assert(punteggioPrimoFrame == 17)
  }

  test("se l'ultimo frame  uno spare posso aggiugere un tiro") {
    val game = new Game()
    aggiungoDieciFrameWhereLastIsASpareTo(game)
    game.addFrame(new Frame(4, 0))
    assert(game.numOfFrames == 11)
  }

  test("se l'ultimo frame uno strike posso aggiugere un tiro") {
    val game = new Game()
    aggiungoDieciFrameWhereLastIsAStrikeTo(game)
    game.addFrame(new Frame(4, 0))
    assert(game.numOfFrames == 11)
  }

  test("posso calcolare il punteggio totale di una partita"){
    val game = new Game()
    aggiungoDieciFrameTo(game)
    assert(game.score() == 40)
  }

  test("posso calcolare il punteggio totale di una partita dove l'ultimo tiro è uno strike") {
    val game = new Game()
    aggiungoDieciFrameWhereLastIsAStrikeTo(game)
    game.addFrame(new Frame(4, 5))
    assert(game.numOfFrames == 11)
    assert(game.score() == 55)
  }


  private def getLastFrame(game: Game): Frame = {
    game.getFrame(10)
  }

  private def aggiungoDieciFrameTo(game: Game) {
    for (x <- 0 until 10) {
      game.addFrame(new Frame(1, 3))
    }
  }

  private def aggiungoDieciFrameWhereLastIsASpareTo(game: Game) {
    for (x <- 0 until 9) {
      game.addFrame(new Frame(1, 3))
    }
    game.addFrame(new Frame(1, 9))
  }

  private def aggiungoDieciFrameWhereLastIsAStrikeTo(game: Game) {
    for (x <- 0 until 9) {
      game.addFrame(new Frame(1, 3))
    }
    game.addFrame(new Frame(10, 0))
  }


}
  