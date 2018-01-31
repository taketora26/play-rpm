name := """play-rpm"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(
    PlayScala,
    RpmPlugin,
    UpstartPlugin,
    JavaServerAppPackaging
  )

scalaVersion := "2.12.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

maintainer in Linux := "hoge <hoge@example.com>"

packageSummary in Linux := "My custom package summary"
packageDescription := "My longer package description"

rpmBrpJavaRepackJars := true
rpmRelease := "1"
rpmVendor := "example.com"
rpmUrl := Some("http://hogehoge.com/example/server")
rpmLicense := Some("Apache v2")

serviceAutostart := false
daemonUser := "play-rpm"
daemonGroup := "play-rpm"

javaOptions in Universal ++= Seq(
  "-Dplay.server.pidfile.path=/dev/null",
  "-Dfile.encoding=utf8"
)
