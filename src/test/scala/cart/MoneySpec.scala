package cart

import org.scalatest.{FlatSpec, Matchers}

class MoneySpec extends FlatSpec with Matchers {

  "Money" should "with value 1 add another money with value 2 and return new money with value 3" in {
    val expectedMoney = Money(3)

    val money1 = Money(1)
    val money2 = Money(2)
    money1 + money2 should be(expectedMoney)
  }

  it should "with value 3 subtract another money with value 2 and return new money with value 1" in {
    val expectedMoney = Money(1)

    val money1 = Money(3)
    val money2 = Money(2)
    money1 - money2 should be(expectedMoney)
  }

  it should "multiple integer numbers and returned new money with new value" in {
    val expectedMoney = Money(3)

    val money1 = Money(1)
    money1 * 3 should be(expectedMoney)
  }

}
