import StringSearcher.StringSearcher
import junit.framework.TestCase
import org.junit.Test

class StringSearcherTest extends TestCase {

  @Test def testNoMatches {
    // Empty vector is returned when there are no matches
    val words = "These words do not exist".split(" ").toVector
    val indexedFiles = Map("file1.txt" -> Set("lorem", "ipsum"))
    assert(StringSearcher.getFilesRanking(words, indexedFiles) == Vector.empty)
  }

  @Test def testEmptyInput {
    // Empty input should return empty vector
    val words = Vector.empty
    val indexedFiles = Map("file1.txt" -> Set("lorem", "ipsum"))
    assert(StringSearcher.getFilesRanking(words, indexedFiles) == Vector.empty)
  }

  @Test def testNoMoreThanTenMatches {
    // output limit is 10
    val words = "lorem ipsum".split(" ").toVector
    val indexedFiles = (1 to 15).map(file => s"file$file.txt" -> Set("lorem", "ipsum")).toMap
    assert(StringSearcher.getFilesRanking(words, indexedFiles).size == 10)
  }

  @Test def testListIsInOrder {
    // output limit is 10
    val words = "lorem ipsum sit".split(" ").toVector
    val indexedFiles = Map(
      "file1.txt"-> Set("lorem", "ipsum"),
      "file2.txt"-> Set("lorem"),
      "file3.txt"-> Set("lorem", "sit")
    )
    assert(StringSearcher.getFilesRanking(words, indexedFiles).size == 10)
  }

}
