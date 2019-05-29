import StringSearcher.ETL
import junit.framework.TestCase
import org.junit.Test

class ETLTest extends TestCase {

  @Test def testNullWhenInvalidPath {
    assert(ETL.getDirectoryFile("does/not/exist") == null)
  }

}
