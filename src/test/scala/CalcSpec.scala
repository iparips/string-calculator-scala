import org.specs2.mutable.Specification

import stringcalc.Calc

class CalcSpec extends Specification {
  "This is a specification for String Calculator".txt

  "calc" >> {

    "given empty string, should return 0" >> {
      Calc.calc("") shouldEqual(0)
    }

    "given string with one number it returns that number" >> {
      Calc.calc("1") shouldEqual(1)
      Calc.calc("2") shouldEqual(2)
    }

    "given string with multiple comma separated numbers it adds them" >> {
      Calc.calc("1,2") shouldEqual(3)
      Calc.calc("2,3,4,5") shouldEqual(14)
    }

    """given input of '1\n2,3' it returns 6""" >> {
      Calc.calc("1\n2,3") shouldEqual(6)
    }

    """given input of '//;\n1;2' it returns 3""" >> {
      Calc.calc("//;1\n2;3") shouldEqual(6)
    }

  }
}
