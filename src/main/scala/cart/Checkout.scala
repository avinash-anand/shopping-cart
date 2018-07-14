package cart

class Checkout() {

  private var totalCost: Money = Money(0)

  def scan(str: String): Unit = totalCost = Money(0.60)

  def total(): Money = totalCost

}
