package com.java8.streams.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestNumber {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 5, 7, 9, 12, 10, 20);

        Optional<Integer> secondHighest = numbers.stream()
                .sorted((a, b) -> b.compareTo(a))
                .skip(1)
                .findFirst();

        System.out.println(secondHighest.get());

        Optional<Integer> secondHighest1 = numbers.stream()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .skip(1)
                .findFirst();

        System.out.println(secondHighest1.get());


        Optional<Integer> secondHighest2 = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println(secondHighest2.get());


        Optional<Integer> secondHighest3 = numbers.stream()
                .sorted(Comparator.comparing(Integer::intValue, Comparator.reverseOrder()))
                .skip(1)
                .findFirst();
        System.out.println(secondHighest3.get());

        Optional<Integer> secondHighest4 = numbers.stream()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .skip(1)
                .findFirst();
        System.out.println(secondHighest4.get());


    }

}
