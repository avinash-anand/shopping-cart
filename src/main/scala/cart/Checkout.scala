package cart

class Checkout() {

  private var totalCost: Money = Money(0)

  def scan(items: Item*): Unit = totalCost = items.foldLeft(Money(0))((total, item) => Money(total.value + item.price.value))

  def total(): Money = totalCost

}
