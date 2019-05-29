package StringSearcher

import java.io.File

import scala.io.Source

object ETL {

  /**
    *
    * @param inputDir Directory to index. All files (Recursive) under this directory will be evaluated when performing a search
    * @return This returns a dictionary of each file with the following structure: "FileName.txt" -> Set("word")
    */
  def indexedFilesToSet(inputDir: File): Map[String, Set[String]] = {
    val listOfFiles = getListOfFiles(inputDir)
    listOfFiles.map(file => file.getName -> fileToSetOfWords(file)).toMap
  }

  def getDirectoryFile(inputDir: String): File = {
    val file = new File(inputDir)
    if (file.exists && file.isDirectory) file else null
  }

  private def fileToSetOfWords(file: File): Set[String] = {
    val fileLines = Source.fromFile(file.getPath)
    val wordSet = fileLines.getLines().toVector.reduce(_ ++ _).split(" ").toSet
    fileLines.close()
    wordSet
  }

  private def getListOfFiles(directory: File): List[File] = {
    if (directory.exists() && directory.isDirectory) {
      directory.listFiles().filter(_.isFile).toList
    } else List[File]()
  }

}
