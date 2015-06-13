package com.dr.nlp.part1.jobs;

import com.dr.nlp.part1.dataStructures.DataFile;

import java.util.ResourceBundle;

/**
 * This class has a method that takes no arguments and calls runJob() with and fileName as it argument
 * It has a class level DataFile variable that is populated in runJob() method and other methods can
 * use it by calling getJobResult()
 * Created by Nikandish on 6/12/15 at 6:42 PM.
 */
public class FirstJob implements Job{
  private DataFile dataFile;
  private static ResourceBundle bundle = ResourceBundle.getBundle("nlp");
  private static final String FILENAME = bundle.getString("file.name");

  /**
   * Takes no argument and calls runJob by fileName as argument.
   */
  public void runJob() {
    FileReaderJob fileReaderJob = new FileReaderJob();
    dataFile = fileReaderJob.runJob(FILENAME);
  }

  @Override
  /**
   * returns DataFile variable
   */
  public DataFile getJobResult() {
    return dataFile;
  }
}
