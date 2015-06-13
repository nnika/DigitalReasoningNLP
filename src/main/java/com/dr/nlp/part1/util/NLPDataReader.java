package com.dr.nlp.part1.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

/**
 * Created by Nikandish on 6/10/15 at 12:18 PM.
 */
public class NLPDataReader<T> {
  private static ResourceBundle bundle = ResourceBundle.getBundle("nlp");
  private static final String FILEPATH = bundle.getString("file.path");
  private static BufferedReader bufferedReader = null;

  public static BufferedReader readInputFile(String fileName) {
    Path file_path = Paths.get(FILEPATH, fileName);
    Charset charset = Charset.forName("UTF-8");
    try {
      bufferedReader = Files.newBufferedReader(file_path, charset);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return bufferedReader;
  }

  public static void closeReader() {
    try {
      if (bufferedReader != null)
        bufferedReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
