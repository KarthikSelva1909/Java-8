package com.learnJava.ngnix;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDuplicates {


    public static void main(String[] args) {

        List<String> stringList = List.of("1","2","4","3","1","4");

       Map<String,Long> integerLongMap = stringList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(integerLongMap);
    }
}
