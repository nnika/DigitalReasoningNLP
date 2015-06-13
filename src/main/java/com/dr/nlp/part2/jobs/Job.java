package com.dr.nlp.part2.jobs;

/**
 * Created by Nikandish on 6/11/15 at 11:00 PM.
 */
public interface Job<E> {
  void runJob();
  E getJobResult();
}
