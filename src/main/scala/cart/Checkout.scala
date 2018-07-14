package cart

import scala.collection.mutable

class Checkout() {

  private val cartItems = mutable.ArrayBuffer[Item]()
  private val offers = mutable.Set[Offer]()

  def scan(items: Item*): Unit = cartItems.append(items: _*)

  def applyOffer(offer: Offer): Unit = offers.add(offer)

  def total(): Money = calculateTotalCostPrice - calculateDiscount

  private def calculateTotalCostPrice: Money = cartItems.foldLeft(Money(0))((total, item) => total + item.price)

  private def calculateDiscount: Money = offers.map {
    case BuyOneAppleGetOneFree => calculateAppleDiscount
    case BuyThreeOrangesForThePriceOfTwo => calculateOrangeDiscount
  }.foldLeft(Money(0))((total, money) => total + money)

  private def calculateOrangeDiscount: Money = {
    val numOfOranges = cartItems.collect { case a: Orange => a }.size
    new Orange().price * (numOfOranges / 3)
  }

  private def calculateAppleDiscount: Money = {
    val numOfApples = cartItems.collect { case a: Apple => a }.size
    new Apple().price * (numOfApples / 2)
  }

}
