package uk.co.exware

import scala.collection.mutable.ListBuffer

class ShoppingCart {

  var items = new ListBuffer[String]()

  def addItem(item:String) :Unit = {
    items += item
  }

  def getAllItems :List[String] = {
    items.toList
  }
}

case class PricedItem(name:String, price:BigDecimal)

object Till {

  def scan(items: List[String]): List[PricedItem] = {
    items.map(i => createPricedItem(i)).filter(o => o.isDefined).flatten
  }

  def createPricedItem(item:String): Option[PricedItem] = {
    item match {
      case "Apple" => Option(PricedItem("Apple", BigDecimal("0.60")))
      case "Orange" => Option(PricedItem("Orange", BigDecimal("0.25")))
      case _ => Option.empty
    }
  }

}

object CheckoutSystem {

  def threeForThePriceOfTwo(items: List[PricedItem]):BigDecimal = {
    val remainder = items.size % 3
    val price = items.head.price

    ((((items.size - remainder) / 3) * 2) * price) + (remainder * price)
  }

  def buyOneGetOneFree(items: List[PricedItem]): BigDecimal = {
    val remainder = items.size % 2
    val price = items.head.price

    (price * remainder) + ((items.size - remainder) / 2) * price
  }

  def checkout(shoppingCart: ShoppingCart, offers:Boolean): BigDecimal = {
    val pricedItems = Till.scan(shoppingCart.getAllItems)

    if(offers){
      val totalPriceForApples = buyOneGetOneFree(pricedItems.filter(p => "Apple" == p.name))
      val totalPriceForOranges = threeForThePriceOfTwo(pricedItems.filter(p => "Orange" == p.name))
      totalPriceForApples + totalPriceForOranges
    }else{
      pricedItems.map(i => i.price).sum
    }

  }




}
