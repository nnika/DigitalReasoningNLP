package com.dr.nlp.part3.util.test;

import com.dr.nlp.part3.util.NLPDataReader;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nikandish on 6/12/15 at 10:00 PM.
 */
public class NLPDataReaderTest {
  @Test
  public void testNLPDataReader(){
    String line;
    BufferedReader bufferedReader = NLPDataReader.readInputFile("test.txt");
    try {
      List<String> list = new ArrayList<>();
      while ((line = bufferedReader.readLine()) != null) {
        list.add(line);
      }
      assertEquals("This is my test.", list.get(0));
      assertEquals("Llywelyn ap Gruffudd is my friend.", list.get(1));

    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
  }
}
