package StringSearcher

object StringSearcher {

  /**
    *
    * @param words Vector of words to be searched
    * @param indexedFiles Indexed Files where the search will be performed
    * @return A vector of tuples where _1 is the name of the file and _2 its rank as a double with range of 0.0 - 100.0
    */
  def getFilesRanking(words: Vector[String], indexedFiles: Map[String, Map[String, Int]]): Vector[(String, Double)] = {
    val fileRanking = for (file <- indexedFiles) yield (file._1, getFileRanking(words, file._2))
    fileRanking.toVector.filter(_._2 > 0.0).sortWith(_._2 > _._2).take(10)
  }

  private def getFileRanking(words: Vector[String], wordsMap: Map[String, Int]): Double = {
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
