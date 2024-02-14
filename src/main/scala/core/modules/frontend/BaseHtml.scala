//package core.modules.frontend
//
//import scalatags.Text.all._
//
///**
// * Represents a base HTML module with common utilities.
// */
//trait BaseHtml {
//
//  /**
//   * Renders the header content.
//   *
//   * @param content
//   *   The content of the header.
//   * @return
//   *   HTML representation of the header.
//   */
//  protected def renderHeader(content: String): Frag = {
//    header(content)
//  }
//
//  /**
//   * Concatenates two HTML fragments.
//   *
//   * @param frag1
//   *   The first HTML fragment.
//   * @param frag2
//   *   The second HTML fragment.
//   * @return
//   *   The concatenated HTML.
//   */
//  protected def concatFragments(frag1: Frag, frag2: Frag): Frag = {
//    frag1 :+ frag2
//  }
//}
