/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 * 
 * JDK 8 MOOC Lesson 3 homework
 */
package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class to generate a list of random words
 *
 * @author Simon Ritter (@speakjava)
 */
public class RandomWords {
  private final List<String> sourceWords;

  /**
   * Constructor
   * 
   * @throws java.io.IOException If the source words file cannot be read
   */
  public RandomWords() throws IOException {   
    try (BufferedReader reader = Files.newBufferedReader(Paths.get("words.txt"))) {

        this.sourceWords = reader.lines()
                .collect(Collectors.toList());

      System.out.println("Loaded " + sourceWords.size() + " words");
    }
  }

  /**
   * Create a list of a given size containing random words
   *
   * @param listSize The size of the list to create
   * @return The created list
   */
  public List<String> createList(int listSize) {
    Random rand = new Random();
    List<String> wordList = null; // YOUR CODE HERE
      wordList = new Random().ints(listSize, 0, listSize - 1)
              .mapToObj(i -> sourceWords.get(i))
              .collect(Collectors.toList());

      System.out.println("Picked " + wordList.size() + " words");
      wordList.forEach(System.out::println);
      System.out.println("------------------------");
    return wordList;
  }

  /**
   * Return the list of all source words, which cannot be modified
   *
   * @return The unmodifiable list of all source words
   */
  public List<String> allWords() {
    return Collections.unmodifiableList(sourceWords);
  }
}