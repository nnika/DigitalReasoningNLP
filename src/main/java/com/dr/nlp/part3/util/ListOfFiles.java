package com.dr.nlp.part3.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * A utility class that returns the list of the files that are in the directory.
 * Created by Nikandish on 6/12/15 at 11:57 AM.
 */
public class ListOfFiles {
  private static ResourceBundle bundle = ResourceBundle.getBundle("nlp");
  private static final String FILEDIR = bundle.getString("file.dir");
  private static List<String> filesList = new ArrayList<>();

  /**
   *
   * @return
   */
  public static List<String> getFilesFromDir() {
    File[] files = new File(FILEDIR).listFiles();
    synchronized (ListOfFiles.class) {
      for (File file : files) {
        if (file.isFile()) {
          filesList.add(file.getName());
        }
      }
    }
    return filesList;
  }

  public static int getFilesCount() {
    ListOfFiles.getFilesFromDir();
    return filesList.size();
  }

}
