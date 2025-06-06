package com.java8.lambda;

/*
* source: https://www.w3resource.com/java-exercises/lambda/index.php
* Sum two integers using lambda expression
* */

public class SumTwoIntegerMain {

    public static void main(String[] args) {
        SumTwoInteger sumTwoInteger = (a, b) ->{
            return a+b;
        };

        int output1 = sumTwoInteger.sum(3, 5);
        System.out.println(output1);
        System.out.println(sumTwoInteger.sum(10, -35));

    }

}
