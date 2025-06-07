package com.java8.streams.list;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicateStringFromList {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "b", "d", "a", "a", "b", "z", "z", "b", "b", "b");

        approach1(names);
        approach2(names);


    }

    private static void approach1(List<String> names) {

        Map<String, Integer> countMap = new LinkedHashMap<>();

        names.forEach(s -> {
            countMap.merge(s, 1, Integer::sum);
        });

        Map<String, Integer> duplicateCount = countMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(duplicateCount);

    }

    private static void approach2(List<String> names) {

        names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(System.out::println);
    }
}
