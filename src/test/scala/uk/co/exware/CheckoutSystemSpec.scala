package uk.co.exware

import org.scalatest.{Matchers, FlatSpec}
import org.scalamock.scalatest.MockFactory

class ShoppingCartSpec extends FlatSpec with Matchers {

  val underTest = new ShoppingCart()

  "A shopping cart" should "be able to add an apple to the shopping cart" in {
    underTest.addItem("Apple")

    val results = underTest.getAllItems

    results.size shouldEqual 1
    results.head shouldEqual "Apple"
  }
}

class TillSpec extends FlatSpec with Matchers{

  val underTest = Till

  "A Till" should "create a list of priced items" in {

    val items: List[String] = List("Apple", "Apple", "Orange")

    val results: List[PricedItem] = underTest.scan(items)

    print(results)

    results.size shouldEqual 3

  }

}

class CheckoutSystemSpec extends FlatSpec with MockFactory with Matchers{

  val underTest = CheckoutSystem

  "A Checkout System" should "be able to total the cost of scanned items" in {

    val stubShoppingCart = stub[ShoppingCart]

    (stubShoppingCart.getAllItems _).when().returns(List("Apple", "Apple", "Apple", "Apple", "Orange", "Orange"))

    underTest.checkout(stubShoppingCart, false) shouldEqual BigDecimal("2.90")

  }

  "A Checkout System" should "be able to apply an offer of buy one get one free on even number of items" in {
    val apple = PricedItem("Apple", BigDecimal("0.60"))
    val apples = List(apple, apple)

    val result = underTest.buyOneGetOneFree(apples)

    result shouldEqual BigDecimal("0.60")

  }

  "A Checkout System" should "be able to apply an offer of buy one get one free on uneven number items" in {
    val apple = PricedItem("Apple", BigDecimal("0.60"))
    val apples = List(apple, apple, apple)

    val result = underTest.buyOneGetOneFree(apples)

    result shouldEqual BigDecimal("1.20")

  }


  "A Checkout System" should "be able to apply an offer of three for the price of two on multiples of 3" in {
    val orange = PricedItem("Orange", BigDecimal("0.25"))
    val oranges = List(orange, orange, orange)

    val result = underTest.threeForThePriceOfTwo(oranges)

    result shouldEqual BigDecimal("0.50")
  }

  "A Checkout System" should "be able to apply an offer of three for the price of two on non multiples of three" in {
    val orange = PricedItem("Orange", BigDecimal("0.25"))
    val oranges = List(orange, orange, orange, orange)

    val result = underTest.threeForThePriceOfTwo(oranges)

    result shouldEqual BigDecimal("0.75")

  }

  "A Checkout System" should "be able to apply offers at checkout" in {
    val stubShoppingCart = stub[ShoppingCart]

    (stubShoppingCart.getAllItems _).when().returns(List("Apple", "Apple", "Orange", "Orange", "Orange"))

    underTest.checkout(stubShoppingCart, true) shouldEqual BigDecimal("1.10")
  }









}
