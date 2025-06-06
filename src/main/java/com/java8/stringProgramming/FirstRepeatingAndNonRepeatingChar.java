package com.java8.stringProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatingAndNonRepeatingChar {

  public static void main(String[] args) {
    String input = "geeksforgeeks";

    FirstRepeatingAndNonRepeatingChar firstRepeatingAndNonRepeatingChar =
        new FirstRepeatingAndNonRepeatingChar();

    System.out.println(firstRepeatingAndNonRepeatingChar.approach1(input));
    System.out.println(firstRepeatingAndNonRepeatingChar.approach2(input));

    System.out.println(firstRepeatingAndNonRepeatingChar.nonRepeating(input));
  }

  private char approach1(String input) {

    Map<Character, Integer> charCount = new LinkedHashMap<>();

    input.chars().mapToObj(c -> (char) c).forEach(c -> charCount.merge(c, 1, Integer::sum));

    Optional<Map.Entry<Character, Integer>> nonRepeatingChars =
        charCount.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();

    return nonRepeatingChars.get().getKey();
  }

  private char approach2(String input) {

    LinkedHashMap<Character, Long> charCountMap =
        input
            .chars()
            .mapToObj(c -> (char) c)
            .collect(
                Collectors.groupingBy(
                    Function.identity(), LinkedHashMap::new, Collectors.counting()));

    Optional<Character> c =
        charCountMap.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst();

    return c.get();
  }

  private char nonRepeating(String input) {

    LinkedHashMap<Character, Long> charCountMap =
        input
            .chars()
            .mapToObj(c -> (char) c)
            .collect(
                Collectors.groupingBy(
                    Function.identity(), LinkedHashMap::new, Collectors.counting()));

    Optional<Character> c =
        charCountMap.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            .map(Map.Entry::getKey)
            .findFirst();

    return c.get();
  }
}
