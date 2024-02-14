package core.models

import scalatags.Text.all._
import scalatags.Text.tags2.title

/**
 * A class to represent a basic html page
 */
final class Page(val title: String, val content: Frag) {}

object Page {
  def render(page: Page): String = {
    "<!DOCTYPE html>" +
      html(
        head(
          meta(charset := "UTF-8"),
          meta(name := "viewport", content := "width=device-width, initial-scale=1.0"),
          title(page.title),
        ),
        body(
          page.content,
        ),
      ).render
  }

}
