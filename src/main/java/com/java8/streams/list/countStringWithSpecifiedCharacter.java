package com.java8.streams.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* Given a list of string, write a program to count the number of string containing character 'a' using Java Stream API.
* */

public class countStringWithSpecifiedCharacter {

    public static void main(String[] args) {
        List<String> fruitsNames = Arrays.asList("apple", "banana", "orange", "grape", "plum", "kiwi");
        char givenChar = 'a';

        findOccurrenceCount(fruitsNames, givenChar);
        findOccurrenceCountByUsingCount(fruitsNames, givenChar);

    }

    private static void findOccurrenceCount(List<String> stringList, char givenChar) {
        List<String> occurrenceList = stringList.stream()
                .filter(string -> string.contains(String.valueOf(givenChar)))
                .collect(Collectors.toList());

        System.out.println("total count: " + occurrenceList.size());
    }

    private static void findOccurrenceCountByUsingCount(List<String> stringList, char givenChar) {
        long totalCount = stringList.stream()
                .filter(string -> string.contains(String.valueOf(givenChar)))
                .count();
        System.out.println("total count using count method : " + totalCount);
    }
}
