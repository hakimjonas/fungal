package web

import web.Routing
import zio.*
import zio.Clock.*
import zio.Duration.*
import zio.http.*
import zio.http.Response.*
import zio.stream.*
trait Controller {
  // Method to handle requests
  def handleRequest: ZIO[Any, Throwable, Response]
}

// Define a concrete controller for the welcome page
class WelcomeController extends Controller {
  override def handleRequest: ZIO[Any, Throwable, Response] =
    ZIO.succeed(Response.text("Welcome to our application!"))
}

// Define a concrete controller for the user page
class UserController extends Controller {
  override def handleRequest: ZIO[Any, Throwable, Response] =
    ZIO.succeed(Response.text("User controller logic goes here"))
}

class LandingPageController(landingPageHtml: String) extends Controller {
  override def handleRequest: ZIO[Any, Throwable, Response] =
    ZIO.succeed(Response.html(landingPageHtml))
}
