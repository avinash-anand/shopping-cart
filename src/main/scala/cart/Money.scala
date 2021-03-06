package cart

case class Money(value: BigDecimal) {

  def +(that: Money): Money = Money(value + that.value)

  def -(that: Money): Money = Money(value - that.value)

  def *(n: Int): Money = Money(n * value)

}
