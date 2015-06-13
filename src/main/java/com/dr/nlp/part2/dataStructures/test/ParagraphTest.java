package com.dr.nlp.part2.dataStructures.test;
import com.dr.nlp.part2.dataStructures.Paragraph;
import com.dr.nlp.part2.dataStructures.Sentence;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nikandish on 6/12/15 at 8:41 PM.
 */
public class ParagraphTest {
  @Test
  public void testParagraph() {
    Paragraph paragraph = new Paragraph();
    Sentence s1 = new Sentence();
    Sentence s2 = new Sentence();
    List<Sentence> sentence = new ArrayList<>(2);
    s1.setSentence("Hello World!");
    s2.setSentence("Nice job!!");
    sentence.add(s1);
    sentence.add(s2);
    paragraph.setSentences(sentence);
    assertEquals(2, paragraph.getSentences().size());
    assertEquals("Hello World!", paragraph.getSentences().get(0).getSentence());


  }
}
