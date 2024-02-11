//package core.data
//
//import core.events.UserEvents
//import zio.schema.Patch.ZonedDateTime
//
//case class UserData(
//    id: String,
//    name: String,
//    email: String,
//    username: String,
//    password: String,
//    userEvents: List[UserEvents]
//) {
//  val registeredAt: ZonedDateTime =
//    userEvents.find(_.eventType == "UserRegistered").map(_.createdAt).orNull
//}
