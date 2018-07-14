package cart

import org.scalatest.{FlatSpec, Matchers}

class CheckoutSpec extends FlatSpec with Matchers {

  "Checkout" should "return total as zero when nothing is scanned" in {
    val expectedTotal = Money(0)

    val checkout = new Checkout()
    checkout.total() should be(expectedTotal)
  }

  it should "scan an apple and return total as 0.60" in {
    val expectedTotal = Money(0.60)

    val checkout = new Checkout()
    checkout.scan(new Apple())
    checkout.total() should be(expectedTotal)
  }

  it should "scan an orange and return total as 0.25" in {
    val expectedTotal = Money(0.25)

    val checkout = new Checkout()
    checkout.scan(new Orange())
    checkout.total() should be(expectedTotal)
  }

  it should "scan both an apple and an orange and return a total of 0.85" in {
    val expectedTotal = Money(0.85)

    val checkout = new Checkout()
    checkout.scan(new Apple, new Orange)
    checkout.total() should be(expectedTotal)
  }

}
