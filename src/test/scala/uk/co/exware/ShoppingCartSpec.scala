package uk.co.exware

import org.scalatest._

class ShoppingCartSpec extends FlatSpec with Matchers {

	val underTest = new ShoppingCart()

	"A shopping cart" should "be able to add an apple to the shopping cart" in {
		underTest.addItem("Apple")

		val results = underTest.getAllItems()

		results.size shouldEqual 1
		results.head shouldEqual "Apple"
	}



}