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
    val appleDiscount = offer.fold(Money(0)) { _ => Money((appleCount / 2) * new Apple().price.value) }
    totalCost - appleDiscount
  }

}
