package core.modules.frontend

import zio.stream._

/**
 * Represents the main content module of a web page.
 *
 * @param content
 *   Content for the main section of the page.
 */
final case class MainContent(content: String)

object MainContent {
  def render(content: String): String = s"<main>$content</main>"
}
