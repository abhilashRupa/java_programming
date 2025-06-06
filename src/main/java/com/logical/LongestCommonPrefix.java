package com.logical;

import java.util.Arrays;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};

    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    String longestPrefix = longestCommonPrefix.approach1(input);
    System.out.println(longestPrefix);

    String longestPrefixApproach2 = longestCommonPrefix.approach2(input);
    System.out.println(longestPrefixApproach2);
  }

  private String approach1(String[] input) {

    Arrays.sort(input);

    char[] char1 = input[0].toCharArray();
    char[] char2 = input[input.length-1].toCharArray();

    int numberOfIteration = Math.min(char1.length, char2.length);

    StringBuilder builder = new StringBuilder();

    for(int i = 0 ; i < numberOfIteration ; i++){
      if(char1[i] == char2[i]){
        builder.append(char1[i]);

      }
    }
    return builder.toString();
  }

  private String approach2(String[] input){

    Arrays.sort(input);

    String first = input[0];
    String last = input[input.length-1];

    int iterations = Math.min(first.length(), last.length());

    int i = 0;

    while (i < iterations && first.charAt(i) == last.charAt(i)){
      i++;
    }

    return first.substring(0, i);


  }
}
