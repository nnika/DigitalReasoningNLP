Digital Reasoning Remote programming exercise


Describe any assumptions you make in your implementation.
1. Input files are not changed. 
2. This application uses in memory lists for each file, its paragraphs, sentence, words, and punctuations.  
3. It assumes that named entities are not more than 3 words.


What are the limitations of your approach? 
1. This app is not suitable for large data files because it is putting all elements of the file in the memory.
2. It uses a very rudimentary algorithm for identifying the named entities.
3. For a large Named Entity dictionary this app will be slow because it is using list instead of hash.

What other approaches might be possible? 
1. I would use openNLP or Apache UIMA algorithms for NER. 
2. I wouldn't put all the files in the memory. I would partition the files and read partitions and merge them.

Implementation - Part One


1. DataFile, Paragraph, Punctuation, Sentence, Word
 
Data structures for the datafile, paragraph, punctuation, sentence, and words were created. It defines classes for
each of the named elements. Where the each class hold a list of its sub-elements(e.g. paragraph holds a list of sentence).
DataFile class processes input file and reads its data. Paragraph class gets data from the DataFile class and extracts 
each paragraph and passes the data to the Sentence class. This class process the data, retrieve the sentence by 
tokenizing them and sends the data to word/punctuation classes where each one sets its own data.

Also Identifying the location of each data structure(DataFile, Paragraph, Punctuation, Sentence, Word)
in the file was done by identifying beginning and end of each(DataFile, Paragraph, Punctuation, Sentence, Word) 
for the future enhancement.
 
2. FileReaderJob, FileJob, Job 
Jobs for reading the NLP and NER data, splitting it to paragraphs, sentence and words. 
FirstJob uses FileReaderJob class to read input files. FileReaderJob calls DataReader class to retrieve DataFile data.
DataReader class uses BufferedReader utility class to read the input file, and send the data to DataFile to be processed.

3. Runners: DataReader Reads the input files

4. Utilities: NLPDataReader and ObjectToXML
NLPDataReader is used as a generic class to read any input file.
ObjectToXML is used as a generic class to marshal data from a java object to xml.

5. Several unit tests were used to test the correctness of each class's operation.
These are the test classes: DataFileTest.class, ParagraphTest.class, PunctuationTest.class, 
SentenceTest.class, DataFileTest.class, WordTest.class,  FirstJobTest.class, NLPDataReaderTest.class

Implementation - Part Two
The new feature for NER is added to this part. It reads the NE input file to a list and looks at the length of 
each NE int that list. 
(a) If NE is larger than one(it has more than one word) the app compares the next word in the text 
with the next words of NE, if they are the same it annotates the words with NE tag. 
(b) If NE is equal to one (it has only one word) the app only compare with single words of the text, 
if they are the same it annotates the words with NE tag. 

Implementation - Part Three
The thread pool part is added so the app is able to read several input files from the directory and process them in 
parallel. It writes the file separately to a directory called "output_files".
The next process merges the XML files to a file called. "merged.xml"


6. Output
Running the first task creates: "nlp_data.txt_output_1.xml" on the main directory that the app resides.
Running the second task creates: "nlp_data.txt_output_2.xml" on the main directory that the app resides.
Running the third task creates: "merged.xml" on the main directory that the app resides.
(It creates 10 files in the "output_files" and then merges them to "merged.xml"

7. Structure of the program: 
programs reside in the com.dr.nlp package:

Task one is in com.dr.nlp.part1
Task two is in com.dr.nlp.part2
Task three is in com.dr.nlp.part3


