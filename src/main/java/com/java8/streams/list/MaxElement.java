package com.java8.streams.list;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class MaxElement {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 3, 5, 6, 75, 34, 667, 33);

        approach1(numberList);
        approach2(numberList);


    }

    private static void approach1(List<Integer> numberList) {
        int maxNumber = numberList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(RuntimeException::new);

        System.out.println(maxNumber);
    }

    private static void approach2(List<Integer> numberList) {
        OptionalInt maxNumber = numberList.stream()
                .mapToInt(Integer::intValue)
                .max();
        maxNumber.ifPresent(System.out::println);
    }

    //    using java 10
/*    private static void approach1(List<Integer> numberList) {
        int maxNumber = numberList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();

        System.out.println(maxNumber);
    }*/
}
