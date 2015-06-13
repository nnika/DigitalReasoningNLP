package com.dr.nlp.part1.dataStructures.test;

import com.dr.nlp.part1.dataStructures.DataFile;
import com.dr.nlp.part1.util.NLPDataReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
/**
 * Created by Nikandish on 6/12/15 at 9:23 PM.
 */
public class WordTest {
 @Test
  public void testWord() {
   String fileName = "test.txt";
   DataFile dataFile = new DataFile(fileName);
   BufferedReader newReader = NLPDataReader.readInputFile(fileName);
   try {
     dataFile.process(newReader, fileName);
   } catch (IOException e) {
     e.printStackTrace();
   }
   assertEquals("test.txt", dataFile.getDataFileName());
   assertEquals(4, dataFile.getParagraphList().get(0).getSentences().get(0).getWords().size());
   assertEquals("This", dataFile.getParagraphList().get(0).getSentences().get(0).getWords().get(0).getWord());
   assertEquals(3, dataFile.getParagraphList().get(0).getSentences().get(0).getWords().get(0).getEnd());
   //Llywelyn ap Gruffudd is my friend. ==> 2nd paragraph
   //01234567
   assertEquals("Llywelyn", dataFile.getParagraphList().get(1).getSentences().get(0).getWords().get(0).getWord());
   assertEquals(7, dataFile.getParagraphList().get(1).getSentences().get(0).getWords().get(0).getEnd());
 }
}
