package com.Leetcode.LeetCode75;

/*
*https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
*
* Problem statement:
* 1768. Merge Strings Alternately
* You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
*
* Return the merged string.
*Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d


Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
*
* */

import java.util.Scanner;

public class MergeAlternatelySolution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the 1st word");
        String word1 = scanner.next();

        System.out.println("Please enter the 2nd word");
        String word2 = scanner.next();


        String mergedString = MergeAlternatelySolution.mergeAlternately(word1, word2);
        System.out.println(mergedString);

    }

    private static String mergeAlternately(String word1, String word2) {

        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();

        int char1Size = char1.length;
        int char2Size = char2.length;

       int highestIndex = Math.max(char1Size, char2Size);

        StringBuilder mergedStringBuilder = new StringBuilder();

        for(int i = 0 ; i < highestIndex ; i++){

            if(i >= char1Size){
                mergedStringBuilder.append(" ");
            }else {
                mergedStringBuilder.append(char1[i]);
            }
            if(i >= char2Size){
                mergedStringBuilder.append(" ");
            }else {
                mergedStringBuilder.append(char2[i]);

            }
        }
        return mergedStringBuilder.toString();
    }



}
