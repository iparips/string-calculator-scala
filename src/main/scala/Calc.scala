package stringcalc

object Calc {

  def calc(string: String): Option[Int] = {
    string match {
      case "" => Some(0)
      // case s if s.matches( """\d+""") => Some(s.toInt)
      case SingleNumber(n) => Some(n)
    }
  }

  object SingleNumber {
    def unapply(string: String): Option[Int] = {
      if (string.matches("""\d+""")) Some(string.toInt) else None
    }
  }

}


