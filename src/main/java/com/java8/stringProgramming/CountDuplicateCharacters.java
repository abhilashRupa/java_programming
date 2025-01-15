package com.java8.stringProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicateCharacters {

    public static void main(String[] args) {
        String fruitName = "banana";

        approach1UsingGroupBy(fruitName);
        approach2UsingStreamMapMerge(fruitName);
        approach3(fruitName);
        approach4(fruitName);
        approach5(fruitName);

    }

    private static void approach1UsingGroupBy(String fruitName){
        Map<Character, Long> countMap = fruitName.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<String, Long> countMap1 = fruitName.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("approach1.0: "+countMap);
        System.out.println("approach1.1: "+countMap1);
    }

    private static void approach2UsingStreamMapMerge(String fruitName){
        Map<Character, Integer> countMap = new HashMap<>();

        fruitName.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(character -> countMap.merge(character, 1, Integer::sum));

        Map<Character, Integer> duplicateCountMap = countMap.entrySet().stream()
                        .filter(entry -> entry.getValue() > 1)
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        System.out.println("approach 2: "+duplicateCountMap);
    }

    private static void approach4(String name) {
        String[] nameChar = name.split("");

        Map<String, Long> countMap = Arrays.stream(nameChar)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("approach4: "+countMap);
    }

    /*using java 11*/
    private static void approach3(String fruitName){

        Map<String, Long> countMap = fruitName.codePoints()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("approach 3: "+countMap);

    }
    private static void approach5(String fruitName){

        Map<Character, Long> countMap = fruitName.codePoints()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("approach 5: "+countMap);

    }



}
