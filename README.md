# StringSearcher

## How o run:

#### Have Maven installed
~~~
$ mvn -version
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T12:41:47-06:00)
Maven home: /usr/local/Cellar/maven/3.6.0/libexec
Java version: 1.8.0_201, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/jdk1.8.0_201.jdk/Contents/Home/jre
Default locale: en_CR, platform encoding: UTF-8
OS name: "mac os x", version: "10.14.3", arch: "x86_64", family: "mac"
~~~
#### Run using the following command
`$ mvn -q package exec:java -Dexec.mainClass=StringSearcher.App -Dexec.args="inputDir/"`

Replace `"inputDir/"` with the desired directory.

#### Example

~~~
$ mvn -q package exec:java -Dexec.mainClass=StringSearcher.App -Dexec.args="data"

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running StringSearcherTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.202 sec
Running ETLTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec

Results :

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

search> lorem
input.txt: 100.00%
search> lorem ipsum
input.txt: 100.00%
search> lorem ipsum wordOne WordTwo
input.txt: 50.00%
search>
~~~

## Assumptions
* _What constitutes a word?_ Any String segment separated by a space will be considered as a word.
* _What constitutes two words being equal (and matching)?_ True if both words are identical (including cases). `Set.contains(word)` is used to determine equality.
* _Ranking score:_ Score is determined by the percentage of individual words that are found on each file, even id they are repeated. The formula is (matched words ammount/total words ammount) * 100. 

## Process
#### Selecting the right data structures
I decided to go for a `Map[String, Set[String]]` structure to index the files with their corresponding words since `Map` lookup speed is eficiently constant, faster than some of its counterparts like `List`. Same goes for `Set`.
An indexed files Map would look like this: 
~~~
Map(
      "file3.txt"-> Set("lorem"),
      "file2.txt"-> Set("lorem", "ipsum"),
      "file1.txt"-> Set("lorem", "ipsum", "sit")
    )
~~~

#### Data input
I created a simple ET class that takes care of two things: 
1. Recursively extract all of the files inside the input folder.
2. Transforming it into the desired data structure `Map[String, Set[String]]`.
(There is no loading phase for this class so I excluded the _L_ from the usual _ETL_)

#### String Searcher
`StringSearcher` takes care of recursively evaluating the corresponding rank of each file based on the input words.

#### Console application
I created a simple class to simulate a console experience, it takes two kinds of input: 
1. It parses the input words and sends them to the searching algorithm
2. Closes the application when `:quit` is inpt by the user.

## Time management
I spent around 5 hours total to complete this task. Most of the time was cnsumed in:
1. Considering the right data structure for the indexed files.
2. General design of the application
3. Trying to generate an uber JAR with maven. It was taking me too long to produce a JAR that contained both Java and Scala's libraries without failing so I opted to run the program directly from maven with the aforementionned command.
