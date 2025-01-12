package com.java8.streams.list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
* Write a program to filter out even and odd number from the given list using Java Stream API
* */

public class FilterEvenOdd {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1,2,4,5,7,8,11,9);

        Map<Boolean, List<Integer>> filerListMap = numberList.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 ==0));

        System.out.println(filerListMap);

    }
}
