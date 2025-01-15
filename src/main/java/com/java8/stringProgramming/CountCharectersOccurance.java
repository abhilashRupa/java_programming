package com.java8.stringProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharectersOccurance {

    public static void main(String[] args) {
        String fruitName = "banana";

        approach1(fruitName);
        approach2(fruitName);
        approach3(fruitName);
        approach4(fruitName);

    }

    private static void approach1(String fruitName){
        Map<Character, Long> countMap = fruitName.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       Map<String, Long> countMap1 = fruitName.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

       System.out.println("approach1.0: "+countMap);
        System.out.println("approach1.1: "+countMap1);
    }

    private static void approach2(String fruitname){
        Map<Character, Integer> countMap = new HashMap<>();

        fruitname.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(character -> countMap.merge(character, 1, Integer::sum));

        System.out.println("approach 2: "+countMap);
    }

    /*using java 11*/
    private static void approach3(String fruitName){

        Map<String, Long> countMap = fruitName.codePoints()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("approach 3: "+countMap);

    }

    private static void approach4(String name) {
        String[] nameChar = name.split("");

        Map<String, Long> countMap = Arrays.stream(nameChar)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("approach4: "+countMap);
    }

}
