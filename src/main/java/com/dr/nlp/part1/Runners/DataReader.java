package com.dr.nlp.part1.Runners;

import com.dr.nlp.part1.dataStructures.DataFile;
import com.dr.nlp.part1.util.NLPDataReader;
import com.dr.nlp.part1.util.ObjectToXML;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * This class readDataFromFile() method accepts fileName and calls readInputFile() to get the BufferedReader
 * from the fileName file to read this files content.
 * I also calls transformObjectToXML when the process of reading and parsing finished to transform the java object
 * to XML
 *
 * Created by Nikandish on 6/12/15 at 12:27 PM.
 */
public class DataReader {
  /**
   *
   * @param fileName
   * @return
   */
  public DataFile readDataFromFile(String fileName) {
    BufferedReader newReader = NLPDataReader.readInputFile(fileName);
    DataFile dataFile = new DataFile(fileName);
    try {
      dataFile = dataFile.process(newReader, fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
       NLPDataReader.closeReader();
    }
    ObjectToXML objectToXML = new ObjectToXML();
    objectToXML.transformObjectToXML(dataFile,fileName);
    return dataFile;
  }
}
