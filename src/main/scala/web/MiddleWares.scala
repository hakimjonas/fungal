package web

import zio.*
import zio.http.*

import java.util.concurrent.TimeUnit
import scala.language.postfixOps
object MiddleWares {

  val serverTime: HandlerAspect[Any, Unit] = Middleware.patchZIO(_ =>
    for {
      currentMilliseconds <- Clock.currentTime(TimeUnit.MILLISECONDS)
      header = Response.Patch.addHeader("X-Time", currentMilliseconds.toString)
    } yield header,
  )
  val middlewares: Middleware[Any] =
    // print debug info about request and response
    Middleware.debug ++
      // close connection if request takes more than 3 seconds
      Middleware.timeout(3 seconds) ++
      // add static header
      Middleware.addHeader("X-Environment", "Dev") ++
      // add dynamic header
      serverTime
}
