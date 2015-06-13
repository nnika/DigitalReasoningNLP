package com.dr.nlp.part2.dataStructures.test;

import com.dr.nlp.part2.dataStructures.Punctuation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Nikandish on 6/12/15 at 8:37 PM.
 */
public class PunctuationTest {
  @Test
  public void testPunctuation() {
    assertEquals("????", new Punctuation("????",0,4).getPunctuation());
    assertEquals("?", new Punctuation("?",0,1).getPunctuation());
    assertNotEquals(".", new Punctuation("?",0,1).getPunctuation());
  }
}
