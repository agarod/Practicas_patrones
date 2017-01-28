package models



import play.api._
import play.api.mvc._
import scala.collection.mutable.HashMap

case class Item(id: Long, item: String) 


object Item{

	val organizador = new HashMap[Long, Item]
	var id = 0L
	
	def nexttId():Long = {id += 1; id}
	
	def create(item: String) = {val id = nexttId; organizador +=id -> Item(id, item)}
	
	def delete(id: Long) = {organizador -= id}
	
	def list(): List[Item] = {organizador.values.toList}
}