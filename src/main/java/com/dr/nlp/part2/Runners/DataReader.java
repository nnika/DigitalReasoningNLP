package com.dr.nlp.part2.Runners;

import com.dr.nlp.part2.dataStructures.DataFile;
import com.dr.nlp.part2.util.NLPDataReader;
import com.dr.nlp.part2.util.NamedEntityList;
import com.dr.nlp.part2.util.ObjectToXML;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;


/**
 *
 *  This class readDataFromFile() method accepts fileName and calls readInputFile() to get the BufferedReader
 * from the fileName file to read this files content.
 * I also calls transformObjectToXML when the process of reading and parsing finished to transform the java object
 * to XML
 * Created by Nikandish on 6/12/15 at 12:27 PM.
 */
public class DataReader {
  private static ResourceBundle bundle = ResourceBundle.getBundle("nlp");
  private static final String NERFILE = bundle.getString("file.ner");

  public DataFile readDataFromFile(String fileName) {
    BufferedReader bufferedReader = NLPDataReader.readInputFile(NERFILE);
    List<String> nerList = NamedEntityList.getNamedEntityList(bufferedReader);
    BufferedReader newReader = NLPDataReader.readInputFile(fileName);
    DataFile dataFile = new DataFile(fileName);
    try {
      dataFile = dataFile.readElement(newReader, fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
    /**
     * read each elements of NE dictionary and split them to see if they have one or more words.
     * If they have one words compare it with words of the text,
     * Otherwise according to the length of the NE element compare them with the words,
     * if one of the text words matches compare the next word with the second NE and if it matches compare it with
     * the third and if they match then tag those words as NE.
     */
    for (String st : nerList) {
      String[] split = st.split("\\s+");
      for (com.dr.nlp.part2.dataStructures.Paragraph p : dataFile.getParagraphList()) {
        for (com.dr.nlp.part2.dataStructures.Sentence s : p.getSentences()) {
          List<com.dr.nlp.part2.dataStructures.Word> wList = s.getWords();
          for (int i = 0; i < wList.size(); i++) {
            if (split.length == 3) {
              if (split[0].equals(wList.get(i).getWord()) &&
                  split[1].equals(wList.get(i + 1).getWord().trim()) &&
                  split[2].equals(wList.get(i + 2).getWord().trim())) {
                wList.get(i).setNoun("Noun Entity");
                wList.get(i + 1).setNoun("Noun Entity");
                wList.get(i + 2).setNoun("Noun Entity");
              }
            } else if (split.length == 2) {
              if (split[0].equals(wList.get(i).getWord()) && split[1].equals(wList.get(i + 1).getWord().trim())) {
                wList.get(i).setNoun("Noun Entity");
                wList.get(i + 1).setNoun("Noun Entity");
              }
            } else {
              if (split[0].equals(wList.get(i).getWord())) {
                wList.get(i).setNoun("Noun Entity");
              }
            }
          }
        }
      }
    }
    ObjectToXML objectToXML = new ObjectToXML();
    objectToXML.transformObjectToXML(dataFile, fileName);
    return dataFile;
  }

}
