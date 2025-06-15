package com.gfg.gfg160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
*1.
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


//        int secondLargest = largest.getSecondLargest(inputArr);
//        int secondLargest = largest.solution2(inputArr);

        /*Using Sorting*/
//        int secondLargest = largest.solution3(inputArr);

        /*Using Two Pass Search*/
        int secondLargest = largest.solution4(inputArr);


        /*Using One Pass Search*/
//        int secondLargest  = largest.solution5(inputArr);

        System.out.println(secondLargest);

    }


    private int getSecondLargest(int[] inputArr) {
        Arrays.sort(inputArr);

        int secondLargestIndex = inputArr.length - 2;
        boolean isSecondLargestSame = true;

        while (isSecondLargestSame) {

            if (inputArr[secondLargestIndex] == inputArr[0] && inputArr[secondLargestIndex + 1] == inputArr[0])
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

    /*Using Sorting
     *
     * sort the array get the last but one index if it not same as last index
     *
     * */
    private int solution3(int[] inputArr) {

        Arrays.sort(inputArr);
        int arrSize = inputArr.length;


        for (int i = arrSize - 2; i >= 0; i--) {

            if (inputArr[i] != inputArr[arrSize - 1]) {
                return inputArr[i];
            }

        }
        return -1;
    }


    /*Using Two Pass Search
     *
     * first get the largest element in array by iterating and comparing
     *
     * then iterate over the array again and comparing each element find the largest among them and
     *  less than largest.
     *
     * */
    private int solution4(int[] arr) {

        int largest = -1, secondLargest = -1;

//        Finding the largest element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        //Finding the second largest element

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;


    }


    /*Using Two Pass Search
     *
     * use 2 local variable initialize with -1,
     * iterate over the arr and compare each element with highest and secondHighest.
     *
     * if found replace ith existing highest and second Highest
     *
     * */
    private int solution5(int[] arr) {


        int highest = -1, secondHighest = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > highest) {
                secondHighest = highest;
                highest = arr[i];
            } else if (arr[i] < highest && arr[i] > secondHighest) {
                secondHighest = arr[i];
            }
        }
        return secondHighest;
    }


}
