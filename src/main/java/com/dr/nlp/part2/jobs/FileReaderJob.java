package com.dr.nlp.part2.jobs;

import com.dr.nlp.part2.Runners.DataReader;
import com.dr.nlp.part2.dataStructures.DataFile;

/**
 * Created by Nikandish on 6/12/15 at 12:14 PM.
 */
public class FileReaderJob {
  /**
   * Call readDataFromFile by sending it the filename and read the files content from the disk.
   * @param fileName
   * @return
   */
  public DataFile runJob(String fileName) {
    DataReader reader = new DataReader();
    DataFile dataFile= reader.readDataFromFile(fileName);
    return dataFile;
  }
}
