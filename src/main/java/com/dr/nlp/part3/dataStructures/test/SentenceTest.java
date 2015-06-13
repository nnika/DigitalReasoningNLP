package com.dr.nlp.part3.dataStructures.test;

import com.dr.nlp.part3.dataStructures.DataFile;
import com.dr.nlp.part3.util.NLPDataReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nikandish on 6/12/15 at 9:00 PM.
 */
public class SentenceTest {

  @Test
  public void testSentence(){
    String fileName = "test.txt";
    DataFile dataFile = new DataFile(fileName);
    BufferedReader newReader = NLPDataReader.readInputFile(fileName);
    try {
      dataFile.readElement(newReader, fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("test.txt", dataFile.getDataFileName());
    assertEquals(1, dataFile.getParagraphList().get(0).getSentences().size());
    assertEquals("This is my test.", dataFile.getParagraphList().get(0).getSentences().get(0).getSentence());
    assertEquals(2, dataFile.getParagraphList().size());
  }
}
