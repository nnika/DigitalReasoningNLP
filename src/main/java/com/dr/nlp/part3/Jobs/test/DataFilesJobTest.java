package com.dr.nlp.part3.Jobs.test;

import com.dr.nlp.part3.Jobs.FileReaderJob;
import com.dr.nlp.part3.dataStructures.DataFile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nikandish on 6/12/15 at 9:39 PM.
 */
public class DataFilesJobTest {
  @Test
  public void testFirstJob(){
    FileReaderJob job = new FileReaderJob();
    DataFile adataFile = job.runJob("d01.txt");

    assertEquals("d01.txt", adataFile.getDataFileName());
    assertEquals(1, adataFile.getParagraphList().size());
    assertEquals("Euclid's Elements has been referred to as the " +
        "most successful and influential textbook ever written. " +
        "First set in type in Venice in 1482, it is one of the very " +
        "earliest mathematical works to be printed after the invention " +
        "of the printing press and was estimated by Carl Benjamin Boyer " +
        "to be second only to the Bible in the number of editions published, " +
        "with the number reaching well over one thousand. For centuries, " +
        "knowledge of at least part of the Elements was required of all students. " +
        "Not until the 20th century, by which time its content was universally " +
        "taught through other school textbooks, did it cease to be considered " +
        "something all educated people had read.",
        adataFile.getParagraphList().get(0).getParagraph());

  }
}
