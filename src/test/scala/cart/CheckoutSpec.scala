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
    checkout.scan(new Apple(), new Orange())
    checkout.total() should be(expectedTotal)
  }

  it should "scan 3 apples and 1 orange and return total of 2.05" in {
    val expectedTotal = Money(2.05)

    val checkout = new Checkout()
    checkout.scan(new Apple(), new Apple(), new Orange(), new Apple())
    checkout.total() should be(expectedTotal)
  }

  it should "scan 2 apples, apply buy one get one free offer and return total of 0.60" in {
    val expectedTotal = Money(0.60)

    val checkout = new Checkout()
    checkout.scan(new Apple(), new Apple())
    checkout.applyOffer(new BuyOneAppleGetOneFree())
    checkout.total() should be(expectedTotal)
  }

  it should "scan 4 apples, apply buy one get one free offer and return total of 1.2" in {
    val expectedTotal = Money(1.2)

    val checkout = new Checkout()
    checkout.scan(new Apple(), new Apple(), new Apple(), new Apple())
    checkout.applyOffer(new BuyOneAppleGetOneFree())
    checkout.total() should be(expectedTotal)
  }

  it should "scan 2 oranges and 1 apple, apply buy one apple get one free offer and return total of 1.1" in {
    val expectedTotal = Money(1.1)

    val checkout = new Checkout()
    checkout.scan(new Orange(), new Orange(), new Apple())
    checkout.applyOffer(new BuyOneAppleGetOneFree())

    checkout.total() should be(expectedTotal)
  }

  it should "scan 3 oranges, apply three for the price of two offer and return total of 0.50" in {
    val expectedTotal = Money(0.50)

    val checkout = new Checkout()
    checkout.scan(new Orange(), new Orange(), new Orange())
    checkout.applyOffer(BuyThreeOrangesForThePriceOfTwo)
    checkout.total() should be(expectedTotal)
  }


}
