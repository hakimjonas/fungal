package core.modules.frontend

import zio.stream._

/**
 * Represents the footer module of a web page.
 *
 * @param content
 *   Properties specific to the footer module.
 */
final case class Footer(content: String)

object Footer {
  def render(content: String): String = s"<footer>$content</footer>"
}
