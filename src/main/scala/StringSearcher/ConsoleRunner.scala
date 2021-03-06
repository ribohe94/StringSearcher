package StringSearcher

import java.io.File

import scala.io.StdIn

case class ConsoleRunner(inputDir: File) {

  private val indexedFiles = ET.indexedFilesToSet(inputDir)

  /**
    * Starts the console application
    */
  def runConsoleInterface(): Unit = {
    while (true) {
      print("search> ")
      StdIn.readLine() match {
        case ":quit" => return
        case words: String => displayRanking(StringSearcher.getFilesRanking(words.split(" ").toVector, indexedFiles))
      }
    }
  }

  /**
    * Prints out the ranking result for each file
    *
    * @param rankedFiles Vector of ranked files
    */
  private def displayRanking(rankedFiles: Vector[(String, Double)]): Unit = {
    if (rankedFiles.isEmpty) println("No matches found") else {
      rankedFiles.foreach(tuple => println(f"${tuple._1}: ${tuple._2}%1.2f%%"))
    }
  }

}
