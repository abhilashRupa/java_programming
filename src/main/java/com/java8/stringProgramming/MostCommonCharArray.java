package com.java8.stringProgramming;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostCommonCharArray {

    public static void main(String[] args) {
        String[] input = {"geeksforgeeks", "geeks", "geek", "geezer" };

        MostCommonCharArray mostCommonCharArray = new MostCommonCharArray();
        System.out.println(mostCommonCharArray.approach1(input));
        System.out.println(mostCommonCharArray.approach2(input));
        System.out.println(mostCommonCharArray.approach3(input));


    }

    private char approach1(String[] input) {

        String concatString = String.join("", input);

        Optional<Map.Entry<String, Long>> mostCommonCharacter =
                concatString
                        .chars()
                        .mapToObj(ch -> (char) ch)
                        .collect(Collectors.groupingBy(Objects::toString, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .findFirst();

        return mostCommonCharacter.get().getKey().charAt(0);
    }

    private char approach2(String[] input) {

        String concarString = String.join("", input);

        Optional<Map.Entry<Character, Long>> mostCommonEntry = concarString.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .findFirst();

        return mostCommonEntry.get().getKey();

    }

    private char approach3(String[] input) {

        String concarString = String.join("", input);

        Optional<Map.Entry<Character, Long>> mostCommonEntry = concarString.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue));

        return mostCommonEntry.get().getKey();

    }

    /*todo -
     *  try another approach by iterating over array and collecting the count of each char and getting the most common
     *
     * */
}
