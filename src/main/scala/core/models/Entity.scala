package core.models

import zio.schema.Patch.ZonedDateTime

abstract class Entity {
  val id: String
  val createdAt: Option[ZonedDateTime]
  val updatedAt: Option[ZonedDateTime]

  def update(): Entity

  def delete(): Unit
}
