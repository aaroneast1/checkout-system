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