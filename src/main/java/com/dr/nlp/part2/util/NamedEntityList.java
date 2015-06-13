package com.dr.nlp.part2.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikandish on 6/11/15 at 4:16 PM.
 */
public class NamedEntityList {
  public static List<String> getNamedEntityList(BufferedReader reader){
    List<String> list = new ArrayList<>();
    String line;
    try {
      while ((line = reader.readLine()) != null) {
        if(line.length()>0)
          list.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }
}
