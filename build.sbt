name := "tysonjh"

scalaVersion := "2.9.1"

seq(webSettings :_*)

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies ++= {
  val liftVersion = "2.4"
  Seq(
    "net.liftweb" %% "lift-webkit"  % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-ldap" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-record" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-squeryl-record" % liftVersion % "compile->default"
  )
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "container,test->default",
  "org.slf4j" % "slf4j-simple" % "1.6.4",
  "org.hectorclient" % "hector-core" % "1.1-0"
)
