package cart

class Checkout() {

  private var totalCost: Money = Money(0)

  def scan(apple: Apple): Unit = totalCost = Money(0.60)

  def total(): Money = totalCost

}
