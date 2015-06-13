package com.dr.nlp.part1.dataStructures;

/**
 * Created by Nikandish on 6/10/15 at 6:40 PM.
 */
public class Punctuation {
  private String punctuation;
  private int begin;
  private int end;

  public Punctuation(String punctuation, int begin, int end) {
    this.punctuation = punctuation;
    this.begin = begin;
    this.end = end;
  }

  public Punctuation() {
  }

  public int getBegin() {
    return begin;
  }

  public void setBegin(int begin) {
    this.begin = begin;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public String getPunctuation() {
    return punctuation;
  }

  public void setPunctuation(String punctuation) {
    this.punctuation = punctuation;
  }

}
