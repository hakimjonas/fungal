package web

import zio.http.template._
import zio._

class HtmlService {
  def renderPage(titleText: String, messageText: String): Html = {
    val content: Html =
      div(
        h1(titleText),
        p(messageText),
      )

    html(
      head(titleText),
      body(content),
    )
  }
}

object HtmlService {
  val live: ULayer[HtmlService] = ZLayer.succeed(new HtmlService())
}
