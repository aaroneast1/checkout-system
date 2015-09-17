package uk.co.exware

import org.scalatest.{Matchers, FlatSpec}

class CheckoutSystemSpec extends FlatSpec with Matchers{

  val underTest = CheckoutSystem

  "A Checkout System" should "be able to total the cost of scanned items" in {

    val apple = PricedItem("Apple", BigDecimal("0.60"))
    val orange = PricedItem("Orange", BigDecimal("0.25"))

    val pricedItems = List(apple, apple, apple, apple, orange, orange)

    underTest.price(pricedItems) shouldEqual BigDecimal("2.90")

  }



}
