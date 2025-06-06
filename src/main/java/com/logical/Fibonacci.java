package com.logical;

public class Fibonacci {
    public static void main(String[] args) {

        approach1();

        printFibonacciNumberLessThanN();

        printFibonacciNumberLessThanN1();
    }

    /*Iterative Approach*/
    private static void approach1() {

        int firstNum = 0, secondNum = 1;
        int n = 10;

        for (int i = 0; i < n; i++) {

            System.out.println(firstNum);

            int nexFib = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = nexFib;


        }
    }

    /*Iterative Approach*/
    private static void printFibonacciNumberLessThanN() {

        int firstNum = 0, secondNum = 1;

        int limit = 100;

        while (firstNum < limit) {

            System.out.println(firstNum);
            int nextFib = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = nextFib;
        }
    }

    /*Iterative Approach*/
    private static void printFibonacciNumberLessThanN1() {

        int firstNum = 0, secondNum = 1;
        int limit = 100;

        boolean fibFlag = true;
        while (fibFlag) {

            if (firstNum > limit) {
                fibFlag = false;
                break;
            }

            System.out.println(firstNum);

            int nextFib = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = nextFib;


        }

    }

    /*
    * todo - Recursive Approach
    *
    * */


}
