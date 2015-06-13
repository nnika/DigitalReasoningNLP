package com.dr.nlp.part1.jobs.test;

import com.dr.nlp.part1.jobs.FirstJob;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nikandish on 6/12/15 at 9:39 PM.
 */
public class FirstJobTest {
  @Test
  public void testFirstJob(){
    FirstJob firstJob = new FirstJob();
    firstJob.runJob();

    assertEquals(2, firstJob.getJobResult().getParagraphList().size());
    assertEquals("The term \"First World War\" was first used in September " +
            "1914 by the German philosopher Ernst Haeckel, who claimed that " +
            "\"there is no doubt that the course and character of the feared " +
            "'European War' ... will become the first world war in the full sense of the word.\"",
        firstJob.getJobResult().getParagraphList().get(0).getParagraph());
  }
}
