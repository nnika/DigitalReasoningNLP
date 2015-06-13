package com.dr.nlp.part3.Jobs;

import com.dr.nlp.part3.dataStructures.DataFile;

import java.util.List;

/**
 * This class gets a file name and calls FileReaderJob()
 * to read that input file on the disk.
 * Created by Nikandish on 6/12/15 at 11:54 AM.
 */
public class DataFilesJob implements Job {

  private List<String> arrayList;
  private String fileName;
  private DataFile dataFile;

  public DataFilesJob() {
  }

  public DataFilesJob(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void runJob() {
    FileReaderJob job = new FileReaderJob();
    dataFile= job.runJob(fileName);
  }

  @Override
  public List<String> getJobResult() {
    return arrayList;
  }
  public DataFile getDataFile(){
    return dataFile;
  }
}
