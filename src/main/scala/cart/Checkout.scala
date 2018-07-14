package cart

class Checkout() {

  private var totalCost: Money = Money(0)

  def scan(items: Item*): Unit = totalCost = items.foldLeft(Money(0))((total, item) => total + item.price)

  def applyOffer(offer: BuyOneAppleGetOneFree): Unit = totalCost = Money(totalCost.value - new Apple().price.value)

  def total(): Money = totalCost

}
