import StringSearcher.ET
import junit.framework.TestCase
import org.junit.Test

class ETLTest extends TestCase {

  @Test def testNullWhenInvalidPath {
    assert(ET.getDirectoryFile("does/not/exist") == null)
  }

}
