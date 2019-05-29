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



