package cart

sealed trait Offer

case object BuyOneAppleGetOneFree extends Offer
case object BuyThreeOrangesForThePriceOfTwo extends Offer


