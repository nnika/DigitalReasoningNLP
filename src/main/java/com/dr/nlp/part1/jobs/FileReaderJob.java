package com.dr.nlp.part1.jobs;

import com.dr.nlp.part1.Runners.DataReader;
import com.dr.nlp.part1.dataStructures.DataFile;

/**
 * This class gets a file name and calls readDataFromFile
 * to read that input file on the disk.
 * Created by Nikandish on 6/12/15 at 12:14 PM.
 */
public class FileReaderJob {
  /**
   * Read fileName using readDataFromFile
   * @param fileName
   * @return
   */
  public DataFile runJob(String fileName) {
    DataReader reader = new DataReader();
    DataFile dataFile= reader.readDataFromFile(fileName);
    return dataFile;
  }
}
