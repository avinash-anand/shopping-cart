package cart

abstract class Item {
  val price: Money
}

class Apple extends Item {
  override val price: Money = Money(0.60)
}

class Orange extends Item {
  override val price: Money = Money(0.25)
}
