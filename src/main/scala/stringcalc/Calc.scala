package stringcalc

object Calc {

  val DEFAULT_SEPARATORS = Array(',', '\n')

  def calc(input: String): Int = {

    input match {
      case "" => 0
      case i@_ => add(i)
    }

  }

  private def add(input: String): Int = {

    val (numbers, separators) =
      if (input.startsWith("//"))
        splitNumbersAndSeparators(input)
      else (input, DEFAULT_SEPARATORS)

    try {
      numbers.split(separators).map(_.toInt).sum
    } catch {
      case e: Exception => throw new Exception(s"invalid input '$input'")
    }

  }

  private def splitNumbersAndSeparators(input:String): (String, Array[Char]) = {
    val n = input.drop(3)
    val s = Array(input.charAt(2)) ++ DEFAULT_SEPARATORS
    (n, s)
  }

}