package com.gfg.array;

/*Given an array arr[] of size N-1 with integers in the range of [1, N], the task is to find the missing number from the first N integers.
*
* Input: arr[] = {1, 2, 4, 6, 3, 7, 8} , N = 8
Output: 5
Explanation: Here the size of the array is 8, so the range will be [1, 8]. The missing number between 1 to 8 is 5
*
* */

import static java.lang.reflect.Array.set;
import static java.util.EnumSet.range;

public class FindMissingNumber {

    public static void main(String[] args) {
		
		int[] inputArray = {1, 2, 3, 5};
//		int[] inputArray = {1, 2, 4, 6, 3, 7, 8};
		int missingNumber = findMissingNumber(inputArray);
		
		System.out.println("missing number is: "+missingNumber);


    }
	private static int findMissingNumber(int[] inputArray){
		int arraySize = inputArray.length;
		int newArraySize = arraySize+1;
		
		int sumOfNaturalNumber = (newArraySize*(newArraySize+1))/2;
		
		int sumOfGivenArray = 0;
		
		for(int i : inputArray){
			sumOfGivenArray = sumOfGivenArray+i;
		}
		
		return sumOfNaturalNumber-sumOfGivenArray;
		
		
	}

}
