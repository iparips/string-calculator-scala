package stringcalc

import scala.util.{Try, Success}

object Calc {

  val DEFAULT_SEPARATORS = Array(',', '\n')

  def calc(string: String): Option[Int] = {
    string match {
      case "" => Some(0)
      case SingleNumber(n) => Some(n)
      case CommaOrNewlineSeparatedNumbers(n) => Some(n.sum)
      case NumbersWithCustomSeparator(n) => Some(n.sum)
      case _ => None
    }
  }

  object SingleNumber {
    def unapply(string: String): Option[Int] = {
      if (string.matches( """\d+""")) Some(string.toInt) else None
    }
  }

  object CommaOrNewlineSeparatedNumbers {
    def unapply(string: String): Option[Seq[Int]] = {
      val parts = string.split(DEFAULT_SEPARATORS).toSeq
      Try(parts.map(_.toInt)) match {
        case Success(numbers) => Some(numbers)
        case _ => None
      }
    }
  }

  object NumbersWithCustomSeparator {
    def unapply(string: String): Option[Seq[Int]] = {
      string match {
        case s if s.startsWith("//") => parse(s)
        case _ => None
      }
    }

    private def parse(string: String): Option[Seq[Int]] = {
      val separators = Array(string.charAt(2)) ++ DEFAULT_SEPARATORS
      val numbersStr = string.drop(3)
      val parts = numbersStr.split(separators).toSeq
      Try(parts.map(_.toInt)).toOption
    }
  }

}


