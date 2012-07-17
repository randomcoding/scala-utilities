import sbt._
import Keys._

import com.typesafe.sbteclipse.core.EclipsePlugin._

object ProjectBuild extends Build {
  import BuildSettings._
  import ShellPrompt._
  import Dependencies._

  lazy val root = Project("root", 
    file("."),
    settings = buildSettings ++ Unidoc.settings ++ Seq (
      scaladocOptions := Seq(),
      // Disable publish and publish-local for empty root project
      publish := {},
      publishLocal := {}
    )
  ) aggregate(coreProject, liftProject)

  lazy val coreProject: Project = Project("core",
    file("scala-utilities-core"),
      delegates = root :: Nil,
      settings = buildSettings ++ Seq(libraryDependencies ++= coreProjectDeps,
      name := "scala-utilities-core"
    )
  )

  lazy val liftProject: Project = Project("lift", 
    file("scala-utilities-lift"),
    settings = buildSettings ++ Seq(libraryDependencies ++= liftProjectDeps,
      name := "scala-utilities-lift"
    )
  )

  val commonDeps = testDeps ++ jodaDeps
  val coreProjectDeps = commonDeps
  val liftProjectDeps = jodaDeps ++ liftDeps ++ Seq(scalatestInCompile)
}

