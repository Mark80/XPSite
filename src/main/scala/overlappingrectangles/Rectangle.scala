package main.scala.overlappingrectangles

/**
 * Created by tosini on 29/01/15.
 */
class Rectangle(val xmin:Double,val  xmax:Double,val ymin:Double,val ymax:Double) {


  if(xmin > xmax || ymin >ymax) throw  new IllegalArgumentException("xmin deve essere maggiore di xmax")

  def calcolaArea():Double = (xmax-xmin) * (ymax-ymin)

  def  intersect(rect : Rectangle):Boolean = lebasiSisovrappongono(rect) && lealtezzeSiSovrappongono(rect)

  private def lebasiSisovrappongono(rect:Rectangle):Boolean = (xmax > rect.xmin) && (xmin < rect.xmax)
  private def lealtezzeSiSovrappongono(rect: Rectangle): Boolean =  (ymax > rect.ymin) && (ymin < rect.ymax)


}
