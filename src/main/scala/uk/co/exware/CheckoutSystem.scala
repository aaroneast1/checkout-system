package uk.co.exware

import scala.collection.mutable.ListBuffer

class ShoppingCart {

  var items = new ListBuffer[String]()

  def addItem(item:String) :Unit = {
    items += item
  }

  def getAllItems() :List[String] = {
    return items.toList
  }
}

case class PricedItem(name:String, price:BigDecimal)

class Till {

  def scan(items: List[String]): List[PricedItem] = {
    return items.map(i => createPricedItem(i)).filter(o => o.isDefined).flatten
  }

  def createPricedItem(item:String): Option[PricedItem] = {
    return item match {
      case "Apple" => Option(PricedItem("Apple", BigDecimal("0.60")))
      case "Orange" => Option(PricedItem("Orange", BigDecimal("0.25")))
      case _ => Option.empty
    }
  }

}

object CheckoutSystem {

  def price(pricedItems: List[PricedItem]): BigDecimal = {
    return pricedItems.map(i => i.price).reduce((i,t) => t + i)
  }


}
