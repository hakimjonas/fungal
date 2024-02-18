package core.models

import zio.http.template.Html.fromDomElement
import zio.http.template.{ Dom, Elements, Html }

/**
 * A page is an abstract class that represents a web page. It contains a title and a body content.
 */
abstract class Page extends Elements {
  def pageTitle: String

  protected def headContent: Seq[Dom] = Seq.empty

  def bodyContent: Seq[Dom]

  private def renderHead: Dom = {
    val titleElement = Seq(title(Dom.text(pageTitle)))
    val fullHeadContent = titleElement ++ headContent
    head(fullHeadContent)
  }
  private def renderBody: Dom =
    body(bodyContent)

  def render: Html =
    Html.fromDomElement(html(renderHead, renderBody))
}
