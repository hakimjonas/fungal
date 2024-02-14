package core.modules.frontend

import zio.stream._

/**
 * Represents the main menu module of a web page.
 *
 * @param menuItems
 *   List of menu items for the main menu.
 */
final case class MainMenu(menuItems: List[String])

object MainMenu {
  def render(menuItems: List[String]): String = {
    val itemsHtml = menuItems.map(item => s"<li><a href='#$item'>$item</a></li>").mkString
    s"<nav><ul>$itemsHtml</ul></nav>"
  }
}
