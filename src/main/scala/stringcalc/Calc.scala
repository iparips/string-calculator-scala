package stringcalc

object Calc {

  def calc(input:String):Int = {

    input match {
      case "" => 0
      case i @ _ => add(i)
    }

  }

  private def add(input: String):Int =
    input.split(",").map(_.toInt).sum

}
