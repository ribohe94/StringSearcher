package StringSearcher

import scala.io.StdIn
import util.control.Breaks._

object ConsoleRunner {

  def runConsoleInterface(dir: String): Unit = {

    while(true) {
      print("search> ")
      StdIn.readLine() match {
        case ":quit" => return
      }
    }

  }

}
