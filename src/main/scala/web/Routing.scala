package web
import zio.*
import zio.http.*

import scala.language.postfixOps

class Routing {}

object Routing {

  val app: HttpApp[Any] = Routes(
    Method.GET / "text" -> handler(ZIO.succeed(Response.text("Hello World"))),
    Method.GET / "long-running" -> handler(ZIO.succeed(Response.text("Hello World!")).delay(5.seconds)),
    // Static and less interactive routes
    Method.GET / "about" -> handler(ZIO.succeed(Response.text("About content"))),
    Method.GET / "help" -> handler(ZIO.succeed(Response.text("Help content"))),
    Method.GET / "version" -> handler(ZIO.succeed(Response.text("v1.0.0"))),
    Method.GET / "status" -> handler(ZIO.succeed(Response.text("OK"))),
    Method.GET / "posts" -> handler(ZIO.succeed(Response.text("Sample Post 1\nSample Post 2"))),
    Method.GET / "categories" -> handler(ZIO.succeed(Response.text("Category1, Category2"))),
    Method.GET / "config" -> handler(ZIO.succeed(Response.text("Config settings"))),
  ).toHttpApp
}
