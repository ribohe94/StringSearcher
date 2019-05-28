package StringSearcher

object StringSearcher {

  def getWordsRank(words: Vector[String], indexedFiles: Map[String, Map[String, Int]]): Vector[(String, Double)] = {
    val fileRanking = for (file <- indexedFiles) yield (file._1, evaluateFile(words, file._2))
    fileRanking.toVector.sortWith(_._2 > _._2).take(10)
  }

  private def evaluateFile(words: Vector[String], wordsMap: Map[String, Int]): Double = {
    val count = for (word <- words.distinct) yield {
      try {
        wordsMap(word)
      } catch {
        case e: NoSuchElementException => 0
      }
    }
    val wordsSize = wordsMap.values.sum

    (count.sum.doubleValue() / wordsSize.doubleValue()) * 100
  }

}
