package com.dr.nlp.part2.dataStructures;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a holder for the text from an input file. Where it keeps the in the list of Paragraph in an ArrayList
 * It processes the text from an input file by reading it line by line. Then it separates each paragraph and puts it
 * in the paragraph list. It then calls the sentence parser to parse each sentence of that paragraph. Each paragraph
 * holds a list of its sentence. And each sentence has a list of its words and punctuations.
 * Created by Nikandish on 6/11/15 at 11:58 PM.
 */
@XmlRootElement
public class DataFile {
  private List<Paragraph> paragraphList;
  private String dataFileName;

  public DataFile() {
  }

  public DataFile(String dataFileName) {
    this.paragraphList = new ArrayList<>();
    this.dataFileName = dataFileName;
  }

  public List<Paragraph> getParagraphList() {
    return paragraphList;
  }

  public void setParagraphList(List<Paragraph> paragraphList) {
    this.paragraphList = paragraphList;
  }

  public String getDataFileName() {
    return dataFileName;
  }

  public void setDataFileName(String dataFileName) {
    this.dataFileName = dataFileName;
  }

  /**
   * Processes the text from an input file by reading it line by line.
   * Separate each paragraph and put it in the paragraph list.
   * Calls the sentence parser to parse each sentence of that paragraph.
   * @param reader
   * @param dataFileName
   * @return
   * @throws IOException
   */
  public DataFile readElement(BufferedReader reader, String dataFileName) throws IOException {
    DataFile dataFile = new DataFile(dataFileName);
    String line;
    while ((line = reader.readLine()) != null) {
      if (line.length() > 0) {
        List<Sentence> sentenceList = new ArrayList<>();
        Paragraph paragraph = new Paragraph();
        paragraph.setParagraph(line);
        paragraphList.add(paragraph);// add each paragraph to the ArrayList of paragraphs that DataFile holds
        Sentence sen = new Sentence();
        sen.parseSentences(line, sentenceList);// call parser of sentence class to parse a paragraph to sentences
                                               // and put each sentence in the sentence list that a paragraph holds
        paragraph.setSentences(sentenceList);
        for (Sentence sentence : sentenceList) {
          sentence.tokenize(sentence.getSentence());// tokenize each sentence to words and  punctuations and put the
                                                    // and hold them as lists in Sentence class.
        }
      }
    }
    dataFile.setParagraphList(paragraphList);
    return dataFile;

  }

}
