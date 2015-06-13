package com.dr.nlp.part3.dataStructures;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Nikandish on 6/10/15 at 6:40 PM.
 */
public class Sentence {
  private String sentence;
  private int being;
  private int end;
  private List<Word> words = new ArrayList<>();
  private List<Punctuation> punctuations = new ArrayList<>();

  public Sentence() {
  }

  public Sentence(String sentence, int being, int end) {
    this.sentence = sentence;
    this.being = being;
    this.end = end;
  }

  public List<Word> getWords() {
    return words;
  }

  public void setWords(List<Word> words) {
    this.words = words;
  }

  public List<Punctuation> getPunctuations() {
    return punctuations;
  }

  public void setPunctuations(List<Punctuation> punctuations) {
    this.punctuations = punctuations;
  }

  public int getBeing() {
    return being;
  }

  public void setBeing(int being) {
    this.being = being;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public String getSentence() {
    return sentence;
  }

  public void setSentence(String sentence) {
    this.sentence = sentence;
  }

  /**
   * Parses a paragraph to sentences
   * @param sentenceStr
   * @param sentences
   * @return
   */
  public List<Sentence> parseSentences(String sentenceStr, List<Sentence> sentences ) {
    Locale currentLocale = new Locale("en", "US");
    BreakIterator sentenceIterator = BreakIterator.getSentenceInstance(currentLocale);
    List<Sentence> sentenceList = new ArrayList<>();
    sentenceIterator.setText(sentenceStr);
    int boundary = sentenceIterator.first();
    while (boundary != BreakIterator.DONE) {
      int begin = boundary;
      boundary = sentenceIterator.next();
      int end = boundary;
      if (end == BreakIterator.DONE) {
        break;
      }
      //System.out.println("[" + sentenceStr.substring(begin, end).trim() + "]");
      Sentence sentence = new Sentence();
      sentence.setSentence(sentenceStr.substring(begin, end).trim());
      sentences.add(sentence);
      sentence.setBeing(begin);
      sentence.setEnd(end - 1);
      sentenceList.add(sentence);
    }
    return sentenceList;
  }

  /**
   * Tokenize a sentence to words and punctuations.
   * @param str
   */
  public void tokenize( final String str){
    BreakIterator iterator = BreakIterator.getWordInstance();
    iterator.setText(str);
    int begin = iterator.first();
    int end;
    for (end = iterator.next(); end != BreakIterator.DONE; end = iterator.next()) {
      String token = str.substring(begin, end);
      if (token.trim().length() > 0) {
        if(isPunctuation(token)){
          Punctuation punctuation = new Punctuation();
          punctuation.setPunctuation(token);
          punctuation.setBegin(begin);
          punctuation.setEnd(end - 1);
          punctuations.add(punctuation);
        }else {
          Word word = new Word();
          word.setWord(token);
          word.setBegin(begin);
          word.setEnd(end - 1);
          words.add(word);
        }
      }
      begin = end;
    }
  }

  /**
   * Check to see if a string is punctuation
   * @param a
   * @return
   */
  public boolean isPunctuation(String a) {
    for (int i = 0; i < a.length(); i++) {
      return a.charAt(i) == ','
          || a.charAt(i) == '.'
          || a.charAt(i) == '!'
          || a.charAt(i) == '?'
          || a.charAt(i) == ':'
          || a.charAt(i) == ';'
          || a.charAt(i) == '('
          || a.charAt(i) == ')'
          || a.charAt(i) == '\''
          || a.charAt(i) == '"'
          ;
    }
    return false;
  }

  /*@Override
  public String toString() {
    return "{" +  sentence + '}';
  }*/
}
