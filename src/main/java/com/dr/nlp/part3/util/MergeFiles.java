package com.dr.nlp.part3.util;

import java.io.*;

/**
 * This class merges 10 XML files that is getting created when marshaling the Java objects.
 * Created by Nikandish on 6/13/15 at 1:01 AM.
 */
public class MergeFiles {
  /**
   *
   * @param files
   * @param mergedFile
   */
  public static void mergeFiles(File[] files, File mergedFile) {

    FileWriter fstream = null;
    BufferedWriter out = null;
    try {
      fstream = new FileWriter(mergedFile, true);
      out = new BufferedWriter(fstream);
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    int counter = 0;
    int seCounter = 0;
    for (File f : files) {
      //System.out.println("merging: " + f.getName());
      FileInputStream fis;
      try {
        fis = new FileInputStream(f);
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));

        String aLine;

        while ((aLine = in.readLine()) != null) {
          if (counter == 0) {
            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
            out.newLine();
          } else if (!aLine.equals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")) {
            out.write(aLine);
            out.newLine();
          }
          if (seCounter == 0) {
            out.write("<dataFiles>");
            out.newLine();
          }
          seCounter++;
          counter++;
        }

        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try {
      out.write("</dataFiles>");
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
