name := "fungal"

version := "0.2.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

javacOptions ++= Seq("-source", "21", "-target", "21")

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.19",
  "dev.zio" %% "zio-http" % "3.0.0-RC4",
  "dev.zio" %% "zio-json" % "0.6.2",
  "dev.zio" %% "zio-logging" % "2.1.12",
  "org.scalactic" %% "scalactic" % "3.2.17",
  "org.scalatest" %% "scalatest" % "3.2.17" % "test",
  "io.circe" %% "circe-generic" % "0.14.6",
  "dev.zio" %% "zio-nio" % "2.0.2",
  "dev.zio" %% "zio-redis" % "0.2.0",
)

Compile / mainClass := Some("MainApp")
