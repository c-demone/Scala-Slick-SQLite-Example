name := "sqlite-connector"

version := "3.3"

scalaVersion := "2.12.8"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-feature",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-Ywarn-dead-code",
  "-Xfatal-warnings"
)

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick"           % "3.2.0",
  "com.h2database"      % "h2"              % "1.4.197",
  "org.slf4j"           % "slf4j-nop"       % "1.6.4",
  "org.xerial"          % "sqlite-jdbc"     % "3.7.2",
  "com.typesafe.slick" %% "slick-hikaricp"  % "3.2.2"
)

initialCommands in console := """
  |import slick.jdbc.H2Profile.api._
  |import Example._
  |import scala.concurrent.duration._
  |import scala.concurrent.Await
  |import scala.concurrent.ExecutionContext.Implicits.global
  |val db = Database.forConfig("chapter01")
  |def exec[T](program: DBIO[T]): T = Await.result(db.run(program), 2 seconds)
  |exec(messages.schema.create)
  |exec(messages ++= freshTestData)
""".trim.stripMargin
