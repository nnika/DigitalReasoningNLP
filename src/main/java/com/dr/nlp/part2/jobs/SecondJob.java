package com.dr.nlp.part2.jobs;

import com.dr.nlp.part2.dataStructures.DataFile;

import java.util.ResourceBundle;

/**
 * This class gets a file name and calls readDataFromFile
 * to read that input file on the disk.
 * Created by Nikandish on 6/12/15 at 6:42 PM.
 */
public class SecondJob implements Job {
  private static ResourceBundle bundle = ResourceBundle.getBundle("nlp");
  private static final String FILENAME = bundle.getString("file.name");
  private static DataFile dataFile;

  /**
   *  Read fileName using readDataFromFile
   */
  public void runJob() {
    FileReaderJob fileReaderJob = new FileReaderJob();
    dataFile = fileReaderJob.runJob(FILENAME);
  }

  @Override
  public DataFile getJobResult() {
    return dataFile;
  }
}
