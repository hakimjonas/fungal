import web.{ MiddleWares, Routing }
import zio.*
import zio.http.*

import scala.language.postfixOps

object MainApp extends ZIOAppDefault {

  private val app = Routing.app
  private val serverTime = MiddleWares.serverTime
  private val middlewares = MiddleWares.middlewares

  val run: ZIO[Any, Throwable, Nothing] =
    Server.serve(app @@ middlewares).provide(Server.default)
}
