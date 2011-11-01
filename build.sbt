name := "lift-sbt-template"

version := "1.0"

scalaVersion := "2.9.1"

resolvers ++= Seq(
  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
)

//Test
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.8" % "test",
  "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.4.v20111024" % "test"
)

//Main
libraryDependencies ++= {
  val liftVersion = "2.4-M4"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion,
    "net.liftweb" %% "lift-mapper" % liftVersion,
    "net.liftweb" %% "lift-wizard" % liftVersion
  )
}

