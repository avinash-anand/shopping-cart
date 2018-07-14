package cart

import scala.collection.mutable

class Checkout() {

  private var totalCost: Money = Money(0)
  private val cartItems = mutable.ArrayBuffer[Item]()
  private var discount = Money(0)

  def scan(items: Item*): Unit = cartItems.append(items: _*)

  def applyOffer(offer: BuyOneAppleGetOneFree): Unit = discount = Money(new Apple().price.value * (cartItems.size / 2))

  def total(): Money = {
    totalCost = cartItems.foldLeft(Money(0))((total, item) => total + item.price)
    totalCost - discount
  }

}
