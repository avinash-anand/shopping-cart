package cart

import org.scalatest.{FlatSpec, Matchers}

class CheckoutSpec extends FlatSpec with Matchers {

  "Checkout" should "return total as zero when nothing is scanned" in {
    val expectedTotal = Money(0)
    val checkout = new Checkout()
    checkout.total() should be(expectedTotal)
  }

}
