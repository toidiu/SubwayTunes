name := "subwaytunes"

version := "1.0"

lazy val `subwaytunes` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

//libraryDependencies ++= Seq(javaJdbc, javaEbean, cache, javaWs)

libraryDependencies ++= Seq()

libraryDependencies ++= Seq(javaCore,
  cache,
  javaWs,
  javaJdbc,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "4.2.7.Final")

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")
