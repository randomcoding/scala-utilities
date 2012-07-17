scala-utilities
===============

Useful utilities for Scala (especially lift/MongoDB)

This is split into two sections:

## Core
This provides utilities for core functionality, such as data time usage.

## Lift
These utilities are currently aimed at the use of Lift and/or MongoDB.

## Usage
You will require [sbt](https://github.com/harrah/xsbt).

Clone this project and then enter `sbt +publish-local` (this will run the cross build for Scala 2.9.1 and 2.9.2)

Add a dependency to your other project's `build.sbt` file:

```
libraryDependencies ++= Seq(
  "uk.co.randomcoding" %% "scala-utilities-core" % "0.1.0-SNAPSHOT",
  "uk.co.randomcoding" %% "scala-utilities-lift" % "0.1.0-SNAPSHOT"
)
```

## License
This project is licensed under the [GNU AGPL 3.0](http://www.gnu.org/licenses/agpl-3.0.html)

## Contributions
Contributions are welcome. :)

