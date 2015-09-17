package uk.co.exware

import org.scalatest.{Matchers, FlatSpec}

class ShoppingCartSpec extends FlatSpec with Matchers {

  val underTest = new ShoppingCart()

  "A shopping cart" should "be able to add an apple to the shopping cart" in {
    underTest.addItem("Apple")

    val results = underTest.getAllItems()

    results.size shouldEqual 1
    results.head shouldEqual "Apple"
  }
}

class TillSpec extends FlatSpec with Matchers{

  val underTest = new Till()

  "A Till" should "create a list of priced items" in {

    val items: List[String] = List("Apple", "Apple", "Orange")

    val results: List[PricedItem] = underTest.scan(items)

    print(results)

    results.size shouldEqual 3

  }

}

class CheckoutSystemSpec extends FlatSpec with Matchers{

  val underTest = CheckoutSystem

  "A Checkout System" should "be able to total the cost of scanned items" in {

    val apple = PricedItem("Apple", BigDecimal("0.60"))
    val orange = PricedItem("Orange", BigDecimal("0.25"))

    val pricedItems = List(apple, apple, apple, apple, orange, orange)

    underTest.price(pricedItems) shouldEqual BigDecimal("2.90")

  }



}
