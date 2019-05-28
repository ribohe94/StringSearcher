package StringSearcher

import java.io.File

import scala.collection.mutable
import scala.io.Source

/**
 * Hello world!
 *
 */
object App extends App {


  ConsoleRunner.runConsoleInterface("")

  val input = new File("")
  input.isDirectory


  val file = Source.fromFile("data/input.txt", "UTF-8").getLines().toVector.reduce(_ ++ _).split(" ")
  val size = file.size

  val wordMap = file.groupBy(x => x).mapValues(_.length)


  println(size)
  println(wordMap("est"))


  println(wordMap)



}
