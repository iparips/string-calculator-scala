package stringcalc

import scala.util.{Try, Success}

object Calc {

  def calc(string: String): Option[Int] = {
    string match {
      case "" => Some(0)
      case SingleNumber(n) => Some(n)
      case CommaSeparatedNumbers(numbers) => Some(numbers.sum)
      case _ => None
    }
  }

  object SingleNumber {
    def unapply(string: String): Option[Int] = {
      if (string.matches("""\d+""")) Some(string.toInt) else None
    }
  }

  object CommaSeparatedNumbers {
    def unapply(string: String): Option[Seq[Int]] = {
      val parts = string.split(',').toSeq
      //Try(parts.map(_.toInt)).toOption
      Try(parts.map(_.toInt)) match {
        case Success(numbers) => Some(numbers)
        case _ => None
      }
    }
  }
}


