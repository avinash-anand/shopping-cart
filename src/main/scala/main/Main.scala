package main

import cart._

object Main {

  def main(args: Array[String]): Unit = {
    val inputItems = args.collect {
      case a: String if "apple".equalsIgnoreCase(a) => new Apple()
      case a: String if "orange".equalsIgnoreCase(a) => new Orange()
    }

    val checkout = new Checkout()
    checkout.scan(inputItems: _*)
    checkout.applyOffer(BuyOneAppleGetOneFree)
    checkout.applyOffer(BuyThreeOrangesForThePriceOfTwo)

    println(s"Total Cart Value = £${checkout.total().value}")

  }

}
