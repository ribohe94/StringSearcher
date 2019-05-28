package StringSearcher

import java.io.File

import scala.io.Source

object ETL {

  /**
    *
    * @param inputDir Directory to index. All files (Recursive) under this directory will be evaluated when performing a search
    * @return This returns a dictionary of each file with the following structure: "FileName.txt" -> ("word" -> count)
    */
  def indexedFilesToDictionary(inputDir: File): Map[String, Map[String, Int]] = {
    val listOfFiles = getListOfFiles(inputDir)
    listOfFiles.map(file => file.getName -> fileToDictionary(file)).toMap
  }

  def getDirectoryPath(inputDir: String): File = {
    val file = new File(inputDir)
    if (file.exists() && file.isDirectory()) file else null
  }

  private def fileToDictionary(file: File): Map[String, Int] = {
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
