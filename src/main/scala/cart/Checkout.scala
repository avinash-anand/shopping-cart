package cart

class Checkout() {

  private var totalCost: Money = Money(0)

  def scan(item: Item): Unit = totalCost = item.price

  def total(): Money = totalCost

}
