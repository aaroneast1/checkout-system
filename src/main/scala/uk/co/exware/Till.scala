package uk.co.exware

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
