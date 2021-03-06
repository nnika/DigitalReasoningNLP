package com.dr.nlp.part1.dataStructures.test;

import com.dr.nlp.part1.dataStructures.DataFile;
import com.dr.nlp.part1.util.NLPDataReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nikandish on 6/12/15 at 8:10 PM.
 */
public class DataFileTest {
  @Test
  public void testTextFile() {
    String fileName = "test.txt";
    DataFile dataFile = new DataFile(fileName);
    BufferedReader newReader = NLPDataReader.readInputFile(fileName);
    try {
      dataFile.process(newReader, fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("test.txt", dataFile.getDataFileName());
    assertEquals(2, dataFile.getParagraphList().size());
    assertEquals(4, dataFile.getParagraphList().get(0).getSentences().get(0).getWords().size());
    assertEquals(1, dataFile.getParagraphList().get(0).getSentences().size());
  }
}
