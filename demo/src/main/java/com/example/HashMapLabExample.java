package com.example;

import com.github.javafaker.Faker;

import org.yaml.snakeyaml.events.Event.ID;

import java.util.*;

/*
 * HashMapLab Example Code
 */

public class HashMapLabExample {

  // hashmap that maps a jedi name to a jedi id
  private static HashMap<String, Integer> jedi = new HashMap<String, Integer>();
  // hashmap that maps a jedi id to a jedi quote
  private static HashMap<Integer, String> quote = new HashMap<Integer, String>();

  public static void main(String[] args) {
    // initialize the array with random values
    final Integer n = 1000;
    createRandom(n);

    // start the jedi app
    start(n);
  }

  // main loop for app
  public static void start(final Integer n) {
    Scanner scan = new Scanner(System.in);
    String command = "_";

    // loop until user quits
    while (!command.equals("q")) {
      printMenu();
      System.out.printf("Enter a command: ");

      command = menuGetCommand(scan);
      executeCommand(scan, command, n);
    }
  }

  private static void printMenu() {
    System.out.printf(
      "---------------------------------------------------------------\n"
    );
    System.out.printf("j      \tprints the quote of a specific jedi\n");
    System.out.printf("p      \tprints all jedi\n");
    System.out.printf("q      \tto quit\n");
    System.out.printf(
      "---------------------------------------------------------------\n"
    );
  }

  // get first character from input
  private static String menuGetCommand(Scanner scan) {
    String command = "_";

    String rawInput = scan.nextLine();

    if (rawInput.length() > 0) {
      command = rawInput.toLowerCase();
    }

    return command;
  }

  // get integer value from input
  private static Integer menuGetInteger(Scanner scan) {
    Integer value = -1;

    String rawInput = scan.nextLine();

    if (rawInput.length() > 0) {
      rawInput = rawInput.toLowerCase();
      try {
        value = Integer.parseInt(rawInput);
      } catch (Exception e) {
        // System.out.println("Exception: " + e);
        System.out.println("ERROR: the value entered is not a integer");
      }
    }

    return value;
  }

  private static Boolean executeCommand(
    Scanner scan,
    String command,
    Integer n
  ) {
    Boolean success = true;

    switch (command) {
      case "p":
        printAllJedi();
        break;
      case "j":
        System.out.printf("Enter a jedi id # from %d to %d: ", 1, n);
        Integer id = menuGetInteger(scan);
        printJediQuote(id);
        break;
      case "q":
        System.out.println("Thank you for using the jedi app!");
        break;
      default:
        System.out.println("ERROR: Unknown commmand");
        success = false;
    }

    return success;
  }

  // create an array of random numbers
  public static void createRandom(Integer n) {
    Faker faker = new Faker();

    for (int i = 0; i < n; i++) {
      String name = faker.name().firstName();
      String yodaQuote = faker.yoda().quote();
      Integer id = i + 1;
      jedi.put(name, id);
      quote.put(id, yodaQuote);
    }
  }

  public static void printJediQuote(Integer id) {
    // students should write code to
    // print a jedi given an id
    System.out.println("---------------------------------------------------------------");
    System.out.println("Jedi Id   :" + id);
    System.out.println("Quote     :" + quote.get(id));
    
    
  }

  public static void printAllJedi() {
    for(String key: jedi.keySet())
    {
      System.out.println("---------------------------------------------------------------");
      System.out.println("jedi Id   :" + jedi.get(key));
      System.out.println("jedi name :" + key);
      System.out.println("quote     :" + quote.get(jedi.get(key)));
    }
  }
}
