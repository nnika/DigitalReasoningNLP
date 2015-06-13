package com.dr.nlp.part3.Jobs;

import com.dr.nlp.part3.dataStructures.DataFile;
import com.dr.nlp.part3.util.ListOfFiles;
import com.dr.nlp.part3.util.MergeFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This class runJob() method creates the thread pool and executes thread by sending each thread a file.
 *
 *
 * Created by Nikandish on 6/11/15 at 11:52 PM.
 */
public class ThreadPoolJob<E> implements Job {
  private static ResourceBundle bundle = ResourceBundle.getBundle("nlp");
  private static final String FILEOUT = bundle.getString("file.out");
  private static final String OUTPUTDIR = bundle.getString("output.dir");
  private static final String MERGED = bundle.getString("merged.file");
  List<DataFile> dataFileList = new ArrayList<>();

  @Override
  /**
   * create the thread pool and execute each thread by giving each thread a file.
   * Shutdown the executor  service when finished and merge the XML files to one single file.
   */
  public  void runJob() {
    List<Future<DataFile>> futureDataFileList = new ArrayList<>();
    List<String> list = ListOfFiles.getFilesFromDir();
    ExecutorService executor = Executors.newFixedThreadPool(list.size());


    for (String fileName : list) {
      Future<DataFile> textFile = executor.submit(new CallableJob<>(new DataFilesJob(fileName)));
      futureDataFileList.add(textFile);
    }
    executor.shutdown();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    File mergedFile = new File(MERGED);
    File[] files = new File[list.size()];
    for (int i = 0; i < list.size(); i++) {
      files[i] = new File(OUTPUTDIR + list.get(i) + "_" + FILEOUT);
    }
    MergeFiles.mergeFiles(files, mergedFile);
  }

  @Override
  public List<DataFile> getJobResult() {
    return dataFileList;
  }
}
