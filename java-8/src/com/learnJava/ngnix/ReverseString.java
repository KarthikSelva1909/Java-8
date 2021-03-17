package com.learnJava.ngnix;

public class ReverseString {

    public static void main(String[] args) {

        String name = "Hello World !";

        System.out.println(usingStringBuilder(name));
        System.out.println(usingStringManually(name));
    }

    private static String usingStringManually(String name) {

       StringBuilder rev = new StringBuilder();

        for(int i = name.length()-1;i >=0;i--)
        {
            rev.append(name.charAt(i));
        }

        return rev.toString();
    }

    private static String usingStringBuilder(String name) {

        return new StringBuilder(name).reverse().toString();
    }
}
