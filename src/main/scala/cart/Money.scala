package cart

case class Money(value: BigDecimal) {

  def +(that: Money): Money = Money(value + that.value)

}
