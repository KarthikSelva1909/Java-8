package com.learnJava.ngnix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {



    public static void main(String[] args) {

        int[]  input = {2,3,7,6,8,5};
        int target = 7;

        int[] output = getTwoSumIndices(input,target);
        System.out.println(Arrays.toString(output));


    }

    private static int[] getTwoSumIndices(int[] input, int target) {

        Map<Integer,Integer>  map = new HashMap<>();

        Integer delta;
        for (int i =0;i < input.length;i ++)
        {
            delta = target - input[i];

            if(map.containsKey(delta))
            {
                return new int[] {i,map.get(delta)};
            }
            map.put(input[i], i);
        }

        return new int[] {-1,-1};

    }
}
