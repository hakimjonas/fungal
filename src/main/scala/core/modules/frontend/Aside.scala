package core.modules.frontend

import zio.stream._

/**
 * Represents the aside module of a web page.
 *
 * @param content
 *   Content for the aside module.
 */
final case class Aside(content: String) {}

object Aside {
  def render(content: String): String = s"<aside>$content</aside>"
}
