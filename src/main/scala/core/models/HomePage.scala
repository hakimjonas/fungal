package core.models

import zio.http.template.{ Attributes, Dom }

class HomePage extends Page with Attributes {
  override def pageTitle: String = "Home"
  override def headContent: Seq[Dom] = Seq(
    link(
      relAttr := "stylesheet",
      hrefAttr := "/static/style.css", // This path should match the path exposed by the middleware
    ),
  )

  override def bodyContent: Seq[Dom] = Seq(
    h1(Dom.text("Welcome to the Home Page!")),
    p(Dom.text("This is the home page content.")),
  )
}
