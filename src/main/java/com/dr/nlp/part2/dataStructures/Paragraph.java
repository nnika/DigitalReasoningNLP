package com.dr.nlp.part2.dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikandish on 6/10/15 at 12:36 PM.
 */

public class Paragraph {
  private String paragraph;
  private List<Sentence> sentences = new ArrayList<>();

  public String getParagraph() {
    return paragraph;
  }

  public void setParagraph(String paragraph) {
    this.paragraph = paragraph;
  }

  public List<Sentence> getSentences() {
    return sentences;
  }
  public void setSentences(List<Sentence> sentences) {
    this.sentences = sentences;
  }


}
