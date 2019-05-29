package StringSearcher

/**
  * Hello world!
  *
  */
object App {

  def main(args: Array[String]): Unit = {

    if (!args.isEmpty) {
      val inputDir = ETL.getDirectoryFile(args(0))
      if (inputDir != null) ConsoleRunner(inputDir).runConsoleInterface()
    } else println("No directory specified, terminating")

  }


}
