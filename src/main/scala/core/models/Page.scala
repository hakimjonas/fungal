//package core.models
//
//import zio.schema.Patch.ZonedDateTime
//import core.repositories.UserRepository
//final case class Page(
//    override val id: String,
//    title: String,
//    content: String,
//    slug: String,
//    published: Boolean
//) extends Entity {
//  override def update(): Page = {
//    // Update the entity's properties
//    val updatedContent = updateContent(content)
//    val updatedTitle = updateTitle(title)
//
//    // Create a copy of the current entity with updated properties
//    copy(
//      content = updatedContent,
//      title = updatedTitle,
//      updatedAt = ZonedDateTime.now()
//    )
//  }
//
//  override def delete(): Unit = {
//    // Remove the user from the database
//    UserRepository.delete(id)
//
//    // Notify any listeners about the deleted user
//    fireUserDeletedEvent(id)
//  }
//
//}
