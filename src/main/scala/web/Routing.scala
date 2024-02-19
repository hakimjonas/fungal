package web
import core.models.HomePage
import zio.*
import zio.http.*
import zio.http.HttpApp.*

import scala.collection.concurrent.TrieMap

class Routing(var routes: TrieMap[String, HttpApp[Any]]) {

  private def addRoute(path: String, handler: HttpApp[Any]): UIO[Boolean] =
    ZIO.succeed {
      routes.putIfAbsent(path, handler).isEmpty
    }

  def removeRoute(path: String): UIO[Boolean] =
    ZIO.succeed(routes.remove(path).isDefined)

  def modifyRoute(path: String, newHandler: HttpApp[Any]): UIO[Boolean] =
    addRoute(path, newHandler)

  def getRoute(path: String): UIO[Option[HttpApp[Any]]] =
    ZIO.succeed(routes.get(path))

  def toHttpApp: HttpApp[Any] = {
    HttpApp.collectZIO { case req =>
      val path = req.url.path.toString()
      routes.get(path) match {
        case Some(handler) => handler(req)
        case None =>
          ZIO.succeed(Response.text(s"Route not found: $path"))
      }
    }
  }
}

object Routing {
  private val initialRoutes: TrieMap[String, HttpApp[Any]] = TrieMap.empty
  private val routingInstance = new Routing(initialRoutes)

  // Usage in the route
  private val homePage = new HomePage() // Initialize with example routes

  def initRoutes(): ZIO[Any, Nothing, Boolean] = for {

    _ <- routingInstance.addRoute(
      path = "/text",
      handler = HttpApp.collectZIO { case _ => ZIO.succeed(Response.text("Hello, World!")) },
    )
    _ <- routingInstance.addRoute(
      path = "/json",
      handler = HttpApp.collectZIO { case _ => ZIO.succeed(Response.json("""{"message": "Hello JSON"}""")) },
    )
    _ <- routingInstance.addRoute(
      "/home",
      HttpApp.collectZIO { case _ => ZIO.succeed(Response.html(homePage.render)) },
    )
    _ <- routingInstance.addRoute(
      "/",
      HttpApp.collectZIO { case _ => ZIO.succeed(Response.html(homePage.render)) },
    )
  } yield true

  // The main HttpApp now references the dynamic routes
  val app: HttpApp[Any] = routingInstance.toHttpApp @@ MiddleWares.staticFileMiddleware
}
