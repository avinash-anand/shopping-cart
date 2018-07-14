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
    checkout.scan("APPLE")
    checkout.total() should be(expectedTotal)
  }

}
