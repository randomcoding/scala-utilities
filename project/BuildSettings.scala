import sbt._
import Keys._

import com.typesafe.sbteclipse.core.EclipsePlugin._

/**
 * Common build settings for projects.
 */
object BuildSettings {

  val buildOrganization = "uk.co.randomcoding"
  val buildVersion = "0.2.0"
  val buildScalaVersion = "2.10.1"

  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := buildOrganization,
    version := buildVersion,
    scalaVersion := buildScalaVersion,
    parallelExecution in Test := false,
    shellPrompt := ShellPrompt.buildShellPrompt,
    scalacOptions := Seq("-deprecation", "-unchecked"),
    EclipseKeys.createSrc := EclipseCreateSrc.Default,
    unmanagedSourceDirectories in Compile <<= (scalaSource in Compile)(Seq(_)),
    unmanagedSourceDirectories in Test <<= (scalaSource in Test)(Seq(_))
  )

}
