package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

case class Lesson(id: Long, name: String, score: Int)

object Lesson {

  def all(): List[Lesson] = DB.withConnection { implicit c =>
    SQL("select * from lesson").as(lesson *)
  }
  
  def allOrd(): List[Lesson] = DB.withConnection { implicit c =>
    SQL("select * from lesson order by score DESC").as(lesson *)
  }

  def vote(id: Long) {
    DB.withConnection { implicit c =>
      SQL("update lesson set score=score+1 where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }
  
  def create(name: String) {
  DB.withConnection { implicit c =>
    SQL("insert into lesson (name) values ({name})").on(
      'name -> name
    ).executeUpdate()
  }
}

  val lesson = {
    get[Long]("id") ~ 
      get[String]("name") ~
      get[Int]("score") map {
      case id~name~score => Lesson(id, name, score)
    }
  }

}