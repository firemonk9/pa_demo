import _root_.sbtassembly.AssemblyPlugin.autoImport._
import _root_.sbtassembly.PathList

name := "paDemo"

version := "1.0"

scalaVersion := "2.10.6"

val SPARK_VERSION = "1.6.0"

val SPRAY_VERSION = "1.3.3"



libraryDependencies += "org.apache.spark" %% "spark-core" % SPARK_VERSION //% "provided"

libraryDependencies += "org.apache.spark" %% "spark-sql" % SPARK_VERSION //% "provided"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.2.4" % "test"

libraryDependencies += "fastutil" % "fastutil" % "5.0.9"


mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) => {
  case PathList("javax", "pom.properties", xs@_*) => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".properties" => MergeStrategy.concat
  case PathList(ps@_*) if ps.last endsWith ".class" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".RSA" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith "mailcap" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".xml" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".dtd" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".default" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".xsd" => MergeStrategy.first
  case "pom.properties" => MergeStrategy.first
  case "unwanted.txt" => MergeStrategy.discard
  case x => old(x)
}
}


excludedJars in assembly := {
  val cp = (fullClasspath in assembly).value
  cp filter {_.data.getName == "myalgo_2.10-1.0.jar"}
}

parallelExecution in Test := false

test in assembly := {}

assemblyJarName in assembly := "pa_demo.jar"   //SPARK_COMMENT_LINE
