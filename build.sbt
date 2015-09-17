val scalatest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

val scalamock = "org.scalamock" % "scalamock-scalatest-support_2.11" % "3.2.2"

lazy val commonSettings = Seq(
  organization := "uk.co.exware",
  version := "0.1.0",
  scalaVersion := "2.11.5"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "shopping-cart-test",
    libraryDependencies ++= Seq(scalatest,scalamock)
  )
