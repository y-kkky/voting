package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Lesson

object Application extends Controller {
  def index = Action {
    Redirect(routes.Application.vote)
  }

  def lessons = Action {
    Ok(views.html.vote(Lesson.allOrd()))
  }
  
  def vote = Action {
    implicit request =>
    Ok(views.html.index(Lesson.all(), lessonForm))
  }

  def voteAc(id: Long) = Action {
    Lesson.vote(id)
    //Ok("Привет, чуваки!")
    Redirect(routes.Application.vote).flashing("success" -> "Дякуємо за ваш голос!")
  }
  /*
  def voteAc = Action { implicit request =>
    lessonForm.bindFromRequest.fold(
      errors => BadRequest(views.html.index(errors)),
      name => {
          Lesson.vote(name)
          Redirect(routes.Application.vote)
      })
  }*/
  
  def cles = Action {
    Lesson.create("Біологія")
    Lesson.create("Географія")
    Lesson.create("Економіка")
    Lesson.create("Інформатика")
    Lesson.create("Історія")
    Lesson.create("Математика")
    Lesson.create("Право")
    Lesson.create("Трудове навчання")
    Lesson.create("Хімія")
    Lesson.create("Українська мова і література")
    Lesson.create("Фізика")
    Ok("ok")
  }
  
  val lessonForm = Form(
      "name" -> nonEmptyText)
}
