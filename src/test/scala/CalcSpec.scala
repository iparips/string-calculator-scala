import org.specs2.mutable.Specification

import stringcalc.Calc

class CalcSpec extends Specification {
  "This is a specification for String Calculator".txt

  "calc" >> {

    "given empty string, should return 0" >> {
      Calc.calc("") shouldEqual(0)
    }

  }
}
