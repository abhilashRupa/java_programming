package com.java8.streams.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* Write a program to filter out all even number from a list using Java Stream API
* */

public class EvenNumbers {
    public static void main(String[] args) {

        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> evenNumbers = numberList.stream()
                .filter(num -> num % 2  == 0)
                .collect(Collectors.toList());

        evenNumbers.forEach(System.out::println);

    }
}
