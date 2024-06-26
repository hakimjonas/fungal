import core.models.HomePage
import web.Routing
import zio.*
import zio.http.*
import zio.http.HttpApp.*

import scala.collection.concurrent.TrieMap
import scala.language.postfixOps

object MainApp extends ZIOAppDefault {
  val run: ZIO[Any & ZIOAppArgs & Scope, Throwable, Unit] = for {
    _ <- Routing.initRoutes() // Initialize dynamic routes
    _ <- Server.serve(Routing.app).provide(Server.default).forever
  } yield ()
}
