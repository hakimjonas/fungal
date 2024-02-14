import web.Routing
import web.Routing.app
import zio.*
import zio.http.*

import scala.language.postfixOps

object MainApp extends ZIOAppDefault {
  val run: ZIO[Any with ZIOAppArgs with Scope, Throwable, Unit] = for {
    _ <- Routing.initRoutes() // Initialize dynamic routes
    _ <- Server.serve(Routing.app).provide(Server.default).forever
  } yield ()
}
