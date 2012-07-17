import sbt._

/**
 * Declaration of dependencies, library versions etc.
 */
object Dependencies {
  // Common Versions for libraries
  val liftVersion = "2.4"

  // Functions to create dependencies
  val liftDep = (componentId: String, scope: String ) => {
    val id = "%s_2.9.1".format(componentId)
    "net.liftweb" % id % liftVersion % scope
  }
	
  // Actual dependencies
  // liftweb
  val liftUtil = liftDep("lift-util", "compile")
  val liftCommon = liftDep("lift-common", "compile")
  val liftWebkit = liftDep("lift-webkit", "compile")
  val liftMongoRecord = liftDep("lift-mongodb-record", "compile")

  // Rogue - used for Mongo DB Queries
  val rogue = "com.foursquare" % "rogue_2.9.1" % "1.1.8" intransitive()

  // Joda time
  val jodaTime = "joda-time" % "joda-time" % "2.0"
  val jodaConvert = "org.joda" % "joda-convert" % "1.2"

  val logback = "ch.qos.logback" % "logback-classic" % "1.0.0"

  val scalatest = "org.scalatest" %% "scalatest" % "1.8" % "test"
  val scalatestInCompile = "org.scalatest" %% "scalatest" % "1.8"

  val groovy = "org.codehaus.groovy" % "groovy" % "2.0.0"

  // Dependency groups
  val testDeps = Seq(scalatest)
  val liftDeps = Seq(liftUtil, liftCommon, liftWebkit, liftMongoRecord, rogue)
  val loggingDeps = Seq(logback, groovy, liftCommon)
  val jodaDeps = Seq(jodaTime, jodaConvert)
}

