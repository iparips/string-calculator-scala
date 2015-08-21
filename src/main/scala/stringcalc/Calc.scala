package stringcalc

object Calc {

  def calc(input:String):Int = {

    input match {
      case "" => 0
      case i @ _ => i.toInt
    }

  }

}
