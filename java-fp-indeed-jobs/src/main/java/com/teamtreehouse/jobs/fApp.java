package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.util.List;

public class fApp {

  public static void main(String[] args) {
    JobService service = new JobService();
    boolean shouldRefresh = false;
    try {
      if (shouldRefresh) {
        service.refresh();
      }
      List<Job> jobs = service.loadJobs();
      System.out.printf("Total jobs:  %d %n %n", jobs.size());
      explore(jobs);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void explore(List<Job> jobs) {
    // Your amazing code below...
//    jobs.stream().filter(job -> );
  }

  private static void printPortlandJobsImperatively(List<Job> jobs) {
    for (Job job: jobs) {
      if (job.getState().equals("OR") && job.getCity().equals("Portland")) {
        System.out.println(job);
      }
    }
  }
}
