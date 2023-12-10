import api.ApiRoutes
import zhttp.http._
import zhttp.service.Server
import zio._

object FungalServer extends ZIOAppDefault {
  val app: HttpApp[Any, Nothing] = ApiRoutes.routes

  override def run: URIO[Any, ExitCode] = {
    Server.start(8080, app).exitCode
  }
}
