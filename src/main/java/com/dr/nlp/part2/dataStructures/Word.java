package com.dr.nlp.part2.dataStructures;

/**
 * Created by Nikandish on 6/10/15 at 6:40 PM.
 */
public class Word {
  private String noun;
  private String word;
  private int begin;
  private int end;

  public Word() {
  }

  public Word(String word, int begin, int end) {
    this.word = word;
    this.begin = begin;
    this.end = end;
  }

  public String getNoun() {
    return noun;
  }

  public void setNoun(String noun) {
    this.noun = noun;
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

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

}
