package com.java8.streams.list;

import java.util.Arrays;
import java.util.List;

/*
* Write a program to find the sum of all elements in a list using Java Stream API
* */
public class SumOfNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        int sumOfNumber = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sumOfNumber);

    }

}
