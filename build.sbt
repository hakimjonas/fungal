name := "fungal"

version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

javacOptions ++= Seq("-source", "21", "-target", "21")

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.18",
  "dev.zio" %% "zio-http" % "3.0.0-RC2",
  "org.scalactic" %% "scalactic" % "3.2.17",
  "org.scalatest" %% "scalatest" % "3.2.17" % "test",
  "io.circe" %% "circe-generic" % "0.14.5",
  // Syncronous JDBC Modules
  "io.getquill" %% "quill-jdbc" % "4.7.3",
  // Or ZIO Modules
  "io.getquill" %% "quill-jdbc-zio" % "4.7.3",
  // Or Cassandra
  "io.getquill" %% "quill-cassandra" % "4.7.3",
  // Or Cassandra + ZIO
  "io.getquill" %% "quill-cassandra-zio" % "4.7.3",
  // Add for Caliban Integration
  "io.getquill" %% "quill-caliban" % "4.7.3",
  "org.typelevel" %% "log4cats-core" % "2.6.0",
  "org.typelevel" %% "log4cats-slf4j" % "2.6.0"
)

Compile / mainClass := Some("App")
