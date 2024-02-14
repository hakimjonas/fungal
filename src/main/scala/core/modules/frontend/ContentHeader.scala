package core.modules.frontend

import zio.stream._

/**
 * Represents the header module of a web page.
 *
 * @param content
 *   The content of the header.
 */
final case class ContentHeader(content: String)

object ContentHeader {
  def render(content: String): String = s"<header>$content</header>"
}
