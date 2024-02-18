package web

import zio.http.{Middleware, Path}

import java.io.File

object MiddleWares {

  // Path where static files are located
  private val staticContentDir = new File("src/main/scala/web/frontend/templates/chanterelle")

  // Middleware for serving static files
  val staticFileMiddleware: Middleware[Any] = Middleware.serveDirectory(Path("/static"), staticContentDir)

}
