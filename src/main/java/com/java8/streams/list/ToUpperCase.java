package com.java8.streams.list;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* Write a program to convert a list of string to uppercase using Java Stream API.
* */

public class ToUpperCase {

    public static void main(String[] args) {

        List<String> friutList = Arrays.asList("banana", "apple");

        List<String> modifiedList =  friutList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        modifiedList.forEach(System.out::println);

    }

}
