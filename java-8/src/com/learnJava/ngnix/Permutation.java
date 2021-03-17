package com.learnJava.ngnix;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public static void main(String[] args) {

        System.out.println(getAllPermutations("ABC"));
    }

    public static HashSet<String> getAllPermutations(String str)
    {
        HashSet<String> hashSet = new HashSet<>();

        if(str.length() == 0 || str == null)
        {
            hashSet.add("");
            return  hashSet;
        }

        char first = str.charAt(0);
        String remainigString = str.substring(1);
        HashSet<String> words = getAllPermutations(remainigString);
        for (String word : words)
        {
            for (int i = 0;i<=word.length();i++)
            {
                String prefix = word.substring(0,i);
                String suffix = word.substring(i);
                hashSet.add(prefix + first +suffix);
            }
        }

        return hashSet;
    }
}
