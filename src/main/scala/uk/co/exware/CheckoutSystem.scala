package uk.co.exware

object CheckoutSystem {

  def price(pricedItems: List[PricedItem]): BigDecimal = {
    return pricedItems.map(i => i.price).reduce((i,t) => t + i)
  }


}
