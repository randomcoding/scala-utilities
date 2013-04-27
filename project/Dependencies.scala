import sbt._

/**
 * Declaration of dependencies, library versions etc.
 */
object Dependencies {
  // Common Versions for libraries
  val liftVersion = "2.5-RC5"

  // Functions to create dependencies
  val liftDep = (componentId: String, scope: String ) => {
    "net.liftweb" %% componentId % liftVersion % scope
  }
	
  // Actual dependencies
  // liftweb
  val liftUtil = liftDep("lift-util", "compile")
  val liftCommon = liftDep("lift-common", "compile")
  val liftWebkit = liftDep("lift-webkit", "compile")
  val liftMongoRecord = liftDep("lift-mongodb-record", "compile")

  // Rogue - used for Mongo DB Queries
//  val rogue = Seq("lift", "field", "core").map(component => 
//    "com.foursquare" %% "rogue-%s".format(component) % "2.0.0-RC2" intransitive())

  // Joda time
  val jodaTime = "joda-time" % "joda-time" % "2.0"
  val jodaConvert = "org.joda" % "joda-convert" % "1.2"

  val logback = "ch.qos.logback" % "logback-classic" % "1.0.0"

  val scalatestVersion = "2.0.M5b"
  val scalatest = "org.scalatest" %% "scalatest" % scalatestVersion  % "test"
  val scalatestInCompile = "org.scalatest" %% "scalatest" % scalatestVersion

  val groovy = "org.codehaus.groovy" % "groovy" % "2.0.0"

  // Dependency groups
  val testDeps = Seq(scalatest)
  val liftDeps = /*rogue ++*/ Seq(liftUtil, liftCommon, liftWebkit, liftMongoRecord)
  val loggingDeps = Seq(logback, groovy, liftCommon)
  val jodaDeps = Seq(jodaTime, jodaConvert)
}

