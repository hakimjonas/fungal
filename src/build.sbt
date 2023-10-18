name := "fungal"

version := "0.1.0-SNAPSHOT"

scalaVersion := "3.0.2"  // or the Scala version you are using

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-dsl" % "0.23.23",
  "org.http4s" %% "http4s-blaze-server" % "0.23.23",
  "org.http4s" %% "http4s-blaze-client" % "0.23.23",
  "io.getquill" %% "quill-core" % "4.6.0.1",
  "io.getquill" %% "quill-jdbc" % "4.6.0.1"  // Or choose the appropriate Quill module for your database
)
