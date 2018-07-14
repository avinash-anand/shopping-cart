package cart

import scala.collection.mutable

class Checkout() {

  private val cartItems = mutable.ArrayBuffer[Item]()
  private var offer: Option[Offer] = None

  def scan(items: Item*): Unit = cartItems.append(items: _*)

  def applyOffer(offer: Offer): Unit = this.offer = Some(offer)

  def total(): Money = {
    val totalCost = cartItems.foldLeft(Money(0))((total, item) => total + item.price)
    val appleCount = cartItems.collect { case a: Apple => a }.size
    val appleDiscount = offer.fold(Money(0)) { _ => new Apple().price * (appleCount / 2) }
    val orangeCount = cartItems.collect { case o: Orange => o }.size
    val orangeDiscount = offer.fold(Money(0)) { _ => new Orange().price * (orangeCount / 3) }
    totalCost - appleDiscount - orangeDiscount
  }

}
