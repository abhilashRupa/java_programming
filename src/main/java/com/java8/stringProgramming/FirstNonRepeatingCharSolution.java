package com.java8.stringProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharSolution {

    public static void main(String[] args) {
        FirstNonRepeatingCharSolution firstNonRepeatingChar = new FirstNonRepeatingCharSolution();

        String s = "geeksforgeeks";

        char c = firstNonRepeatingChar.findFirstNonRepeatingChar(s);
        System.out.println(c);

        char c1 = firstNonRepeatingChar.findFirstNonRepeatingCharApproach1(s);
        System.out.println(c1);

    }

    private char findFirstNonRepeatingChar(String s) {

        Map<Character, Long> charCountMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

       Optional<Character> firstNonRepeatChar = charCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst();

       if(firstNonRepeatChar.isPresent())
           return firstNonRepeatChar.get();
       return 0;

    }

    private char findFirstNonRepeatingCharApproach1(String s){

        Map<Character, Integer> countChar = new LinkedHashMap<>();

        s.chars()
                .mapToObj(c -> (char)c)
                .forEach(character -> {
                    countChar.merge(character, 1, Integer::sum);
                });

        Optional<Character> firstNonRepeatChar = countChar.entrySet()
                .stream()
                .filter(entry -> entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst();

        if(firstNonRepeatChar.isPresent())
            return firstNonRepeatChar.get();
        return 0;
    }
}
