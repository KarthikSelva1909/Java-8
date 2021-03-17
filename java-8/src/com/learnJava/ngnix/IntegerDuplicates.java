package com.learnJava.ngnix;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntegerDuplicates {


    public static void main(String[] args) {

        List<Integer> integerList = List.of(1,3,4,5,2,1,4);

       Map<Integer,Long> integerLongMap = integerList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(integerLongMap);
    }
}
