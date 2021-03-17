package com.learnJava.ngnix;

import java.util.HashSet;

public class LengthOfLongestSubString {

    public static void main(String[] args) {

        System.out.println(getLenghtOfMaximumSubStringwithoutRepeating("geeksforgeeks"));
        System.out.println(getLenghtOfMaximumSubStringwithoutRepeating("bbbbbb"));
    }

    private static int getLenghtOfMaximumSubStringwithoutRepeating(String s) {

        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet<>();

        while (b_pointer < s.length()) {

            if(!hashSet.contains(s.charAt(b_pointer)))
            {
                hashSet.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(hashSet.size(),max);
            }

            else
            {
                hashSet.remove(s.charAt(a_pointer));
                a_pointer++;
            }


        }
        return max;

    }
}
