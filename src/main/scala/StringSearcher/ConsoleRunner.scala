package StringSearcher

import java.io.File

import scala.io.StdIn

case class ConsoleRunner(inputDir: File) {

  private val indexedFiles = ETL.indexedFilesToMap(inputDir)

  def runConsoleInterface(): Unit = {

    while(true) {
      print("search> ")
      StdIn.readLine() match {
        case ":quit" => return
        case words: String => displayRanking(StringSearcher.getWordsRank(inputParser(words), indexedFiles))
      }
    }

  }

  private def inputParser(input: String): Vector[String] = {
    input.split(" ").toVector
  }

  private def displayRanking(ranking: Vector[(String, Double)]) = {
    ranking.foreach(tuple => println(s"${tuple._1}: ${tuple._2}%"))
  }

}
