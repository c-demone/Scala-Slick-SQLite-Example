name := "sqlite-connector"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "c3p0" %"c3p0" % "0.9.1.2"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.11"
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.1.1",
  "com.zaxxer" % "HikariCP" % "2.4.1",
  "org.slf4j" %"slf4j-nop" %"1.6.4"
)
