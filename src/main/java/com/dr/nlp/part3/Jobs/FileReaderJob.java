package com.dr.nlp.part3.Jobs;

import com.dr.nlp.part3.Runners.DataReader;
import com.dr.nlp.part3.dataStructures.DataFile;

/**
 *
 * This class runJob method gets a filename and calls readDataFromFile() to read that file from the disk.
 * Created by Nikandish on 6/12/15 at 12:14 PM.
 */
public class FileReaderJob {

  /**
   *
   * @param fileName
   * @return
   */
  public DataFile runJob(String fileName) {
    DataReader reader = new DataReader();
    return reader.readDataFromFile(fileName);
  }
}
