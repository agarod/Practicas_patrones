package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import views._

object Application extends Controller {


val itemForm = Form("item" -> nonEmptyText)

 
    def index = listItems
 
    def listItems() = Action{
   Ok(views.html.index(Item.list(), itemForm))
                          }

    def createItem() =Action { implicit request =>
   itemForm.bindFromRequest.fold(errors=> BadRequest(views.html.index(Item.list(), errors)),
      item => {Item.create(item)
      Redirect(routes.Application.listItems)
              }
                                )
                          }
   def deleteItem(id: Long) =Action{
   Item.delete(id)
   Redirect(routes.Application.listItems)
   }
 }