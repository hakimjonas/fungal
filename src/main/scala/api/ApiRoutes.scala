package api

import zhttp.http._
import zio._

object ApiRoutes {
  val routes: HttpApp[Any, Nothing] = Http.collect {
    case Method.GET -> !! / "hello" / name =>
      Response.text(s"Hello, $name.")
  }
}
