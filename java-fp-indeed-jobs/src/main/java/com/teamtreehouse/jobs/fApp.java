package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
    System.out.printf("Imperatively:\n");
    getThreeJuniorJobsImperatively(jobs).forEach(System.out::println);
    System.out.println("Declaratively:");
    getThreeJuniorJobsSteam(jobs).forEach(System.out::println);
//    filters jobs declaratively using stream
//    jobs.stream()
//            .filter(job -> job.getCity().equals("OR"))
//            .filter(job -> job.getCity().equals("Portland"))
//            .forEach(System.out::println);
//  }

//    filters jobs imperatively
//  private static void printPortlandJobsImperatively(List<Job> jobs) {
//    for (Job job: jobs) {
//      if (job.getState().equals("OR") && job.getCity().equals("Portland")) {
//        System.out.println(job);
//      }
//    }
//  }
  }
    private static List<Job> getThreeJuniorJobsSteam (List<Job> jobs) {
      return jobs.stream()
              .filter(fApp::isJuniorJob)
              .limit(3).collect(Collectors.toList());
    }
    private static boolean isJuniorJob (Job job) {
      String title = job.getTitle().toLowerCase();
      return title.contains("junior") || title.contains("jr");

    }

    private static List<Job> getThreeJuniorJobsImperatively (List < Job > jobs) {
      List<Job> juniorJobs = new ArrayList<>();
      for (Job job : jobs) {
        if (isJuniorJob(job)) {
          juniorJobs.add(job);
          if (juniorJobs.size() >= 3) {
            break;
          }
        }
      }
      return juniorJobs;
    }
  }