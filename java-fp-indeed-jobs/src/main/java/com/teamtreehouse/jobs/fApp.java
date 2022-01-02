package com.teamtreehouse.jobs;

import com.teamtreehouse.jobs.model.Job;
import com.teamtreehouse.jobs.service.JobService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    Function<String, LocalDateTime> indeedDateConverter =
            myString -> LocalDateTime.parse(myString, DateTimeFormatter.RFC_1123_DATE_TIME);

    Function<LocalDateTime, String> siteDateStringConverter =
            date -> date.format(DateTimeFormatter.ofPattern("M / d / YY"));

    jobs.stream()
            .map(Job::getDateTimeString)
          .map(indeedDateConverter.andThen(siteDateStringConverter))
            .limit(5)
            .forEach(System.out::println);

//    List<String> companies = jobs.stream()
//            .map(Job::getCompany)
//            .distinct()
//            .sorted()
//            .collect(Collectors.toList());
//      IntStream.iterate(1, i-> i + 1)
//              .mapToObj(i->String.format("%d. %s", i, companies.get(i-1)))
//              .limit(companies.size())
//              .forEach(System.out::println);

//    IntStream.rangeClosed(1,20)
//                    .mapToObj(i -> String.format("%d. %s", i, companies.get(i-1)))
//                    .forEach(System.out::println);

//    displayCompaniesImparatively(companies);
//    String searchTerm = "trampoline";
//    Optional<Job> foundJob = luckySearchJob(jobs, searchTerm);
//
//    System.out.println(foundJob.isPresent());
//    System.out.println(foundJob
//            .map(Job::getTitle)
//            .orElse("No jobs found"));


//    getSnippetWordCountsImperatively(jobs)
//            .forEach((key,value) -> System.out.printf("'%s' occurs %d times \n", key, value));

//    Stream.of("hello","this","is","a","stream")
//            .forEach(System.out::println);

//    System.out.printf("Imperatively:\n");
//    getThreeJuniorJobsImperatively(jobs).forEach(System.out::println);
//    System.out.println("Declaratively:");
//    getThreeJuniorJobsSteam(jobs).forEach(System.out::println);
//    getThreeCaptionsImperatively(jobs).forEach(System.out::println);
//    getThreeCaptionsSteam(jobs).forEach(System.out::println);
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

  public static void emailIfMatches(Job job, Predicate<Job> checker) {

  }

  private static void displayCompaniesImparatively(List<String> companies) {
    for (int i=0; i < 20; i++) {
      System.out.printf("%d. %s %n", i + 1, companies.get(i));
    }
  }

  private static Optional<Job> luckySearchJob(List<Job> jobs, String searchTerm) {
    Optional<Job> foundJob = jobs.stream()
            .filter(job -> job.getTitle().contains(searchTerm))
            .findFirst();
    return foundJob;
  }
//  public static Map<String, Long> getSnippetWordCountsStream(List<Job> jobs) {
//    return jobs.stream()
//            .map(Job::getSnippet)
//            .map(snippet -> snippet.split("\\W+"))
//            .flatMap(Steam::of)
//            .filter(word -> word.length() >0)
//            .map(String::toLowerCase)
//            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
////            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//
//  }

  public static Map<String, Long> getSnippetWordCountsImperatively(List<Job> jobs) {

    Map<String, Long> wordCounts = new HashMap<>();

    for (Job job : jobs) {
      String[] words = job.getSnippet().split("\\W+");
      for (String word : words) {
        if (word.length() == 0) {
          continue;
        }
        String lWord = word.toLowerCase();
        Long count = wordCounts.get(lWord);
        if (count == null) {
          count = 0L;
        }
        wordCounts.put(lWord, ++count);
      }
    }
    return wordCounts;
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


  private static List<String> getThreeCaptionsSteam (List<Job> jobs) {
    return jobs.stream()
            .filter(fApp::isJuniorJob)
            .map(Job::getCaption)
            .limit(3).collect(Collectors.toList());
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
  private static List<String> getThreeCaptionsImperatively (List < Job > jobs) {
    List<String> captions = new ArrayList<>();
    for (Job job : jobs) {
      if (isJuniorJob(job)) {
        captions.add(job.getCaption());
        if (captions.size() >= 3) {
          break;
        }
      }
    }
    return captions;
  }

  }