package com.dr.nlp.part3.Jobs;

import java.util.concurrent.Callable;

/**
 * This class has a call() method tht call runJob() and returns job results.
 *
 * Created by Nikandish on 6/12/15 at 12:08 PM.
 */
public class CallableJob<V> implements Callable<V>{
  private Job<V> job;


  public CallableJob(Job<V> job) {
    this.job = job;
  }

  @Override
  public V call() throws Exception {
    job.runJob();
    return job.getJobResult();
  }
}
