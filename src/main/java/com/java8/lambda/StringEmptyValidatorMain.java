package com.java8.lambda;


/*
* Source: https://www.w3resource.com/java-exercises/lambda/index.php
*
*
* Check if a string is empty using lambda
* */

public class StringEmptyValidatorMain {

    public static void main(String[] args) {
        StringEmptyValidator stringEmptyValidator = s -> {
            boolean isEmpty = false;

            if(s == null || s.length() == 0 || (s.length()==1 && s.charAt(0) == ' '))
                isEmpty = true;

            return isEmpty;

        };

        System.out.println(stringEmptyValidator.isStringEmpty(" "));
        System.out.println(stringEmptyValidator.isStringEmpty(null));
        System.out.println(stringEmptyValidator.isStringEmpty(""));
        System.out.println(stringEmptyValidator.isStringEmpty("ab"));
    }
}
