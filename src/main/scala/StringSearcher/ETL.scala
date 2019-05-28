package StringSearcher

import java.io.File

import scala.io.Source

class ETL {



  private def getFileAsString(file: File): String = Source.fromFile(file.getPath).getLines().mkString

  private def getListOfFiles(directory: File): List[File] = {
    if (directory.exists() && directory.isDirectory) {
      directory.listFiles().filter(_.isFile).toList
    } else List[File]()
  }

}
