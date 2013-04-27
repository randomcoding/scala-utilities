scala-utilities
===============

Useful utilities for Scala (especially lift/MongoDB)

This is split into two sections:

## Core
This provides utilities for core functionality, such as data time usage.

## Lift
These utilities are currently aimed at the use of Lift and/or MongoDB.

## Usage
You will require [sbt](https://github.com/sbt/sbt).

The build is for Scala 2.10.x

Clone this project and then enter `sbt publish-local`

Add a dependency to your other project's `build.sbt` file:

```
libraryDependencies ++= Seq(
  "uk.co.randomcoding" %% "scala-utilities-core" % "0.2.0",
  "uk.co.randomcoding" %% "scala-utilities-lift" % "0.2.0"
)
```

## License
This project is licensed under the [GNU AGPL 3.0](http://www.gnu.org/licenses/agpl-3.0.html)

## Contributions
Contributions are welcome. :)

