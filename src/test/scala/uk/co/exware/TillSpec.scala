package uk.co.exware

import org.scalatest.{Matchers, FlatSpec}



class TillSpec extends FlatSpec with Matchers{

  val underTest = new Till()

  "A Till" should "create a list of priced items" in {

    val items: List[String] = List("Apple", "Apple", "Orange")

    val results: List[PricedItem] = underTest.scan(items)

    print(results)

    results.size shouldEqual 3

  }

}


