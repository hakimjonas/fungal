//package core.data
//
//// Base class
//case class UserEventData(
//    name: String,
//    email: String,
//    username: Option[String],
//    password: Option[String]
//)
//
//// Composition instead of inheritance
//case class UserRegisteredData(
//    eventData: UserEventData
//)
//
//object UserRegisteredData {
//  def apply(
//      name: String,
//      email: String,
//      username: String,
//      password: String
//  ): UserRegisteredData =
//    new UserRegisteredData(
//      UserEventData(name, email, Some(username), Some(password))
//    )
//}
//
//case class UserUpdatedData(
//    eventData: UserEventData
//)
//
//object UserUpdatedData {
//  def apply(
//      name: String,
//      email: String,
//      username: Option[String],
//      password: Option[String]
//  ): UserUpdatedData =
//    new UserUpdatedData(UserEventData(name, email, username, password))
//}
//
//// For UserDeletedData, you need to decide how to handle the missing parameters
//// One approach is to use Option for all fields in UserEventData
//case class UserDeletedData(
//    eventData: UserEventData
//)
//
//object UserDeletedData {
//  def apply(): UserDeletedData =
//    new UserDeletedData(
//      UserEventData("", "", None, None)
//    ) // Decide how to handle the empty or missing values
//}
