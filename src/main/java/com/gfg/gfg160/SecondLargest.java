package com.gfg.gfg160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
*
* https://www.geeksforgeeks.org/batch/gfg-160-problems/track/arrays-gfg-160/problem/second-largest3735
*
* Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

Note: The second largest element should not be equal to the largest element.

Examples:

Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.
Input: arr[] = [10, 10, 10]
Output: -1
Explanation: The largest element of the array is 10 and the second largest element does not exist.
*
* */

public class SecondLargest {

    public static void main(String[] args) {

        SecondLargest largest = new SecondLargest();
//        int[] inputArr = {12, 35, 1, 10, 34, 1};
//        int[] inputArr = {12, 35, 1, 10, 34, 1, 35, 35};
//        int[] inputArr = {10, 10, 10};
        int[] inputArr = {10, 5, 10};


        int secondLargest = largest.getSecondLargest(inputArr);
//        int secondLargest = largest.solution2(inputArr);
        System.out.println(secondLargest);

    }

    private int getSecondLargest(int[] inputArr) {
        Arrays.sort(inputArr);

        int secondLargestIndex = inputArr.length - 2;
        boolean isSecondLargestSame = true;

        while (isSecondLargestSame) {

            if (inputArr[secondLargestIndex] == inputArr[0] && inputArr[secondLargestIndex+1] == inputArr[0])
                return -1;

            if (inputArr[secondLargestIndex] == inputArr[inputArr.length - 1]) {
                secondLargestIndex = secondLargestIndex - 1;
            } else {
                isSecondLargestSame = false;
            }
        }
        return inputArr[secondLargestIndex];
    }

    private int solution2(int[] inputArr) {

        List<Integer> numbers = new ArrayList<>();
        for (int i : inputArr) {
            numbers.add(i);
        }


        return numbers.stream()
                .distinct()
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .skip(1)
                .findFirst().orElse(-1);

    }

}
