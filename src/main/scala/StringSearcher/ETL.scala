package StringSearcher

import java.io.File

import scala.io.Source

object ETL {

  def indexedFilesToMap(inputDir: File): Map[String, Map[String, Int]] = {
    val listOfFiles = getListOfFiles(inputDir)
    listOfFiles.map(file => file.getName -> fileToWordMap(file)).toMap
  }

  def fileToWordMap(file: File): Map[String, Int] = {
    val fileLines = Source.fromFile(file.getPath).getLines()
    val wordList = fileLines.toVector.reduce(_ ++ _).split(" ")
    wordList.groupBy(x => x).mapValues(_.length)
  }

  private def getListOfFiles(directory: File): List[File] = {
    if (directory.exists() && directory.isDirectory) {
      directory.listFiles().filter(_.isFile).toList
    } else List[File]()
  }

}
